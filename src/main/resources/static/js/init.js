document.addEventListener('DOMContentLoaded', function () {
  var elems = document.querySelectorAll('.modal');
  let options = {
    opacity: 0.4
  }
  var instances = M.Modal.init(elems, options);
});