package com.wcci.albumcollection.entities;



import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Album {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Artist artist;

	@OneToMany
	private Collection<Song> songs;
	
	private String title;
	private String imageUrl;
	private String recordLabel;
	

	public Album(String title, String imageUrl, Collection<Song> songs, String recordLabel) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.recordLabel = recordLabel;
		this.songs = songs;
	}
	public Album(String title) {
		this.title = title;
	}
	@SuppressWarnings("unused")
	private Album() {
		
	}

	public Long getId() {
		return id;
	}


	public Collection<Song> getSongs() {
		return songs;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getRecordLabel() {
		return recordLabel;
	}
	
	public void addSong(Song song) {
		if (doesNotContainSong(song)) {
			this.songs.add(song);
		}
	}
	
	private boolean doesNotContainSong(Song song) {
		return !songs.contains(song);
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
