// Copyright 2020-present Christopher J. Brody <chris.brody+brodybits@gmail.com>

document
  .getElementById('status')
  .appendChild(document.createElement('b'))
  .appendChild(document.createTextNode('status:'))
document.addEventListener('deviceready', function () {
  document
    .getElementById('status')
    .appendChild(document.createElement('i'))
    .appendChild(document.createTextNode('ready'))
})
