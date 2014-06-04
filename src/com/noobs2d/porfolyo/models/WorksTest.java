package com.noobs2d.porfolyo.models;

import com.noobs2d.porfolyo.models.Work;

import junit.framework.TestCase;

public class WorksTest extends TestCase {

    public void testInstanceValidity() {
	String[] images = { "work1.png", "work2.png", "work3.png" };
	String title = "Passion Projects";
	String description = "Stuff I do about during my freetime with my friends who wants to conquer the world too.";
	String link = "https://play.google.com/store/apps/details?id=com.noobs2d.petronas";
	Work work = new Work(title, description, link, images);

	// Stuff accomplished by this simple assertion:
	// 1. test title not empty, null, or less than 7 characters.
	// 2. test link can be verified if an android app package name or a Web URL. URLs must start
	//		with "http://" or "https://" while package names have at least three identifiers 
	//		that are divided by dots. (e.g., "com.noobs2d.porfolyo"),  and doesn't start with a dot.
	// 3. test images must have at least 1 entry and filenames end with ".png", ".PNG"., ".jpeg, ".JPEG", ".jpg", or ".JPG"
	assertFalse(work.isTitleInvalid());
	assertFalse(work.isLinkInvalid());
	assertFalse(work.areImagesInvalid());

	// test with invalid title
	title = "";
	work.title = title;
	assertFalse(work.isValid());

	title = null;
	work.title = title;
	assertFalse(work.isValid());

	title = "123456"; // only 6 characters and below
	work.title = title;
	assertFalse(work.isValid());

	// test with invalid link
	work.link = "com.packages.noobs2d";
	assertFalse(work.isValid());

	work.link = "www.noobs2d.com";
	assertFalse(work.isValid());

	work.link = "xhttp://www.noobs2d.com";
	assertFalse(work.isValid());

	work.link = "http://www.noobs2d.comp";
	assertFalse(work.isValid());

	// test with invalid images entry count and invalid filenames
	images = new String[0]; // no entries
	work.images = images;
	assertFalse(work.isValid());

	images = new String[] { "work1.png", "work2.png", " .png" }; // invalid: the third one has whitespace character only
	work.images = images;
	assertFalse(work.isValid());
    }
}
