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

import com.wcci.albumcollection.controllers.SongController;
import com.wcci.albumcollection.entities.Song;
import com.wcci.albumcollection.repositories.SongRepository;


public class SongControllerTest {

	@InjectMocks
	private SongController underTest;
	@Mock
	private SongRepository songRepo;
	@Mock
	private Song mockSong;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void shouldReturnListOfSongs() {
		when(songRepo.findAll()).thenReturn(Collections.singletonList(mockSong));
		assertThat(underTest.findAllSongs(), contains(mockSong));

	}

	@Test
	public void shouldReturnASingleSong() {
		when(songRepo.findById(1L)).thenReturn(Optional.of(mockSong));
		assertThat(underTest.findOneSong(1L), is(mockSong));
	}

}
