package com.wcci.albumcollection.entities;

import java.time.LocalDate;
import java.util.Collection;

public class Artist {
	
	private long id;
	private String name;
	private String imageUrl;
	private Collection<Album> albums;
	private LocalDate dateOfBirth;
	private String homeTown;
	
	public Artist(long id, String name, String imageUrl, Collection<Album> albums, LocalDate dateOfBirth,
			String homeTown) {
		super();
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.albums = albums;
		this.dateOfBirth = dateOfBirth;
		this.homeTown = homeTown;
	}

	public Artist(String name, String imageUrl, Collection<Album> albums, LocalDate dateOfBirth, String homeTown) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.albums = albums;
		this.dateOfBirth = dateOfBirth;
		this.homeTown = homeTown;
	}
	
	public Artist() {
		
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Collection<Album> getAlbums() {
		return albums;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getHomeTown() {
		return homeTown;
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
		Artist other = (Artist) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
