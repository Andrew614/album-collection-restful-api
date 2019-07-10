package com.wcci.albumcollection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.wcci.albumcollection.entities.Album;
import com.wcci.albumcollection.repositories.AlbumRepository;


public class AlbumController {

	@Autowired
	private AlbumRepository albumRepo;

	public Iterable<Album> findAllAlbums() {
		return albumRepo.findAll();
	}

	public Album findOneAlbum(@PathVariable Long id) {
		return albumRepo.findById(id).get();
	}

}

