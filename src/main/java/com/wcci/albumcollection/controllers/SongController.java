package com.wcci.albumcollection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.albumcollection.entities.Song;
import com.wcci.albumcollection.repositories.SongRepository;

@RestController
@RequestMapping("/api")
public class SongController {

	@Autowired
	private SongRepository songRepo;

	@RequestMapping("/songs")
	public Iterable<Song> findAllSongs() {
		return songRepo.findAll();
	}

	@RequestMapping("/songs/{id}")
	public Song findOneSong(@PathVariable Long id) {
		return songRepo.findById(id).get();
	}

}

