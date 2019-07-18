package com.wcci.albumcollection.controllertests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wcci.albumcollection.controllers.TagController;
import com.wcci.albumcollection.entities.Tag;
import com.wcci.albumcollection.repositories.TagRepository;

public class TagControllerTest {
	
	@InjectMocks
	private TagController underTest;
	@Mock
	private TagRepository tagRepo;
	@Mock
	private Tag mockTag;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnListOfAlbum() {
		when(tagRepo.findAll()).thenReturn(Collections.singletonList(mockTag));
		assertThat(underTest.findAllTags(), contains(mockTag));
	}
	@Test
	public void shouldReturnASingleTag() {
		when(tagRepo.findById(1L)).thenReturn(Optional.of(mockTag));
		assertThat(underTest.findOneTag(1L), is(mockTag));
	}

}
