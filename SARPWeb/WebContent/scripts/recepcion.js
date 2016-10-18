var cancelButton = document.getElementById("popup-cancel-button");
var closeButton = document.getElementById("popup-close-button");
var confirmButton = document.getElementById("open-popup-button");
var popup = document.getElementById("nuevo-numero-popup");
var optionButtons = document.getElementsByClassName("option-button");

cancelButton.addEventListener('click', function(){
	popup.classList.add("hidden");
	document.getElementsByTagName("BODY")[0].classList.remove('body-not-scroll')
}, false);

closeButton.addEventListener('click', function(){
	popup.classList.add("hidden");
	document.getElementsByTagName("BODY")[0].classList.remove('body-not-scroll')
}, false);

for (var i = 0; i < optionButtons.length; i++) {
	optionButtons[i].addEventListener('click', function(){
		confirmButton.classList.remove('deactivated');
		document.getElementById('numero-form:sector-selected').value = this.previousElementSibling.getAttribute('sector');
		document.getElementById('numero-form:tramite-selected').value = this.previousElementSibling.getAttribute('tramite');
		var hora = document.getElementById('date-time').innerHTML;
		document.getElementById('numero-form:hora').value = hora.substr(0, 10) + '-' + hora.substr(11, 15).substr(0, 5);
		document.getElementsByClassName('sector-selected')[0].value = this.previousElementSibling.getAttribute('sector');
		document.getElementsByClassName('tramite-selected')[0].value = this.previousElementSibling.getAttribute('tramite');
    }, false);
}