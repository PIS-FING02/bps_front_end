var optionButtons = document.getElementsByClassName('option-button');
var popup = document.getElementById('action-respSector-popup');
var cancelButton = document.getElementById('popup-cancel-button');
var closeButton = document.getElementById('popup-close-button');
var popupTitle = document.getElementById('popup-title');
var listElements = document.getElementsByClassName('element-list');

var elementsToHide = [];

function hideAll() {
	for (var i = 0; i < elementsToHide.length; i++) {
		document.getElementById(elementsToHide[i]).classList.add('hidden');
	}
	elementsToHide = [];
}

cancelButton.addEventListener('click', function(){
	popup.classList.add("hidden");
}, false);

closeButton.addEventListener('click', function(){
	popup.classList.add("hidden");
}, false);

for (var i = 0; i < listElements.length; i++) {
	listElements[i].addEventListener('click', function(){
		for (var i = 0; i < listElements.length; i++) {
			listElements[i].classList.remove('element-list-selected');
		}
		var buttonSelected = document.getElementsByClassName('option-button-selected')[0];
		this.classList.add('element-list-selected');
		document.getElementById('form-popup:puesto-selected').value = this.previousSibling.getAttribute('id');
  }, false);
}

for (var i = 0; i < optionButtons.length; i++) {
  optionButtons[i].addEventListener('click', function(){
    popup.classList.remove("hidden");
  }, false);
}

for (var i = 0; i < optionButtons.length; i++) {
	optionButtons[i].addEventListener('click', function(event){
		for (var i = 0; i < optionButtons.length; i++) {
			hideAll();
			optionButtons[i].classList.remove('option-button-selected');
		}
		this.classList.add('option-button-selected');
		var actionSelected = document.getElementsByClassName('option-button-selected')[0];
		popupTitle.innerHTML = actionSelected.getAttribute("value"); 
		if (actionSelected.getAttribute('id') == 'form:alta-puesto') {
			elementsToHide.push('list-puestos-container');
			document.getElementById('maquina').classList.remove('hidden');
			elementsToHide.push('maquina');
			document.getElementById('usuario').classList.remove('hidden');
			elementsToHide.push('usuario');
			document.getElementById('puesto').classList.remove('hidden');
			elementsToHide.push('puesto');
			document.getElementById('estado').classList.remove('hidden');
			elementsToHide.push('estado');
			document.getElementById('form-popup:alta-puesto-button').classList.remove('hidden');
			elementsToHide.push('form-popup:alta-puesto-button');
		} else if (actionSelected.getAttribute('id') == 'form:baja-puesto') {
			document.getElementById('list-puestos-container').classList.remove('hidden');
			elementsToHide.push('list-puestos-container');
			document.getElementById('form-popup:baja-puesto-button').classList.remove('hidden');
			elementsToHide.push('form-popup:baja-puesto-button');
		} else if (actionSelected.getAttribute('id') == 'form:mod-puesto') {
			document.getElementById('list-puestos-container').classList.remove('hidden');
			elementsToHide.push('list-puestos-container');
			document.getElementById('maquina').classList.remove('hidden');
			elementsToHide.push('maquina');
			document.getElementById('usuario').classList.remove('hidden');
			elementsToHide.push('usuario');
			document.getElementById('puesto').classList.remove('hidden');
			elementsToHide.push('puesto');
			document.getElementById('estado').classList.remove('hidden');
			elementsToHide.push('estado');
			document.getElementById('form-popup:mod-puesto-button').classList.remove('hidden');
			elementsToHide.push('form-popup:mod-puesto-button');
		} 
	    popup.classList.remove('hidden');
	    event.preventDefault();
    }, false);
}