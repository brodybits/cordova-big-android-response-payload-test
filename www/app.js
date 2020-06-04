// Copyright 2020-present Christopher J. Brody <chris.brody+brodybits@gmail.com>

document.addEventListener('deviceready', function () {
  document
    .getElementById('status')
    .appendChild(document.createElement('b'))
    .appendChild(document.createTextNode('ready'))
  window.bigResponsePayloadTest.test(function () {
    document
      .getElementById('status')
      .appendChild(document.createElement('i'))
      .appendChild(document.createTextNode('pong'))
  })
})
