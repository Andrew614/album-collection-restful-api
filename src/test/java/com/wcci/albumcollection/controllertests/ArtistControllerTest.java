package com.wcci.albumcollection.controllertests;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.wcci.albumcollection.controllers.ArtistController;
import com.wcci.albumcollection.entities.Artist;
import com.wcci.albumcollection.repositories.ArtistRepository;

public class ArtistControllerTest {

	@InjectMocks
	private ArtistController underTest;
	@Mock
	private ArtistRepository artistRepo;
	@Mock
	private Artist mockArtist;
	@Mock
	private Artist mockArtist2;
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockArtist2.addComment("foo");
	}
	@Test
	public void shouldReturnListOfArtists() {
		when(artistRepo.findAll()).thenReturn(Collections.singletonList(mockArtist));
		assertThat(underTest.findAllArtists(), contains(mockArtist));
		
	}
	
	@Test
	public void shouldReturnASingleArtist() {
		when(artistRepo.findById(1L)).thenReturn(Optional.of(mockArtist));
		assertThat(underTest.findOneArtist(1L), is(mockArtist));
	}
	
	@Test
	public void shouldAddCommentToArtist() {
		when(artistRepo.findById(1L)).thenReturn(Optional.of(mockArtist));
		when(artistRepo.save(any(Artist.class))).thenReturn(mockArtist2);
		String comment = "foo";
		Artist retrievedArtist;
		retrievedArtist = underTest.addCommentToArtist(1L, comment);
		assertThat(retrievedArtist, is(mockArtist2));
	}
	
}

