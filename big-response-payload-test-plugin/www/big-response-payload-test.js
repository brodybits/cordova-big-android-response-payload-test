// Copyright 2020-present Christopher J. Brody <chris.brody+brodybits@gmail.com>

function test (nativeResponseCount, callback) {
  var pluginResponseCount = 0

  cordova.exec(
    function () {
      ++pluginResponseCount;
      if (pluginResponseCount === nativeResponseCount) callback('pong')
    },
    null,
    'BigResponsePayloadTest',
    'test',
    [nativeResponseCount]
  )
}

window.bigResponsePayloadTest = {
  test: test
}
