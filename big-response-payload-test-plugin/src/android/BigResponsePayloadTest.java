// Copyright 2020-present Christopher J. Brody <chris.brody+brodybits@gmail.com>

package com.demo;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;

public class BigResponsePayloadTest extends CordovaPlugin {
  @Override
  public boolean execute(String action, JSONArray args, CallbackContext cbc) {
    switch (action) {
      case "test":
        cbc.success(args);
      return true;
    }
    return false;
  }
}
