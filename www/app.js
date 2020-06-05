// Copyright 2020-present Christopher J. Brody <chris.brody+brodybits@gmail.com>

// should be stable:
const NATIVE_RESPONSE_COUNT = 20
// seems to trigger memory issues:
// const NATIVE_RESPONSE_COUNT = 400

function log (text) {
  console.log(text)

  document
    .getElementById('messages')
    .appendChild(document.createTextNode(text))

  document
    .getElementById('messages')
    .appendChild(document.createElement('br'))
}

document.addEventListener('deviceready', function () {
  log('ready')

  window.bigResponsePayloadTest.test(NATIVE_RESPONSE_COUNT, function () {
    log('done')
  })
})
