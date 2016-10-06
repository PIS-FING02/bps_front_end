var optionButtons = document.getElementsByClassName('option-button');
var popup = document.getElementById('action-admin-popup');
var cancelButton = document.getElementById('popup-cancel-button');
var closeButton = document.getElementById('popup-close-button');
var popupTitle = document.getElementById('popup-title');

cancelButton.addEventListener('click', function(){
	popup.classList.add("hidden");
	document.getElementsByClassName('option-button-selected')[0].classList.remove('option-button-selected');
}, false);

closeButton.addEventListener('click', function(){
	popup.classList.add("hidden");
	document.getElementsByClassName('option-button-selected')[0].classList.remove('option-button-selected');
}, false);

for (var i = 0; i < optionButtons.length; i++) {
  optionButtons[i].addEventListener('click', function(){
    popup.classList.remove("hidden");
  }, false);
}

for (var i = 0; i < optionButtons.length; i++) {
	optionButtons[i].addEventListener('click', function(){
		for (var i = 0; i < optionButtons.length; i++) {
			optionButtons[i].classList.remove('option-button-selected');
		}
		this.classList.add('option-button-selected');
		var actionSelected = document.getElementsByClassName('option-button-selected')[0];
		popupTitle.innerHTML = actionSelected.innerHTML; 
		if (actionSelected.getAttribute('id') == 'alta-tramite') {
			document.getElementById('j_idt7:codigo').parentElement.classList.remove('hidden');
			document.getElementById('j_idt7:nombre-tramite').parentElement.classList.remove('hidden');
		}{
			//PARA CADA BOTON MOSTRAR LOS INPUTS QUE CORRESPONDAD
		}	
	    popup.classList.remove('hidden');
    }, false);
}
