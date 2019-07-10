package com.wcci.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.albumcollection.entities.Album;

public interface AlbumRepository extends CrudRepository<Album, Long> {

	Album findByTitle(String title);

}
