// Copyright 2020-present Christopher J. Brody <chris.brody+brodybits@gmail.com>

function test (callback) {
  cordova.exec(
    function () {
      callback('pong')
    },
    null,
    'BigResponsePayloadTest',
    'test',
    null
  )
}

window.bigResponsePayloadTest = {
  test: test
}
