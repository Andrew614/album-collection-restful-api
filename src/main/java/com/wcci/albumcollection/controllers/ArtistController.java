package com.wcci.albumcollection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Iterable<Artist> findAllArtists() {
		return artistRepo.findAll();
	}

	@GetMapping("/artists/{id}")
	public Artist findOneArtist(@PathVariable Long id) {
		return artistRepo.findById(id).get();
	}

	@PostMapping("/artists/{name}")
	public Artist postOneArtist(@PathVariable String name) {
		Artist artist = new Artist(name);
		return artistRepo.save(artist);

	}

	@PutMapping("/artists/{id}/comments")
	public Artist addCommentToArtist(@PathVariable Long id, String comment) {
		Artist artist;
		artist = artistRepo.findById(id).get();
		artist.addComment(comment);
		return artistRepo.save(artist);
	}
}