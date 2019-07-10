package com.wcci.albumcollection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.wcci.albumcollection.entities.Artist;
import com.wcci.albumcollection.repositories.ArtistRepository;

public class ArtistController {

	@Autowired
	private ArtistRepository artistRepo;
	public Iterable <Artist> findAllArtists() {
		return artistRepo.findAll();
	}
	public Artist findOneArtist(@PathVariable Long id) {
		return artistRepo.findById(id).get();
	}


}
