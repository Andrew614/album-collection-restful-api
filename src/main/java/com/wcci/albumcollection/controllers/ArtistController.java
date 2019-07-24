package com.wcci.albumcollection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.albumcollection.entities.Artist;
import com.wcci.albumcollection.repositories.ArtistRepository;

@RestController
@RequestMapping("/api")
public class ArtistController {

	@Autowired
	private ArtistRepository artistRepo;

	@GetMapping("/artists")
	@CrossOrigin
	public Iterable<Artist> findAllArtists() {
		return artistRepo.findAll();
	}

	@GetMapping("/artists/{id}")
	public Artist findOneArtist(@PathVariable Long id) {
		return artistRepo.findById(id).get();
	}

	@PostMapping("/artists")
	public Iterable<Artist> postOneArtist(@RequestBody Artist artist) {
		artistRepo.save(artist);
		return artistRepo.findAll();
	}
}