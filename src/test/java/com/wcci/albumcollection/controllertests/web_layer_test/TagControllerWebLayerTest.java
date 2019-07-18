package com.wcci.albumcollection.controllertests.web_layer_test;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
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
import com.wcci.albumcollection.controllers.TagController;
import com.wcci.albumcollection.entities.Song;
import com.wcci.albumcollection.entities.Tag;
import com.wcci.albumcollection.repositories.TagRepository;

@WebMvcTest(TagController.class)
@RunWith(SpringRunner.class)
public class TagControllerWebLayerTest {
	
	@Autowired
	MockMvc mockMvc;
	@MockBean
	TagRepository tagRepo;
	private Tag testTag1;
	private Tag testTag2;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void setup() {
		testTag1 = new Tag("someChat");
		testTag2 = new Tag("someBanter");
		
	}
	
	@Test
	public void fetchCollectionOfTags() throws Exception {
		when(tagRepo.findAll()).thenReturn(Collections.singletonList(testTag1));
		mockMvc.perform(get("/api/tags")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("[{}]"))
		.andExpect(content().json(mapper.writeValueAsString(Collections.singletonList(testTag1)), true));
	}
	@Test
	public void fetchSingleTag() throws Exception {
		when(tagRepo.findById(1L)).thenReturn(Optional.of(testTag1));
		mockMvc.perform(get("/api/tags/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(content().json("{}"))
				.andExpect(content().json(mapper.writeValueAsString(testTag1), true));
	}

	@Test
	public void postSingleTag() throws Exception {
		when(tagRepo.save(any(Tag.class))).thenReturn(testTag1);
		mockMvc.perform(post("/api/tags/someChat").content("someChat")).andExpect(status().isOk())
				.andExpect(jsonPath("$.content", is("someChat")));
	}

	@Test
	public void shouldChangeTagContent() throws Exception {
		when(tagRepo.findById(1L)).thenReturn(Optional.of(testTag1));
		String body = "otherBody";
		when(tagRepo.save(any(Tag.class))).thenReturn(new Tag(body));

		mockMvc.perform(put("/api/tags/1/" + body)).andExpect(status().isOk())
				.andExpect(jsonPath("$.content", is("otherBody")));
	}


}
