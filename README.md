# cordova-big-android-response-payload-test

now with the native test running in a background thread

**To run test:**

- `cordova platform add android`
- `cordova run android`

Note that the local `big-response-payload-test-plugin` is already specified in `package.json`.

**To reproduce payload memory issue on Android:**

- change the value of `NATIVE_RESPONSE_COUNT` to a higher value such as `400` in `www/app.js`
- run test on Android, as specified above
