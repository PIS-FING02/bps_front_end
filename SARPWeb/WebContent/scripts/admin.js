var optionButtons = document.getElementsByClassName('option-button');
var popup = document.getElementById('action-admin-popup');
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


for (var i = 0; i < optionButtons.length; i++) {
  optionButtons[i].addEventListener('click', function(){
    popup.classList.remove("hidden");
  }, false);
}

for (var i = 0; i < listElements.length; i++) {
	listElements[i].addEventListener('click', function(){
		for (var i = 0; i < listElements.length; i++) {
			listElements[i].classList.remove('element-list-selected');
		}
		this.classList.add('element-list-selected');
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
		popupTitle.innerHTML = actionSelected.getAttribute('value'); 
		if (actionSelected.getAttribute('id') == 'form:alta-tramite') {
			document.getElementById('codigo').classList.remove('hidden');
			elementsToHide.push('codigo');
			document.getElementById('nombre-tramite').classList.remove('hidden');
			elementsToHide.push('nombre-tramite');
			document.getElementById('form-popup:alta-tramite-button').classList.remove('hidden');
			elementsToHide.push('form-popup:alta-tramite-button');
		} else if (actionSelected.getAttribute('id') == 'form:baja-tramite') {
			document.getElementById('list-tramites-container').classList.remove('hidden');
			elementsToHide.push('list-tramites-container');
			document.getElementById('form-popup:baja-tramite-button').classList.remove('hidden');
			elementsToHide.push('form-popup:baja-tramite-button');
			document.getElementById('form-popup:baja-tramite-button').classList.remove('hidden');
			elementsToHide.push('form-popup:mod-tramite-button');
		} else if (actionSelected.getAttribute('id') == 'form:mod-tramite') {
			document.getElementById('list-tramites-container').classList.remove('hidden');
			elementsToHide.push('list-tramites-container');
			document.getElementById('nombre-tramite').classList.remove('hidden');
			elementsToHide.push('nombre-tramite');
			document.getElementById('form-popup:mod-tramite-button').classList.remove('hidden');
			elementsToHide.push('form-popup:mod-tramite-button');
		} else if (actionSelected.getAttribute('id') == 'form:alta-display') {
			document.getElementById('displayId').classList.remove('hidden');
			elementsToHide.push('displayId');
			document.getElementById('rutaArchivo').classList.remove('hidden');
			elementsToHide.push('rutaArchivo');
			document.getElementById('form-popup:alta-display-button').classList.remove('hidden');
			elementsToHide.push('form-popup:alta-display-button');
		} else if (actionSelected.getAttribute('id') == 'form:baja-display') {
			document.getElementById('list-displays-container').classList.remove('hidden');
			elementsToHide.push('list-displays-container');
			document.getElementById('form-popup:baja-display-button').classList.remove('hidden');
			elementsToHide.push('form-popup:baja-display-button');
		}else if (actionSelected.getAttribute('id') == 'form:mod-display') {
			document.getElementById('list-displays-container').classList.remove('hidden');
			elementsToHide.push('list-displays-container');
			document.getElementById('displayId').classList.remove('hidden');
			elementsToHide.push('displayId');
			document.getElementById('form-popup:mod-display-button').classList.remove('hidden');
			elementsToHide.push('form-popup:mod-display-button');
		}
	    popup.classList.remove('hidden');
	    event.preventDefault();
    }, false);
}

