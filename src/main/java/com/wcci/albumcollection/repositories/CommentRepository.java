package com.wcci.albumcollection.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wcci.albumcollection.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
