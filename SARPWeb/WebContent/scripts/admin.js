var optionButtons = document.getElementsByClassName('option-button');
var popup = document.getElementById('action-admin-popup');
var cancelButton = document.getElementById('popup-cancel-button');
var cancelButtonADisplay = document.getElementById('popup-cancel-button-ADisplay');
var cancelButtonMDisplay = document.getElementById('popup-cancel-button-MDisplay');
var cancelButtonBDisplay = document.getElementById('popup-cancel-button-BDisplay');
var closeButton = document.getElementById('popup-close-button');
var popupTitle = document.getElementById('popup-title');

var elementsToHide = [];

function hideAll() {
	for (var i = 0; i < elementsToHide.length; i++) {
		document.getElementById(elementsToHide[i]).classList.add('hidden');
	}
	elementsToHide = [];
}

cancelButton.addEventListener('click', function(){
	popup.classList.add("hidden");
	//ocultar los inputs
	document.getElementById('j_idt7:codigo').parentElement.classList.add('hidden');
	document.getElementById('j_idt7:nombre-tramite').parentElement.classList.add('hidden');
	document.getElementById('aceptar-alta-tramite').classList.add('hidden');
	document.getElementsByClassName('option-button-selected')[0].classList.remove('option-button-selected');
}, false);

cancelButtonADisplay.addEventListener('click', function(){
	popup.classList.add("hidden");
	//ocultar los inputs
	document.getElementById('j_idt7:rutaArchivo').parentElement.classList.add('hidden');
	document.getElementById('aceptar-alta-display').classList.add('hidden');
	document.getElementsByClassName('option-button-selected')[0].classList.remove('option-button-selected');
}, false);

cancelButtonMDisplay.addEventListener('click', function(){
	popup.classList.add("hidden");
	//ocultar los inputs
	document.getElementById('j_idt7:displayId').parentElement.classList.add('hidden');
	document.getElementById('j_idt7:rutaArchivo').parentElement.classList.add('hidden');
	document.getElementById('aceptar-modificar-display').classList.add('hidden');
	document.getElementsByClassName('option-button-selected')[0].classList.remove('option-button-selected');
}, false);

cancelButtonBDisplay.addEventListener('click', function(){
	popup.classList.add("hidden");
	//ocultar los inputs
	document.getElementById('j_idt7:displayId').parentElement.classList.add('hidden');
	document.getElementById('aceptar-baja-display').classList.add('hidden');
	document.getElementsByClassName('option-button-selected')[0].classList.remove('option-button-selected');
}, false);

closeButton.addEventListener('click', function(){
	popup.classList.add("hidden");
	//ocultar los inputs
	document.getElementById('j_idt7:codigo').parentElement.classList.add('hidden');
	document.getElementById('j_idt7:nombre-tramite').parentElement.classList.add('hidden');
	document.getElementById('j_idt7:displayId').parentElement.classList.add('hidden');
	document.getElementById('j_idt7:rutaArchivo').parentElement.classList.add('hidden');
	document.getElementById('aceptar-alta-tramite').classList.add('hidden');
	document.getElementById('aceptar-alta-display').classList.add('hidden');
	document.getElementById('aceptar-modificar-display').classList.add('hidden');
	document.getElementById('aceptar-baja-display').classList.add('hidden');
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
			hideAll();
			optionButtons[i].classList.remove('option-button-selected');
		}
		this.classList.add('option-button-selected');
		var actionSelected = document.getElementsByClassName('option-button-selected')[0];
		popupTitle.innerHTML = actionSelected.innerHTML; 
		if (actionSelected.getAttribute('id') == 'alta-tramite') {
			document.getElementById('codigo').classList.remove('hidden');
			elementsToHide.push('codigo');
			document.getElementById('nombre-tramite').classList.remove('hidden');
			elementsToHide.push('nombre-tramite');
			document.getElementById('j_idt7:alta-tramite-button').classList.remove('hidden');
			elementsToHide.push('j_idt7:alta-tramite-button');
		} else if (actionSelected.getAttribute('id') == 'baja-tramite') {
			document.getElementById('list-tramites-container').classList.remove('hidden');
			elementsToHide.push('list-tramites-container');
			document.getElementById('j_idt7:baja-tramite-button').classList.remove('hidden');
			elementsToHide.push('j_idt7:baja-tramite-button');
		} else if (actionSelected.getAttribute('id') == 'mod-tramite') {
			document.getElementById('list-tramites-container').classList.remove('hidden');
			elementsToHide.push('list-tramites-container');
			document.getElementById('nombre-tramite').classList.remove('hidden');
			elementsToHide.push('nombre-tramite');
			document.getElementById('j_idt7:mod-tramite-button').classList.remove('hidden');
			elementsToHide.push('j_idt7:mod-tramite-button');
		}	
	    popup.classList.remove('hidden');
    }, false);
}
