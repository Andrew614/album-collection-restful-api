package com.wcci.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.albumcollection.entities.Song;

public interface SongRepository extends CrudRepository<Song, Long> {

}
