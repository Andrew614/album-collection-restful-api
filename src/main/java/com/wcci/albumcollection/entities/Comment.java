package com.wcci.albumcollection.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Long id;

	@Lob
	private String body;

	private String commenter;

	private LocalDateTime dateTime;

	@ManyToOne
	private Artist artist;
	
	@ManyToOne
	private Album album;

	@ManyToOne
	private Song song;

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

	public void addArtist(Artist artist) {
		this.artist = artist;
	}

	public void addAlbum(Album album) {
		this.album = album;
		
	}

	@Override
	public int hashCode() {
		final int prime = 7919;
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
		Comment other = (Comment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void addSong(Song song) {
		this.song = song;
		
	}


}
