package com.wcci.albumcollection.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JsonIgnore
	private Album album;
	
	
	private String title;
	private String link;
	private String time;
	
	@OneToMany
	private Collection<Comment> comments;
	
	
	public Song(Album album, String title, String link, String time) {
		this.album = album;
		this.title = title;
		this.link = link;
		this.time = time;
	}
	
	public Song(String title) {
		this.title = title;
	}

	@SuppressWarnings("unused")
	private Song() {
		
	}

	
	public String getTitle() {
		return title;
	}

	public Long getId() {
		return id;
	}

	public Album getAlbum() {
		return album;
	}


	public String getLink() {
		return link;
	}

	public String getTime() {
		return time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Song other = (Song) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void changeTitle(String newTitle) {
		title = newTitle;
		
	}
	
	
}
