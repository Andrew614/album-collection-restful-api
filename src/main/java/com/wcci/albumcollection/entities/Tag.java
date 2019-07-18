package com.wcci.albumcollection.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToMany
	private Collection<Song> songs;
	
	private String content;
	
	public Tag(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public Collection<Song> getSongs() {
		return songs;
	}

	public String getContent() {
		return content;
	}

	public void changeContent(String newContent) {
		this.content = newContent;
		
	}
	
}
