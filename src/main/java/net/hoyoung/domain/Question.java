package net.hoyoung.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Question {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@Lob
	private String contents;
	
	@JsonProperty
	private Integer countOfAnswer;

	private LocalDateTime createDate;
	
	@OneToMany(mappedBy="question")
	@OrderBy("id DESC")
	private List<Answer> answers;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
	private User writer;

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", contents=" + contents + ", wirter=" + writer + "]";
	}

	public Question() {
	}

	public Question(String title, String contents, User writer) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.createDate = LocalDateTime.now();
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getFormattedCreateDate() {
		if (createDate == null) {
			return "";
		}
		return createDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}

	public void update(String title, String contents) {
		this.title = title;
		this.contents = contents;
	}

	public boolean isSameUser(User loginUser) {
		return this.writer.equals(loginUser);
	}

	public Integer getCountOfAnswer() {
		return countOfAnswer;
	}

	public void setCountOfAnswer(Integer countOfAnswer) {
		this.countOfAnswer = countOfAnswer;
	}
	
	public void addAnswer(){
		this.countOfAnswer += 1;
	}
	
	public void deleteAnswer(){
		this.countOfAnswer -= 1;
	}
}
