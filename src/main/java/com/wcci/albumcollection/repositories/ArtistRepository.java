package com.wcci.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.albumcollection.entities.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

}
