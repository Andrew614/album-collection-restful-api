package com.wcci.albumcollection.controllertests.web_layer_test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcci.albumcollection.controllers.ArtistController;
import com.wcci.albumcollection.entities.Artist;
import com.wcci.albumcollection.repositories.ArtistRepository;

@WebMvcTest(ArtistController.class)
@RunWith(SpringRunner.class)
public class ArtistControllerWebLayerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ArtistRepository artistRepo;
	
	private Artist testArtist;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void setup() {
		testArtist = new Artist("name", "url", "1992", "somewhere in nowhere");
	}
	
	@Test
	public void fetchCollectionOfArtists() throws Exception {
		when(artistRepo.findAll()).thenReturn(Collections.singletonList(testArtist));
		mockMvc.perform(get("/api/artists")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json("[{}]"))
		.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testArtist)), true));;
	}

	@Test
	public void fetchSingleArtist() throws Exception {
		when(artistRepo.findById(1L)).thenReturn(Optional.of(testArtist));
		mockMvc.perform(get("/api/artists/1")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(content().json("{}"))
		.andExpect(content().json(mapper.writeValueAsString(testArtist), true));
	}
	
	@Test
	public void createSingleArtist() throws Exception {
		when(artistRepo.save(any(Artist.class))).thenReturn(testArtist);
		mockMvc.perform(post("/api/artists/name").content("name")).andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is("name")));
		
		
		}
	
	@Test
	public void shouldUpdateArtistName() throws Exception {
		when(artistRepo.findById(1L)).thenReturn(Optional.of(testArtist));
		String name = "other name";
		when(artistRepo.save(any(Artist.class))).thenReturn(new Artist(name));
		
		mockMvc.perform(put("/api/artists/1/" + name)).andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is("other name")));
	}
	
	
	
	
}
