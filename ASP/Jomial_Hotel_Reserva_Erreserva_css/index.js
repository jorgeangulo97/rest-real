window.onscroll = function() {myFunction()};

var header = document.getElementById("myHeader");
var div = document.getElementById("myDiv");
var sticky = header.offsetTop;
var stickyDiv = div.offsetTop;

function myFunction() {
  if (window.pageYOffset > sticky) {
    header.classList.add("sticky");
  } else {
    header.classList.remove("sticky");
  }
  if (window.pageYOffset > stickyDiv) {
    div.classList.add("sticky2");
  } else {
    div.classList.remove("sticky2");
  }
}
function checkdate(date1, date2) {
  dt1 = new Date(date1);
  dt2 = new Date(date2);
  if( Math.floor((Date.UTC(dt2.getFullYear(), dt2.getMonth(), dt2.getDate()) - Date.UTC(dt1.getFullYear(), dt1.getMonth(), dt1.getDate()) ) /(1000 * 60 * 60 * 24))){
    return false;
  }else{
    return true;
    }
  }
