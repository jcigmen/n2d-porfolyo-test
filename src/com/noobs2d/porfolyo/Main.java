package com.noobs2d.porfolyo;

import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.Test;
import junit.framework.TestSuite;

public class Main extends TestSuite {

    public static Test suite() {
	return new TestSuiteBuilder(Main.class).includeAllPackagesUnderHere().build();
    }
}
