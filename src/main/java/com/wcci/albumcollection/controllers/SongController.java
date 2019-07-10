package com.wcci.albumcollection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.wcci.albumcollection.entities.Song;
import com.wcci.albumcollection.repositories.SongRepository;



public class SongController {

	@Autowired
	private SongRepository songRepo;

	public Iterable<Song> findAllSongs() {
		return songRepo.findAll();
	}

	public Song findOneSong(@PathVariable Long id) {
		return songRepo.findById(id).get();
	}

}

