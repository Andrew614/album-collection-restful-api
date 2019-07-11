package com.wcci.albumcollection.controllertests.web_layer_test;

import java.util.Collection;

import org.junit.Before;
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
		songCollection.add(song1);
		songCollection.add(song2);
		testAlbum = new Album("title", "imageUrl", songCollection, "recordLabel");
		
	}
	
	
	
	
	
	
}
