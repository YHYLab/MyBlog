package net.hoyoung.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue
	private Long id;

	@Lob
	private String contents;

	private LocalDateTime createDate;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
	private User writer;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_quetion"))
	private Question question;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Answer other = (Answer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
		return "Answer [id=" + id + ", contents=" + contents + ", crateDate=" + createDate + ", writer=" + writer + "]";
	}

	public String getFormattedCreateDate() {
		if (createDate == null) {
			return "";
		}
		return createDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}

}
