package com.wcci.albumcollection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.Year;

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
	public void shouldSaveAndLoadSong() {
	songRepo.save(new Song("song","",null));
	assertThat(songRepo.findByTitle("song").getTitle(), is("song"));
	}
	@Test
	public void shouldSaveAndLoadAlbum() {
	albumRepo.save(new Album("dans songs","",null,""));
	assertThat(albumRepo.findByTitle("dans songs").getTitle(), is("dans songs"));
	}
	@Test
	public void shouldSaveAndLoadArtist() {
		Artist dan = new Artist("dan","", "1770","");
		artistRepo.save(dan);
		assertThat(artistRepo.findByName("dan").getName(), is("dan"));
	}
	
	
	@Test
	public void shouldCreatObjectsInRepos() {
		albumRepo.save(new Album("dans songs","",null,""));
		songRepo.save(new Song("song","",null));
		Artist dan = new Artist("dan","", "1770","");
		artistRepo.save(dan);
		flushAndClearEntityManager();
		assertThat(artistRepo.findByName("dan").getName(), is("dan"));	
	}

	@Test
	public void shouldHaveNameGettersForRepos() {
		albumRepo.save(new Album("dans songs", "", null,""));
		songRepo.save(new Song("song", "", null));
		artistRepo.save(new Artist("dan", "", "1770",""));
		flushAndClearEntityManager();
		Album retrievedAlbum = albumRepo.findByTitle("dans songs");
		Song retrievedSong = songRepo.findByTitle("song");
		retrievedAlbum.addSong(retrievedSong);
		albumRepo.save(retrievedAlbum);
		flushAndClearEntityManager();
		assertThat(albumRepo.findByTitle("dans songs").getSongs().size(), is(1));
	}

	private void flushAndClearEntityManager() {
		entityManager.flush();
		entityManager.clear();
	}

}
