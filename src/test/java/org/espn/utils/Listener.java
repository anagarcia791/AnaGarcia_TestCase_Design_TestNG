package org.espn.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import org.espn.reporting.Reporter;

public class Listener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.info("Test: " + result.getName() + " [PASSED]");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.error("Test: " + result.getName() + " [FAILED]");
    }
}
