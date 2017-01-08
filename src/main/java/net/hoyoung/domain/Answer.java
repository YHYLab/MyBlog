package net.hoyoung.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Answer extends AbstractEntity{

	@Lob
	private String contents;

	private LocalDateTime createDate;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
	private User writer;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_quetion"))
	private Question question;

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public LocalDateTime getCrateDate() {
		return createDate;
	}

	public void setCrateDate(LocalDateTime crateDate) {
		this.createDate = crateDate;
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}


	public Answer(Question question, String contents, User writer) {
		this.contents = contents;
		this.createDate = LocalDateTime.now();
		this.writer = writer;
		this.question = question;
	}

	public Answer() {
	}

	@Override
	public String toString() {
		return "Answer [id=" + getId() + ", contents=" + contents + ", crateDate=" + createDate + ", writer=" + writer + "]";
	}

	public String getFormattedCreateDate() {
		if (createDate == null) {
			return "";
		}
		return createDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}

}
