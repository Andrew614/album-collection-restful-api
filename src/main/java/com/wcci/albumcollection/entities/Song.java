package com.wcci.albumcollection.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Album album;
	
	
	private String title;
	private String link;
	private String time;
	
	
	public Song(String title, String link, String time) {
		this.title = title;
		this.link = link;
		this.time = time;
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
	
	
}
