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

import com.wcci.albumcollection.controllers.AlbumController;
import com.wcci.albumcollection.entities.Album;
import com.wcci.albumcollection.repositories.AlbumRepository;

public class AlbumControllerTest {

	@InjectMocks
	private AlbumController underTest;
	@Mock
	private AlbumRepository albumRepo;
	@Mock
	private Album mockAlbum;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void shouldReturnListOfAlbums() {
		when(albumRepo.findAll()).thenReturn(Collections.singletonList(mockAlbum));
		assertThat(underTest.findAllAlbums(), contains(mockAlbum));

	}

	@Test
	public void shouldReturnASingleAlbum() {
		when(albumRepo.findById(1L)).thenReturn(Optional.of(mockAlbum));
		assertThat(underTest.findOneAlbum(1L), is(mockAlbum));
	}
	
	@Test
	public void shouldAddCommentToAlbum() {
		when(albumRepo.findById(1L)).thenReturn(Optional.of(mockAlbum));
		when(albumRepo.save(any(Album.class))).thenReturn(mockAlbum);
		String comment;
		comment = "foo";
		Album retrievedAlbum;
		retrievedAlbum = underTest.addCommentToAlbum(1L, comment);
		assertThat(retrievedAlbum, is(mockAlbum));
	}

}
