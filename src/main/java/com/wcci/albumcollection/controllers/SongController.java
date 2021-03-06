package com.wcci.albumcollection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.albumcollection.entities.Song;
import com.wcci.albumcollection.repositories.SongRepository;

@RestController
@RequestMapping("/api")
public class SongController {

	@Autowired
	private SongRepository songRepo;

	@GetMapping("/songs")
	@CrossOrigin
	public Iterable<Song> findAllSongs() {
		return songRepo.findAll();
	}

	@GetMapping("/songs/{id}")
	@CrossOrigin
	public Song findOneSong(@PathVariable Long id) {
		return songRepo.findById(id).get();
	}

	@PostMapping("/songs")
	public Iterable<Song> postOneSong(Song song) {
		songRepo.save(song);
		return songRepo.findAll();
	}
	
	
}

