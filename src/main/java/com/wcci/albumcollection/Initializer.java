package com.wcci.albumcollection;

import java.util.ArrayList;

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
public class Initializer implements CommandLineRunner{
	
	@Autowired
	SongRepository songRepo;
	
	@Autowired
	AlbumRepository albumRepo;
	
	@Autowired
	ArtistRepository artistRepo;

	@Override
	public void run(String... args) throws Exception {
		Song song1 = new Song("foo1", "bar2", "foobar3");
		songRepo.save(song1);
		Song song2 = new Song("(You Lift Me) Up to Heaven", "https://www.youtube.com/watch?v=4rrpiJDNp_E", "2:45");
		songRepo.save(song2);
		Song song3 = new Song("Tears on My Pillow", "https://www.youtube.com/watch?v=AoLyBe8ySXg", "2:33");
		songRepo.save(song3);
		Song song4 = new Song("I Don't Think Love Ought to Be That Way", "https://www.youtube.com/watch?v=2KvjOQuK2Mo", "2:40");
		songRepo.save(song4);
		
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(song1);
		songs.add(song2);
		songs.add(song3);
		songs.add(song4);
		Album album1 = new Album("Feel the Fire", "https://upload.wikimedia.org/wikipedia/en/9/99/RebaFeeltheFire.jpg", songs, "some record label");
		albumRepo.save(album1);
		
		//String name, String imageUrl, String dateOfBirth, String homeTown
		artistRepo.save(new Artist("Reba McEntire", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnflbi2fU-1-gBhW5ZC8I_JTGTdFIav6aKz_d3Kpe6Tk_E-WZC", "March 28, 1955", "McAlester, Oklahoma"));
	
		Song nasSong1 = new Song("Old Town Road", "https://www.youtube.com/watch?v=w2Ov5jzm3j8", "1:53");
		Song nasSong2 = new Song("F9mily (You & Me)", "https://www.youtube.com/watch?v=AG-UjPkeJgI", "2:44");
		songRepo.save(nasSong1);
		songRepo.save(nasSong2);
		
		ArrayList<Song> nasSongs = new ArrayList<Song>();
		nasSongs.add(nasSong1);
		nasSongs.add(nasSong2);
		Album nasAlbum1 = new Album("Nasarati", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Lil_Nas_X_%28cropped%29.jpg/330px-Lil_Nas_X_%28cropped%29.jpg", nasSongs, "some record label");
		albumRepo.save(nasAlbum1);
		
		artistRepo.save(new Artist("Lil Nas X", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Lil_Nas_X_%28cropped%29.jpg/330px-Lil_Nas_X_%28cropped%29.jpg", "April 9, 1999", "Atlanta, Georgia"));
		
	}
	
	

}
