package com.wcci.albumcollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.wcci.albumcollection.entities.Album;
import com.wcci.albumcollection.entities.Artist;
import com.wcci.albumcollection.entities.Song;
import com.wcci.albumcollection.repositories.AlbumRepository;
import com.wcci.albumcollection.repositories.ArtistRepository;
import com.wcci.albumcollection.repositories.SongRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Autowired
	SongRepository songRepo;

	@Autowired
	AlbumRepository albumRepo;

	@Autowired
	ArtistRepository artistRepo;

	Artist reba;
	Artist lilNasX;

	Album rebasAlbum1;
	Album lilNasXsAlbum1;

	@Override
	public void run(String... args) throws Exception {
		populateArtists();
		populateAlbums();
		populateSongs();
	}

	private void populateSongs() {
		Song rebasSong1 = new Song(rebasAlbum1, "(You Lift Me) Up to Heaven",
				"https://www.youtube.com/watch?v=4rrpiJDNp_E", "2:45");
		songRepo.save(rebasSong1);
		Song rebasSong2 = new Song(rebasAlbum1, "Tears on My Pillow", "https://www.youtube.com/watch?v=AoLyBe8ySXg",
				"2:33");
		songRepo.save(rebasSong2);
		Song rebasSong3 = new Song(rebasAlbum1, "I Don't Think Love Ought to Be That Way",
				"https://www.youtube.com/watch?v=2KvjOQuK2Mo", "2:40");
		songRepo.save(rebasSong3);

		Song nasSong1 = new Song(lilNasXsAlbum1, "Old Town Road", "https://www.youtube.com/watch?v=w2Ov5jzm3j8",
				"1:53");
		songRepo.save(nasSong1);
		Song nasSong2 = new Song(lilNasXsAlbum1, "F9mily (You & Me)", "https://www.youtube.com/watch?v=AG-UjPkeJgI",
				"2:44");
		songRepo.save(nasSong2);
	}

	private void populateAlbums() {
		rebasAlbum1 = new Album(reba, "Feel the Fire",
				"https://upload.wikimedia.org/wikipedia/en/9/99/RebaFeeltheFire.jpg", "some record label");
		albumRepo.save(rebasAlbum1);
		lilNasXsAlbum1 = new Album(lilNasX, "Nasarati",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Lil_Nas_X_%28cropped%29.jpg/330px-Lil_Nas_X_%28cropped%29.jpg",
				"some record label");
		albumRepo.save(lilNasXsAlbum1);
	}

	private void populateArtists() {
		reba = new Artist("Reba McEntire",
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnflbi2fU-1-gBhW5ZC8I_JTGTdFIav6aKz_d3Kpe6Tk_E-WZC",
				"March 28, 1955", "McAlester, Oklahoma");
		artistRepo.save(reba);
		lilNasX = new Artist("Lil Nas X",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Lil_Nas_X_%28cropped%29.jpg/330px-Lil_Nas_X_%28cropped%29.jpg",
				"April 9, 1999", "Atlanta, Georgia");
		artistRepo.save(lilNasX);
	}

}
