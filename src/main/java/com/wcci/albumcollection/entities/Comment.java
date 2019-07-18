package com.wcci.albumcollection.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private Long id;

	@Lob
	private String body;

	private String commenter;

	private LocalDateTime dateTime;

	public Comment(String body, String commenter) {
		this.body = body;
		this.commenter = commenter;
		this.dateTime = LocalDateTime.now();
	}

	@SuppressWarnings("unused")
	private Comment() {

	}
	
	public Long getId() {
		return id;
	}

	public String getBody() {
		return body;
	}

	public String getCommenter() {
		return commenter;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

}
