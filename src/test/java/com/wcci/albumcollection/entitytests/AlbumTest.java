package com.wcci.albumcollection.entitytests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.wcci.albumcollection.entities.Album;
import com.wcci.albumcollection.entities.Artist;

public class AlbumTest {

	@Test
	public void shouldAddCommentToAlbum() {
		Artist artist;
		artist = new Artist("name", "url", "1992", "somewhere in nowhere");
		Album underTest;
		underTest = new Album(artist, "title", "url", "label");
		String comment;
		comment = "foo";
		underTest.addComment(comment);
		String retrievedComment;
		retrievedComment = underTest.getComments().get(0);
		assertThat(retrievedComment, is(comment));
	}
}
