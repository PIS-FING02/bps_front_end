for (var i = 0; i < listElements.length; i++) {
	listElements[i].addEventListener('click', function(){
		for (var i = 0; i < listElements.length; i++) {
			listElements[i].classList.remove('element-list-selected');
		}
		var buttonSelected = document.getElementsByClassName('option-button-selected')[0];
		this.classList.add('element-list-selected');
		if (hasClass(buttonSelected, 'tipo-tramite')) {
			document.getElementById('form-popup:tramite-selected').value = this.previousSibling.getAttribute('id');
		} else if (hasClass(buttonSelected, 'tipo-display')){
			document.getElementById('form-popup:display-selected').value = this.previousSibling.getAttribute('id');
		}
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
			document.getElementById('rutaArchivo').classList.remove('hidden');
			elementsToHide.push('rutaArchivo');
			document.getElementById('form-popup:mod-display-button').classList.remove('hidden');
			elementsToHide.push('form-popup:mod-display-button');
		}
	    popup.classList.remove('hidden');
	    event.preventDefault();
    }, false);
}

