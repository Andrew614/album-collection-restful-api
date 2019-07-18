package com.wcci.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.albumcollection.entities.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	
}
