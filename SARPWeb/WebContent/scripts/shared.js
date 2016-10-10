var optionButtons = document.getElementsByClassName("option-button");
var popup = document.getElementById('action-popup');
var popupTitle = document.getElementById('popup-title');
var cancelButton = document.getElementById('popup-cancel-button');
var closeButton = document.getElementById('popup-close-button');
var listElements = document.getElementsByClassName('element-list');
var listActionButtons = document.getElementsByClassName('action-button-list');
var formInputs = document.getElementsByClassName('formInput');
var actionButtons = document.getElementsByClassName('action-button');

var elementsToHide = [];
var elementSelected = false;

// HIDE ELEMTS SHOWN
function hideAll() {
	for (var i = 0; i < elementsToHide.length; i++) {
		document.getElementById(elementsToHide[i]).classList.add('hidden');
	}
	elementsToHide = [];
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
		} else if (elementSelected){
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
		for (var i = 0; i < listActionButtons.length; i++) {
			listActionButtons[i].classList.remove('deactivated');
			listActionButtons[i].disabled = false;
			elementSelected = true;
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

// HAS CLASS
function hasClass(elem, klass ) {
    return (" " + elem.className + " " ).indexOf( " "+klass+" " ) > -1;
}

// CLOSE POPUP AND CLEANUP
cancelButton.addEventListener('click', function(){
	popup.classList.add("hidden");
	elementSelected = false;
	for (var i = 0; i < listElements.length; i++) {
		if (hasClass(listElements[i], 'element-list-selected')) {
			listElements[i].classList.remove('element-list-selected');
		}
	}
	for (var i = 0; i < listActionButtons.length; i++) {
		listActionButtons[i].classList.add('deactivated');
		listActionButtons[i].disabled = true;
	}	
}, false);

//CLOSE POPUP AND CLEANUP
closeButton.addEventListener('click', function(){
	elementSelected = false;
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
}, false);

// OPEN POPUP
for (var i = 0; i < optionButtons.length; i++) {
  optionButtons[i].addEventListener('click', function(){
    popup.classList.remove("hidden");
  }, false);
}