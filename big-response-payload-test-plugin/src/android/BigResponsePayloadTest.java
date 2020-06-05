// Copyright 2020-present Christopher J. Brody <chris.brody+brodybits@gmail.com>

package com.demo;

import android.util.Log;

// for solution that builds but does not run on Android 7:
// import java.util.Collections;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;

public class BigResponsePayloadTest extends CordovaPlugin {
  private static final String LOG_TAG = "BigResponsePayloadTest";

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext cbc) {
    switch (action) {
      case "test":
        try {
          test(args, cbc);
        } catch (Exception e) { }
        return true;
    }
    return false;
  }

  private void test(JSONArray args, CallbackContext cbc) throws JSONException {
    final int nativeResponseCount = args.getInt(0);

    testNow(nativeResponseCount, cbc);
  }

  private void testNow(final int nativeResponseCount, CallbackContext cbc) {
    Log.i(LOG_TAG, "START TEST");

    // 50 characters
    final String HALF_RESULT_PATTERN =
      "abcdefghijklmnopqrstuvwxyz-1234567890-ABCDEFGHIJK-";

    // 100 characters
    final String RESULT_PATTERN = HALF_RESULT_PATTERN + HALF_RESULT_PATTERN;

    // for a total of 1 * 1000 * 1000 characters:
    final int REPEAT_COUNT = 10 * 1000;

    // not supported by Java 8:
    // final String RESPONSE_MESSAGE = RESULT_PATTERN.repeat(REPEAT_COUNT);

    // builds but does not run on Android 7:
    // https://stackoverflow.com/questions/1235179/simple-way-to-repeat-a-string-in-java/6857936#6857936
    // final String RESPONSE_MESSAGE =
    //   String.join("", Collections.nCopies(REPEAT_COUNT, RESULT_PATTERN));

    // quick solution:
    String RESPONSE_MESSAGE = "";
    for (int h=0; h < REPEAT_COUNT; ++h) RESPONSE_MESSAGE += RESULT_PATTERN;

    // NOTE that using a string buffer should be more optimal here.

    Log.i(LOG_TAG, "SENDING TEST RESPONSE MESSAGES");

    for (int i=0; i < nativeResponseCount; ++i) {
        PluginResult pr =
          new PluginResult(PluginResult.Status.OK, RESPONSE_MESSAGE);
        if ((i + 1) < nativeResponseCount) pr.setKeepCallback(true);
        cbc.sendPluginResult(pr);
    }

    Log.i(LOG_TAG, "SENT TEST RESPONSE MESSAGES");
  }
}
