//===================FUNCTIONS===================

// GET URL PARAMETER
	function getURLParameter(name) {
		return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
	}



	// CHECK IN-FOMRS INPUTS EMPTY
	function inputsNotEmpty() {
		var res = true;
		var i = 0;
		while (res && i < inFormInputs.length){
			res = inFormInputs[i].value != "";
			if (inFormInputs[i].getAttribute('id') == 'form:puesto-selected-numero'){
				res = !hasNotNumber(inFormInputs[i].value) && inFormInputs[i].value != "";
			}
			i++;
		}
		return res;
	}

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


	// CHECK IF INPUT HAS SOMETHING OTHER THAN NUMBERS
	function hasNotNumber(myString) {
		return /\D/.test(myString);
	}

	// UPDATE INPUT VALUES 
	function updateInputs (element) {
		if (hasClass(element, 'tramite-element')) {
			document.getElementById('form-popup:tramite-selected-codigo').value = element.previousSibling.getAttribute('codigo');
			document.getElementById('form-popup:tramite-selected-nombre').value = element.previousSibling.getAttribute('nombre');
		} else if (hasClass(element, 'display-element')){
			document.getElementById('form-popup:display-selected-id').value = element.previousSibling.getAttribute('id');
			document.getElementById('form-popup:display-selected-ruta').value = element.previousSibling.getAttribute('ruta');
		} else if (hasClass(element, 'puesto-element')){
			document.getElementById('form-popup:puesto-selected-maquina').value = element.previousSibling.getAttribute('maquina');
			document.getElementById('form-popup:puesto-selected-estado').value = element.previousSibling.getAttribute('estado');
			document.getElementById('form-popup:puesto-selected-numero').value = element.previousSibling.getAttribute('numero');
			document.getElementById('form-popup:puesto-selected-usuario').value = element.previousSibling.getAttribute('usuario');
		}
	}
	
	//===================FUNCTIONS THAT USE DOM===================
	
document.addEventListener("DOMContentLoaded", function() { 
	
	var optionButtons = document.getElementsByClassName("option-button");
	var popup = document.getElementById('action-popup');
	var popupTitle = document.getElementById('popup-title');
	var cancelButton = document.getElementById('popup-cancel-button');
	var closeButton = document.getElementById('popup-close-button');
	var listElements = document.getElementsByClassName('element-list');
	var entityActionButtons = document.getElementsByClassName('action-button-entity');
	var listActionButtons = document.getElementsByClassName('action-button-list');
	var formInputs = document.getElementsByClassName('formInput');
	var inFormInputs = document.getElementsByClassName('in-form');
	var popupOpenButtons = document.getElementsByClassName('popup-open-button');
	var elementsToHide = [];
	
	// ACTIVATE/DEACTIVATE FORM BUTTONS ACCORDING TO INPUTS BEIGN EMPTY OR NOT
	for (var i = 0; i < formInputs.length; i++) {
		formInputs[i].addEventListener('input', function(){
			if (inputsNotEmpty()) {
				for (var i = 0; i < entityActionButtons.length; i++) {
					entityActionButtons[i].classList.remove("deactivated");
				}
			} else {
				for (var i = 0; i < entityActionButtons.length; i++) {
					entityActionButtons[i].classList.add("deactivated");
				}
			}
		});
	}

	// BLOCK PAGE SCROLL WHEN POPUP OPEN
	for (var i = 0; i < popupOpenButtons.length; i++) {
		popupOpenButtons[i].addEventListener('click', function(){ 
			if (!this.classList.contains('deactivated')) {
				popup.classList.remove("hidden");
				document.getElementsByTagName("BODY")[0].classList.add('body-not-scroll')
			}
		}, false);
	}

	// SET ACTION BUTTONS DISABLED ON PAGE LOAD
	for (var i = 0; i < listActionButtons.length; i++) {
		listActionButtons[i].disabled = true;
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
	if(!!cancelButton){
		
		cancelButton.addEventListener('click', function(){
			popup.classList.add("hidden");
			for (var i = 0; i < listElements.length; i++) {
				if (hasClass(listElements[i], 'element-list-selected')) {
					listElements[i].classList.remove('element-list-selected');
				}
			}
			for (var i = 0; i < entityActionButtons.length; i++) {
				entityActionButtons[i].classList.add('hidden');
			}	
			var lists = document.getElementsByClassName('multiple-lists');
			for (var i = 0; i < lists.length; i++) {
				lists[i].classList.remove('last-list');
				lists[i].classList.remove('multiple-lists');
			}	
			document.getElementsByTagName("BODY")[0].classList.remove('body-not-scroll')
		}, false);
	}
	

	
});

