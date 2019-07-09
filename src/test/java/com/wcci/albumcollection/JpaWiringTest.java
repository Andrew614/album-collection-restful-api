package com.wcci.albumcollection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.wcci.albumcollection.entities.Album;
import com.wcci.albumcollection.entities.Artist;
import com.wcci.albumcollection.entities.Song;
import com.wcci.albumcollection.repositories.AlbumRepository;
import com.wcci.albumcollection.repositories.ArtistRepository;
import com.wcci.albumcollection.repositories.SongRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaWiringTest {
	
	@Autowired
	TestEntityManager entityManager;

	@Autowired
	private AlbumRepository albumRepo;
	
	@Autowired
	private ArtistRepository artistRepo;
	
	@Autowired
	private SongRepository songRepo;
	
	@Test
	public void shouldStartJPATestFrameWork() {
		
		
	}
	@Test
	public void shouldCreatObjectsInRepos() {
	albumRepo.save(new Album ("", "", null, ""));
	songRepo.save(new Song("","", null));
	artistRepo.save(new Artist("dan", null, null, null));
	entityManager.flush();
	assertThat(artistRepo.findByName("dan").getName(), is("dan"));
	}
	@Test
	public void shouldHaveNameGettersForRepos() {
	albumRepo.save(new Album ("dans songs", null, null, null));
	songRepo.save(new Song("song", "", null));
	artistRepo.save(new Artist("dan", null, null, null));
	artistRepo.findByName("dan").addSong(songRepo.findByTitle("song"));
	entityManager.flush();
	entityManager.clear();
	System.out.println(artistRepo.findByName("dan").getSongs().size() + "look here             Look Here");
	assertThat(artistRepo.findByName("dan").getSongs().size(), is(1));
	}
	
	
}
