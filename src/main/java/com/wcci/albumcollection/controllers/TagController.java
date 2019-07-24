package com.wcci.albumcollection.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.albumcollection.entities.Tag;
import com.wcci.albumcollection.repositories.TagRepository;

@RestController
@RequestMapping("/api")
public class TagController {

	@Autowired
	private TagRepository tagRepo;

	@GetMapping("/tags")
	@CrossOrigin
	public Iterable<Tag> findAllTags() {
		return tagRepo.findAll();
	}

	@GetMapping("/tags/{id}")
	public Tag findOneTag(@PathVariable Long id) {
		return tagRepo.findById(id).get();
	}

	@PostMapping("/tags/{content}")
	public Tag postOneTag(@PathVariable String content) {
		return tagRepo.save(new Tag(content));
	}

	@PutMapping("/tags/{id}/{newContent}")
	public Tag updateTag(@PathVariable Long id, @PathVariable String newContent) {
		Tag tagToModify = tagRepo.findById(id).get();
		tagToModify.changeContent(newContent);
		return tagRepo.save(tagToModify);
	}

}
