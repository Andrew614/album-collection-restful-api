package com.wcci.albumcollection.controllertests.web_layer_test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcci.albumcollection.controllers.AlbumController;
import com.wcci.albumcollection.entities.Album;
import com.wcci.albumcollection.entities.Artist;
import com.wcci.albumcollection.repositories.AlbumRepository;

@WebMvcTest(AlbumController.class)
@RunWith(SpringRunner.class)
public class AlbumControllerWebLayerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	AlbumRepository albumRepo;
	private Artist artist;
	private Album testAlbum;
	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setup() {
		artist = new Artist("name", "imageUrl", "DOB", "Home Town");
		testAlbum = new Album(artist, "title", "imageUrl", "recordLabel");
	
	}

	@Test
	public void fetchCollectionOfAlbums() throws Exception {
		when(albumRepo.findAll()).thenReturn(Collections.singletonList(testAlbum));
		mockMvc.perform(get("/api/albums")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("[{}]"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testAlbum)), true));
	}

	@Test
	public void fetchSingleAlbum() throws Exception {
		when(albumRepo.findById(1L)).thenReturn(Optional.of(testAlbum));
		mockMvc.perform(get("/api/albums/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("{}"))
				.andExpect(content().json(mapper.writeValueAsString(testAlbum), true));
	}
	@Test
	public void createSingleAlbum() throws Exception {
		when(albumRepo.save(any(Album.class))).thenReturn(testAlbum);
		when(albumRepo.findAll()).thenReturn(Collections.singletonList(testAlbum));
		mockMvc.perform(post("/api/albums")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(testAlbum)))
				.andExpect(status().isOk())
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testAlbum))));
		
				
		
	}

	
	
	

	
	
	
}
