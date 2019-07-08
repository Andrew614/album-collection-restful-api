package com.wcci.albumcollection.entities;

import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Album {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String imageUrl;
	private Collection<Song> songs;
	private String recordLabel;
	
	public Album(long id, String title, String imageUrl, Collection<Song> songs, String recordLabel) {
		super();
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.songs = songs;
		this.recordLabel = recordLabel;
	}

	public Album(String title, String imageUrl, Collection<Song> songs, String recordLabel) {
		super();
		this.title = title;
		this.imageUrl = imageUrl;
		this.songs = songs;
		this.recordLabel = recordLabel;
	}
	
	public Album() {
		
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Collection<Song> getSongs() {
		return songs;
	}

	public String getRecordLabel() {
		return recordLabel;
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
		Album other = (Album) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
