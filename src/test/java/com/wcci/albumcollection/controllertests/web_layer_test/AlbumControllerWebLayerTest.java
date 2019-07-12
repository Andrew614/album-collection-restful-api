package com.wcci.albumcollection.controllertests.web_layer_test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcci.albumcollection.controllers.AlbumController;
import com.wcci.albumcollection.entities.Album;
import com.wcci.albumcollection.entities.Song;
import com.wcci.albumcollection.repositories.AlbumRepository;

@WebMvcTest(AlbumController.class)
@RunWith(SpringRunner.class)
public class AlbumControllerWebLayerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	AlbumRepository albumRepo;
	private Album testAlbum;
	
	private Song song1;
	private Song song2;
	private Collection<Song> songCollection;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void setup() {
		song1 = new Song("title1", "link1", "time1");
		song2 = new Song("title2", "link2", "time2");
		songCollection = new ArrayList<Song>();
		songCollection.add(song1);
		songCollection.add(song2);
		testAlbum = new Album("title", "imageUrl", songCollection, "recordLabel");
		
	}
	@Test
	public void fetchCollectionOfAlbums() throws Exception {
		when(albumRepo.findAll()).thenReturn(Collections.singletonList(testAlbum));
		mockMvc.perform(get("/api/albums"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json("[{}]"))
		.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testAlbum)), true));
	}
	
	@Test
	public void fetchSingleAlbum() throws Exception {
		when(albumRepo.findById(1L)).thenReturn(Optional.of(testAlbum));
		mockMvc.perform(get("/api/albums/1"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json("{}"))
		.andExpect(content().json(mapper.writeValueAsString(testAlbum), true));
	}
	
	
	
	
	
	
}
