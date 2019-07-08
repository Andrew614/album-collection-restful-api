package com.wcci.albumcollection.entities;

import java.sql.Time;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	private String link;
	private Time time;
	
	public Song(long id, String link, Time time) {
		super();
		this.id = id;
		this.link = link;
		this.time = time;
	}
	
	public Song(String link, Time time) {
		super();
		this.link = link;
		this.time = time;
	}
	
	@SuppressWarnings("unused")
	private Song() {
		
	}

	public long getId() {
		return id;
	}

	public String getLink() {
		return link;
	}

	public Time getTime() {
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
