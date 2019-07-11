package com.wcci.albumcollection.entities;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
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

	@OneToMany(mappedBy = "artist")
	private Collection<Album> albums;

	private String name;
	private String imageUrl;
	private Year dateOfBirth;
	private String homeTown;

	public Artist(String name, String imageUrl, Year dateOfBirth, String homeTown) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.albums = Arrays.asList();
		this.dateOfBirth = dateOfBirth;
		this.homeTown = homeTown;
		this.albums = new ArrayList<Album>();
	}

	public Artist() {

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

	public Year getDateOfBirth() {
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
