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
	Artist Tupac;
	Artist Marshmello;
	Artist Willie;
	Artist Jack;

	Album rebasAlbum1;
	Album rebasAlbum2;
	Album lilNasXsAlbum1;
	Album TupacsAlbum1;
	Album TupacsAlbum2;
	Album MarshmelloAlbum1;
	Album WillieAlbum1;
	Album JackAlbum1;








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
		Song rebasSong4 = new Song(rebasAlbum2, "So, So, So, Long",
				"https://www.youtube.com/watch?v=z5mkOvKncuA", "3:40");
		songRepo.save(rebasSong1);
		Song rebasSong5 = new Song(rebasAlbum2, "Sunday Kind of Love", "https://www.youtube.com/watch?v=we4scrBK8rI",
				"3:00");
		songRepo.save(rebasSong2);
		Song rebasSong6 = new Song(rebasAlbum2, "New Fool At an Old Game",
				"https://www.youtube.com/watch?v=jymPMDrtrls", "3:49");
		songRepo.save(rebasSong3);
		
		
		
		Song nasSong1 = new Song(lilNasXsAlbum1, "Old Town Road", "https://www.youtube.com/watch?v=w2Ov5jzm3j8",
				"1:53");
		songRepo.save(nasSong1);
		Song nasSong2 = new Song(lilNasXsAlbum1, "F9mily (You & Me)", "https://www.youtube.com/watch?v=AG-UjPkeJgI",
				"2:44");
		songRepo.save(nasSong2);
		Song pacSong1 = new Song(TupacsAlbum1, "Keep Ya Head Up", "https://www.youtube.com/watch?v=fAJfDP3b5_U",
				"4:23");
		songRepo.save(pacSong1);
		Song pacSong2 = new Song(TupacsAlbum1, "Changes", "https://www.youtube.com/watch?v=eXvBjCO19QY",
				"4:40");
		songRepo.save(pacSong2);
		Song marshSong1 = new Song(MarshmelloAlbum1, "Alone", "https://www.youtube.com/watch?v=ALZHF5UqnU4",
				"3:19");
		songRepo.save(marshSong1);
		Song marshSong2 = new Song(MarshmelloAlbum1, "Happier", "https://www.youtube.com/watch?v=m7Bc3pLyij0",
				"3:53");
		songRepo.save(marshSong2);
		Song willieSong1 = new Song(WillieAlbum1, "Always On My Mind", "https://www.youtube.com/watch?v=R7f189Z0v0Y",
				"3:36");
		songRepo.save(willieSong1);
		Song willieSong2 = new Song(WillieAlbum1, "On The Road Aagin", "https://www.youtube.com/watch?v=dBN86y30Ufc",
				"2:33");
		songRepo.save(willieSong2);
		Song jackSong1 = new Song(JackAlbum1, "Tribute", "https://www.youtube.com/watch?v=_lK4cX5xGiQ",
				"4:52");
		songRepo.save(jackSong1);
		Song jackSong2 = new Song(JackAlbum1, "Kickapoo", "https://www.youtube.com/watch?v=hvvjiE4AdUI",
				"4:23");
		songRepo.save(jackSong2);
	}

	private void populateAlbums() {
		rebasAlbum1 = new Album(reba, "Feel the Fire",
				"https://upload.wikimedia.org/wikipedia/en/9/99/RebaFeeltheFire.jpg", "some record label");
		albumRepo.save(rebasAlbum1);
		rebasAlbum2 = new Album(reba, "Reba",
				"https://upload.wikimedia.org/wikipedia/en/9/99/RebaFeeltheFire.jpg", "some record label");
		albumRepo.save(rebasAlbum2);
		lilNasXsAlbum1 = new Album(lilNasX, "Nasarati",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Lil_Nas_X_%28cropped%29.jpg/330px-Lil_Nas_X_%28cropped%29.jpg",
				"some record label");
		albumRepo.save(lilNasXsAlbum1);
		TupacsAlbum1 = new Album(Tupac, "Greatest Hits",
				"https://upload.wikimedia.org/wikipedia/en/9/9b/2PacGreatestHits.jpg",
				"Death Row Records");
		albumRepo.save(TupacsAlbum1);
		MarshmelloAlbum1 = new Album(Marshmello, "Single",
				"https://upload.wikimedia.org/wikipedia/en/thumb/b/bd/Alone_Marshmello_cover.jpg/220px-Alone_Marshmello_cover.jpg",
				"Def Jam");
		albumRepo.save(MarshmelloAlbum1);
		WillieAlbum1 = new Album(Willie, "Always on my mind",
				"https://upload.wikimedia.org/wikipedia/en/thumb/2/2a/Willie-Nelson-Always-on-My-Mind.jpg/220px-Willie-Nelson-Always-on-My-Mind.jpg",
				"Columbia Records");
		albumRepo.save(WillieAlbum1);
		JackAlbum1 = new Album(Jack, "Tenacious D",
				"https://upload.wikimedia.org/wikipedia/en/5/52/Tenacious_D_album_cover.jpg",
				"Epic");
		albumRepo.save(JackAlbum1);
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
		Tupac = new Artist("Tupac Shakur", "https://m.media-amazon.com/images/M/MV5BMTMwMTE2ODk0NV5BMl5BanBnXkFtZTYwMTE5MzQ3._V1_.jpg",
				"June 16,1971", "New York City, New York");
		artistRepo.save(Tupac);
		Marshmello = new Artist("Marshmello", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/2016_Open_Beatz_-_Marshmello_-_by_2eight_-DSC_4448.jpg/800px-2016_Open_Beatz_-_Marshmello_-_by_2eight_-DSC_4448.jpg",
				"May 19,1992", "Philadelphia, Pennsylvania");
		artistRepo.save(Marshmello);
		Willie = new Artist("Willie Nelson", "https://upload.wikimedia.org/wikipedia/commons/b/b0/Willie_Nelson_at_Farm_Aid_2009_-_Cropped.jpg",
				"April 29,1933", "Abbott, Texas");
		artistRepo.save(Willie);
		Jack = new Artist("Jack Black", "https://upload.wikimedia.org/wikipedia/commons/4/48/2016_RiP_Tenacious_D_-_Jack_Black_-_by_2eight_-_8SC8891.jpg",
				"August 28,1969", "Santa Monica, California");
		artistRepo.save(Jack);
	}

}
