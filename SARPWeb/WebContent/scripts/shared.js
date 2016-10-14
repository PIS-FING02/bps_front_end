var optionButtons = document.getElementsByClassName("option-button");
var popup = document.getElementById('action-popup');
var popupTitle = document.getElementById('popup-title');
var cancelButton = document.getElementById('popup-cancel-button');
var closeButton = document.getElementById('popup-close-button');
var listElements = document.getElementsByClassName('element-list');
var listActionButtons = document.getElementsByClassName('action-button-list');
var formInputs = document.getElementsByClassName('formInput');

var elementsToHide = [];
var elementsToSelect = {
	"tramite": {
		"toSelect": false,
		"selected": false
	},
	"display": {
		"toSelect": false,
		"selected": false
	},
	"puesto": {
		"toSelect": false,
		"selected": false
	},
	"sector": {
		"toSelect": false,
		"selected": false
	}
}

// SET ACTION BUTTONS DISABLED ON PAGE LOAD
for (var i = 0; i < listActionButtons.length; i++) {
	listActionButtons[i].disabled = true;
}

// ENABLE/DISABLE ACTION BUTTONS IF INPUTS EMPTY OR NOT
for (var i = 0; i < formInputs.length; i++) {
	formInputs[i].addEventListener('input', function(){
		if (this.value == "") {
			for (var i = 0; i < listActionButtons.length; i++) {
				listActionButtons[i].classList.add('deactivated');
				listActionButtons[i].disabled = true;
			}	
		} else if (doneSelecting()){
			for (var i = 0; i < listActionButtons.length; i++) {
				listActionButtons[i].classList.remove('deactivated');
				listActionButtons[i].disabled = false;
			}	
		}
    }, false);
}

// ENABLE ACTION BUTTONS IF ELEMENT SELECTED
for (var i = 0; i < listElements.length; i++) {
	listElements[i].addEventListener('click', function(){
		selectElement(this);
		updateInputs(this);
		if (doneSelecting()){
			for (var i = 0; i < listActionButtons.length; i++) {
				listActionButtons[i].classList.remove('deactivated');
				listActionButtons[i].disabled = false;
			}	
		}
    }, false);
}

// MARK ELEMENT AS SELECTED
for (var i = 0; i < optionButtons.length; i++) {
	optionButtons[i].addEventListener('click', function(){
		for (var i = 0; i < optionButtons.length; i++) {
			optionButtons[i].classList.remove("option-button-selected");
		}
		this.classList.add("option-button-selected");
    }, false);
}

// CLOSE POPUP AND CLEANUP
cancelButton.addEventListener('click', function(){
	popup.classList.add("hidden");
	resetElementsToSelect();
	for (var i = 0; i < listElements.length; i++) {
		if (hasClass(listElements[i], 'element-list-selected')) {
			listElements[i].classList.remove('element-list-selected');
		}
	}
	for (var i = 0; i < listActionButtons.length; i++) {
		listActionButtons[i].classList.add('deactivated');
		listActionButtons[i].disabled = true;
	}	
	var lists = document.getElementsByClassName('multiple-lists');
	for (var i = 0; i < lists.length; i++) {
		lists[i].classList.remove('last-list');
		lists[i].classList.remove('multiple-lists');
	}	
}, false);

//CLOSE POPUP AND CLEANUP
closeButton.addEventListener('click', function(){
	resetElementsToSelect();
	popup.classList.add("hidden");
	for (var i = 0; i < listElements.length; i++) {
		if (hasClass(listElements[i], 'element-list-selected')) {
			listElements[i].classList.remove('element-list-selected');
		}
	}
	for (var i = 0; i < listActionButtons.length; i++) {
		listActionButtons[i].classList.add('deactivated');
		listActionButtons[i].disabled = true;
	}	
	var lists = document.getElementsByClassName('multiple-lists');
	for (var i = 0; i < lists.length; i++) {
		lists[i].classList.remove('last-list');
		lists[i].classList.remove('multiple-lists');
	}	
}, false);

//HAS CLASS
function hasClass(elem, klass) {
    return (" " + elem.className + " " ).indexOf( " "+klass+" " ) > -1;
}

//HIDE ELEMENTS SHOW
function hideAll() {
	for (var i = 0; i < elementsToHide.length; i++) {
		document.getElementById(elementsToHide[i]).classList.add('hidden');
	}
	elementsToHide = [];
}

// UPDATE INPUT VALUES AFTER SELECTING ELEMENT FROM LIST
function updateInputs (element) {
	if (hasClass(element, 'tramite-element')) {
		document.getElementById('form-popup:tramite-selected-codigo').value = element.previousSibling.getAttribute('codigo');
		document.getElementById('form-popup:tramite-selected-nombre').value = element.previousSibling.getAttribute('nombre');
	} else if (hasClass(element, 'display-element')){
		document.getElementById('form-popup:display-selected-id').value = element.previousSibling.getAttribute('id');
		document.getElementById('form-popup:display-selected-ruta').value = element.previousSibling.getAttribute('ruta');
	} else if (hasClass(element, 'puesto-element')){
		document.getElementById('form-popup:puesto-selected-maquina').value = element.previousSibling.getAttribute('maquina');
		document.getElementById('form-popup:puesto-selected-usuario').value = element.previousSibling.getAttribute('usuario');
		document.getElementById('form-popup:puesto-selected-estado').value = element.previousSibling.getAttribute('estado');
		document.getElementById('form-popup:puesto-selected-numero').value = element.previousSibling.getAttribute('numero');
	}
}

//SELECTED CORRECT AMOUNT OF LIST ELEMENTS
function doneSelecting() {
	if (elementsToSelect.tramite.toSelect != elementsToSelect.tramite.selected) {
		return false;
	} else if (elementsToSelect.puesto.toSelect != elementsToSelect.puesto.selected) {
		return false;
	} else if (elementsToSelect.display.toSelect != elementsToSelect.display.selected) {
		return false;
	} else if (elementsToSelect.sector.toSelect != elementsToSelect.sector.selected) {
		return false;
	} else {
		return true;
	}
}

// RESET ELEMENTS TO SELECT
function resetElementsToSelect () {
	elementsToSelect = {
		"tramite": {
			"toSelect": false,
			"selected": false
		},
		"display": {
			"toSelect": false,
			"selected": false
		},
		"puesto": {
			"toSelect": false,
			"selected": false
		},
		"sector": {
			"toSelect": false,
			"selected": false
		}
	}
}

// SELECT ELEMENTO FROM LIST ACCORDING TO ITS TYPE
function selectElement (element){
	if (hasClass(element, 'tramite-element')) {
		elementsToSelect.tramite.selected = true;
		var otherElements = document.getElementsByClassName('tramite-element');
	} else if (hasClass(element, 'puesto-element')) {
		elementsToSelect.puesto.selected = true;
		var otherElements = document.getElementsByClassName('puesto-element');
	} else if (hasClass(element, 'display-element')) {
		elementsToSelect.display.selected = true;
		var otherElements = document.getElementsByClassName('display-element');
	} else if (hasClass(element, 'sector-element')) {
		elementsToSelect.sector.selected = true;
		var otherElements = document.getElementsByClassName('sector-element');
	}
	for (var i = 0; i < otherElements.length; i++) {
		otherElements[i].classList.remove('element-list-selected');
	}
	element.classList.add('element-list-selected');
}