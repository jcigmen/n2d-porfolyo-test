package com.noobs2d.porfolyo.fragments;

import android.test.ActivityInstrumentationTestCase2;

import com.noobs2d.porfolyo.MainActivity;
import com.noobs2d.porfolyo.adapters.ExperienceListAdapter;
import com.noobs2d.porfolyo.models.Experience;

public class ExperienceSctionFragmentTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;
    private ExperienceSectionFragment experienceSectionFragment;

    public ExperienceSctionFragmentTest() {
	super(MainActivity.class);
    }

    /** Checks whether all the experiences data from the string arrays were retrieved and formatted fine for
     * it to be used as the data collection in {@link ExperienceListAdapter}. */
    public void testExperiencesArrayValidity() {
	try {
	    // must be called first of course
	    experienceSectionFragment.retrieveExperiences();

	    // must always NOT be empty
	    assertTrue(experienceSectionFragment.experiences.size() > 0);

	    // each Experience instance's variable must not be empty or must contain at least 5 characters.
	    // this phase checks the one from the real data
	    for (Experience experience : experienceSectionFragment.experiences)
		assertTrue(experienceSectionFragment.isExperienceValid(experience));

	    // the following purposely uses bogus data
	    String title = "12345"; // less than 5
	    String company = ""; // invalid - blank
	    String duration = "May 2014 - September 2014"; // this one's valid
	    Experience experience = new Experience(title, company, duration);
	    assertFalse(experienceSectionFragment.isExperienceValid(experience));

	    title = "IT Consultant (Android)"; // valid title
	    company = "Systems Generators, Inc."; // valid 
	    duration = "May"; // invalid. less than 5
	    experience = new Experience(company, duration, title);
	    assertFalse(experienceSectionFragment.isExperienceValid(experience));

	    String unformattedString = "The Position|The Company|May 2014 - September 2014"; // valid unformatted string
	    experience = new Experience(unformattedString);
	    assertTrue(experienceSectionFragment.isExperienceValid(experience));

	    unformattedString = "POST|GET|"; // very invalid unformatted string
	    experience = new Experience(unformattedString);
	    assertFalse(experienceSectionFragment.isExperienceValid(experience));

	} catch (StringIndexOutOfBoundsException e) {
	    fail();
	} catch (ArrayIndexOutOfBoundsException e) {
	    fail();
	}
    }

    public void testPreConditions() {
	assertNotNull(activity.getSectionsPagerAdapter());
	assertNotNull(experienceSectionFragment.experiences);
    }

    @Override
    protected void setUp() throws Exception {
	super.setUp();
	activity = getActivity();
	experienceSectionFragment = activity.getSectionsPagerAdapter().getExperienceSectionFragment();
    }

}
