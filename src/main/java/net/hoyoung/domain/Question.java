package net.hoyoung.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {



	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String contents;
	
	private String writer;

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", contents=" + contents + ", wirter=" + writer + "]";
	}
	
	public Question() {
	}
	
	public Question(String title, String contents, String writer) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
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

}
