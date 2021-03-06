package com.wcci.albumcollection.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String imageUrl;
	private String dateOfBirth;
	private String homeTown;
	
	@OneToMany(mappedBy = "artist")
	private Collection<Album> albums;
	
	@OneToMany
	private Collection<Comment> comments;

	public Artist(String name, String imageUrl, String dateOfBirth, String homeTown) {
		this.name = name;
		this.imageUrl = imageUrl;
		this.dateOfBirth = dateOfBirth;
		this.homeTown = homeTown;
		this.albums = new ArrayList<Album>();
	}

	@SuppressWarnings("unused")
	private Artist() {

	}

	public Artist(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getHomeTown() {
		return homeTown;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
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
		Artist other = (Artist) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
