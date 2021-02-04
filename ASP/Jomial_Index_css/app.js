$(function () {
    $(window).on('scroll', function () {
  
        if ( $(window).scrollTop() > 10 ) {
            $('.navbar').addClass('active');
        } else {
            $('.navbar').removeClass('active');
        }
        
    });
})

const header = document.querySelector('.containerra');
window.addEventListener('scroll',()=>{
    let scrollPos=window.scrollY;
    header.style.backgroundSize= `${scrollPos+100}%`;
  
})

const links = document.querySelectorAll(".textoBonito3");

for (const link of links) {
  link.addEventListener("click", clickHandler);
}

function clickHandler(e) {
  e.preventDefault();
  const href = this.getAttribute("href");
  const offsetTop = document.querySelector(href).offsetTop;

  scroll({
    top: offsetTop,
    behavior: "smooth"
  });
}

var inputs = document.querySelectorAll( 'input[type=text], input[type=email]' );
for (i = 0; i < inputs.length; i ++) {
  var inputEl = inputs[i];
  if( inputEl.value.trim() !== '' ) {
  	inputEl.parentNode.classList.add( 'input--filled' );
  }
  inputEl.addEventListener( 'focus', onFocus );
  inputEl.addEventListener( 'blur', onBlur );
}

function onFocus( ev ) {
  ev.target.parentNode.classList.add( 'inputs--filled' );
}

function onBlur( ev ) {
  if ( ev.target.value.trim() === '' ) {
  	ev.target.parentNode.classList.remove( 'inputs--filled' );
  } else if ( ev.target.checkValidity() == false ) {
    ev.target.parentNode.classList.add( 'inputs--invalid' );
    ev.target.addEventListener( 'input', liveValidation );
  } else if ( ev.target.checkValidity() == true ) {
    ev.target.parentNode.classList.remove( 'inputs--invalid' );
    ev.target.addEventListener( 'input', liveValidation );
  }
}

function liveValidation( ev ) {
  if ( ev.target.checkValidity() == false ) {
    ev.target.parentNode.classList.add( 'inputs--invalid' );
  } else {
    ev.target.parentNode.classList.remove( 'inputs--invalid' );
  }
}

var submitBtn = document.querySelector( 'input[type=submit]' );
submitBtn.addEventListener( 'click', onSubmit );

function onSubmit( ev ) {
  var inputsWrappers = ev.target.parentNode.querySelectorAll( 'span' );
  for (i = 0; i < inputsWrappers.length; i ++) {
    input = inputsWrappers[i].querySelector( 'input[type=text], input[type=email]' );
    if ( input.checkValidity() == false ) {
      inputsWrappers[i].classList.add( 'inputs--invalid' );
    } else if ( input.checkValidity() == true ) {
      inputsWrappers[i].classList.remove( 'inputs--invalid' );
    }
  }
}

