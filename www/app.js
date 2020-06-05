// Copyright 2020-present Christopher J. Brody <chris.brody+brodybits@gmail.com>

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

  window.bigResponsePayloadTest.test(function () {
    log('done')
  })
})
