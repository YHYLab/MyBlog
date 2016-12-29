String.prototype.format = function() {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function(match, number) {
    return typeof args[number] != 'undefined'
        ? args[number]
        : match
        ;
  });
};

$(".answer-write input[type=submit]").click(addAnswer);
function addAnswer(e){
	e.preventDefault();
	console.log("click me!");
	
	var query_string = $(".answer-write").serialize();
	console.log("query : " + query_string);
	var url = $(".answer-write").attr("action");
	
	console.log("url : " + url);
	
	$.ajax({
		type : 'post',
		url : url,
		data : query_string,
		dataType : 'json',
		error : onError,
		success : onSuccess
	});
}

function onError(){
	
}

function onSuccess(data){
	console.log(data);
	var answerTemplate = $("#answerTemplate").html();
	var template = answerTemplate.format(data.writer.name, data.formattedCreateDate, data.contents, data.question.id, data.id);
	$(".qna-comment-slipp-articles").prepend(template);
	$("textarea[name=contents]").val("");
}


$("a.link-delete-article").click(deleteAnswer);

function deleteAnswer(e){
	e.preventDefault();
	
	console.log("click delete!!");
	var deleteBtn = $(this);
	var url = deleteBtn.attr("href");
	console.log("url = " + url);
	
	$.ajax({
		type : 'post',
		url : url,
		dataType : 'json',
		error : function(xhr, status){
			console.log("error");
		},
		success : function(data, status){
			console.log(data);
			if(data.valid){
				deleteBtn.closest('article').remove();
			}else{
				console.log(data.errMessage);
			}
		}
	});
	
}