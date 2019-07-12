package com.wcci.albumcollection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.albumcollection.entities.Album;
import com.wcci.albumcollection.repositories.AlbumRepository;

@RestController
@RequestMapping("/api")
public class AlbumController {

	@Autowired
	private AlbumRepository albumRepo;

	@RequestMapping("/albums")
	public Iterable<Album> findAllAlbums() {
		return albumRepo.findAll();
	}
	@RequestMapping("/albums/{id}")
	public Album findOneAlbum(@PathVariable Long id) {
		return albumRepo.findById(id).get();
	}

}

