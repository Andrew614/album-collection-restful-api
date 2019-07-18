package com.wcci.albumcollection.entitytests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import com.wcci.albumcollection.entities.Artist;

public class ArtistTest {
	
	@Test
	public void shouldAddCommentToArtist() {
		Artist underTest;
		underTest = new Artist("name", "url", "1992", "somewhere in nowhere");
		String comment;
		comment = "foo";
		underTest.addComment(comment);
		String retrievedComment;
		retrievedComment = underTest.getComments().get(0);
		assertThat(retrievedComment, is(comment));
	}

}
