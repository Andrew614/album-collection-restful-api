package com.wcci.albumcollection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.wcci.albumcollection.entities.Album;
import com.wcci.albumcollection.entities.Artist;
import com.wcci.albumcollection.entities.Comment;
import com.wcci.albumcollection.entities.Song;
import com.wcci.albumcollection.repositories.AlbumRepository;
import com.wcci.albumcollection.repositories.ArtistRepository;
import com.wcci.albumcollection.repositories.CommentRepository;
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

	@Autowired
	private CommentRepository commentRepo;

	private Artist dan;
	private Album dansAlbum;
	private Song dansSong;
	private Comment newComment;

	
	@Before
	public void setup() {
		dan = new Artist("dan","", "1770","");
		artistRepo.save(dan);
		dansAlbum = new Album(dan, "dans songs","imageurl","dans label");
		albumRepo.save(dansAlbum);
		dansSong = new Song(dansAlbum, "dans only hit", "https://www.youtube.com/watch?v=6zXDo4dL7SU", "0:04");
		songRepo.save(dansSong);
		newComment = new Comment("I don't think, therefore I ain't.", "Ener Nightcart");
		commentRepo.save(newComment);
		flushAndClearEntityManager();
	}

	@Test
	public void shouldStartJPATestFrameWork() {

	}
	
	@Test
	public void shouldSaveAndLoadArtist() {
		assertThat(artistRepo.findByName("dan").getName(), is("dan"));
	}
	
	@Test
	public void shouldSaveAndLoadAlbum() {
		assertThat(albumRepo.findByTitle("dans songs").getTitle(), is("dans songs"));
	}
	
	@Test
	public void shouldSaveAndLoadSong() {
	assertThat(songRepo.findByTitle("dans only hit").getTitle(), is("dans only hit"));
	}

	@Test
	public void shouldHaveNameGettersForRepos() {
		Artist retrievedArtist = artistRepo.findByName("dan");
		Album retrievedAlbum = albumRepo.findByTitle("dans songs");
		Song retrievedSong = songRepo.findByTitle("dans only hit");
		assertThat(retrievedArtist, is(dan));
		assertThat(retrievedAlbum, is(dansAlbum));
		assertThat(retrievedSong, is(dansSong));
	}
	
	@Test
	public void shouldAddAnotherAlbumToArtist() {
		Album newAlbum;
		newAlbum = new Album(dan, "more dans songs", "imageurl2","dans label");
		albumRepo.save(newAlbum);
		flushAndClearEntityManager();
		Iterable<Album> albums;
		albums = albumRepo.findAll();
		assertThat(albums, containsInAnyOrder(dansAlbum, newAlbum));
	}
	
	@Test
	public void shouldAddAnotherSongToAlbum() {
		Song newSong;
		newSong = new Song(dansAlbum, "dans not hit", "no link to be found", "0:01");
		songRepo.save(newSong);
		flushAndClearEntityManager();
		Iterable<Song> songs;
		songs = songRepo.findAll();
		assertThat(songs, containsInAnyOrder(dansSong, newSong));
	}
	
	@Test
	public void shouldMakeNewComment() {
		Iterable<Comment> comments;
		comments = commentRepo.findAll();
		assertThat(comments, contains(newComment));
	}
	
	@Test
	public void shouldAddCommentToArtist() {
		
	}

	private void flushAndClearEntityManager() {
		entityManager.flush();
		entityManager.clear();
	}

}
