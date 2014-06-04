package com.noobs2d.porfolyo.fragments;

import android.test.ActivityInstrumentationTestCase2;

import com.noobs2d.porfolyo.MainActivity;
import com.noobs2d.porfolyo.fragments.WorksSectionFragment;

public class WorksSectionFragmentTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;
    private WorksSectionFragment worksSectionFragment;

    public WorksSectionFragmentTest(Class<MainActivity> activityClass) {
	super(activityClass);
    }

    private void testWorksCollectionValidity() {
	try {
	    //	    worksSectionFragment.retrieveWorks();

	    // the collection must not be empty
	    //	    asserTrue(worksSectionFragment.getWorks().size() > 0);

	    // TODO test the validity of each Work instance
	    //	    for (Work work : worksSectionFragment.getWorks())
	    //		assertTrue(work.isValid());

	} catch (StringIndexOutOfBoundsException e) {
	    fail();
	} catch (ArrayIndexOutOfBoundsException e) {
	    fail();
	}
    }

    @Override
    protected void setUp() throws Exception {
	super.setUp();
	activity = getActivity();
	//	worksSectionFragment = activity.getSectionsPagerAdapter().getWorksSectionFragment();
    }
}
