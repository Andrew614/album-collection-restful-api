package com.wcci.albumcollection.controllertests.web_layer_test;

import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wcci.albumcollection.controllers.SongController;
import com.wcci.albumcollection.entities.Album;
import com.wcci.albumcollection.entities.Artist;
import com.wcci.albumcollection.entities.Song;
import com.wcci.albumcollection.repositories.AlbumRepository;
import com.wcci.albumcollection.repositories.SongRepository;

@WebMvcTest(SongController.class)
@RunWith(SpringRunner.class)
public class SongControllerWebLayerTest {
	@Autowired
	MockMvc mockMvc;
	@MockBean
	AlbumRepository albumRepo;
	@MockBean
	SongRepository songRepo;
	private Song testSong1;
	private Song testSong2;
	private Album testAlbum;
	private Artist testArtist;
	

	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setup() {
		testAlbum = new Album(testArtist, "title","imageUrl", "recordLabel");
		testSong1 = new Song(testAlbum, "title1", "link1", "time1");
		testSong2 = new Song(testAlbum, "title2", "link1", "time1");
	}

	@Test
	public void fetchCollectionOfSongs() throws Exception {
		when(songRepo.findAll()).thenReturn(Collections.singletonList(testSong1));
		mockMvc.perform(get("/api/songs")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("[{}]"))
				.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testSong1)), true));

	}

	@Test
	public void fetchSingleSong() throws Exception {
		when(songRepo.findById(1L)).thenReturn(Optional.of(testSong1));
		mockMvc.perform(get("/api/songs/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("{}"))
				.andExpect(content().json(mapper.writeValueAsString(testSong1), true));
	}

	@Test
	public void postSingleSong() throws Exception {
		when(songRepo.save(any(Song.class))).thenReturn(testSong1);
		mockMvc.perform(post("/api/songs/title1").content("title1")).andExpect(status().isOk())
				.andExpect(jsonPath("$.title", is("title1")));
	}

	@Test
	public void shouldChangeSongTitle() throws Exception {
		when(songRepo.findById(1L)).thenReturn(Optional.of(testSong1));
		String title = "other title";
		when(songRepo.save(any(Song.class))).thenReturn(new Song(title));

		mockMvc.perform(put("/api/songs/1/" + title)).andExpect(status().isOk())
				.andExpect(jsonPath("$.title", is("other title")));
	}

}
