package net.hoyoung.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", contents=" + contents + ", wirter=" + wirter + "]";
	}

	public Question(String title, String contents, String wirter) {
		super();
		this.title = title;
		this.contents = contents;
		this.wirter = wirter;
	}

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String contents;
	
	private String wirter;

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

	public String getWirter() {
		return wirter;
	}

	public void setWirter(String wirter) {
		this.wirter = wirter;
	}
}
