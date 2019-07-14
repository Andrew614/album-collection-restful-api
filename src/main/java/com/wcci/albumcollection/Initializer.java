package com.wcci.albumcollection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.wcci.albumcollection.entities.Song;
import com.wcci.albumcollection.repositories.SongRepository;

@Service
public class Initializer implements CommandLineRunner{
	
	@Autowired
	SongRepository songRepo;
	

	@Override
	public void run(String... args) throws Exception {
		songRepo.save(new Song("foo1", "bar2", "foobar3"));
	}
	
	

}
