for (var i = 0; i < optionButtons.length; i++) {
	optionButtons[i].addEventListener('click', function(event){
		for (var i = 0; i < optionButtons.length; i++) {
			hideAll();
			optionButtons[i].classList.remove('option-button-selected');
		}
		this.classList.add('option-button-selected');
		var actionSelected = document.getElementsByClassName('option-button-selected')[0];
		popupTitle.innerHTML = actionSelected.innerHTML; 
		// ALTA TRAMITE
		if (actionSelected.getAttribute('id') == 'alta-tramite') {
			document.getElementById('nombre-tramite').classList.remove('hidden');
			elementsToHide.push('nombre-tramite');
			document.getElementById('form-popup:alta-tramite-button').classList.remove('hidden');
			elementsToHide.push('form-popup:alta-tramite-button');
		// BAJA TRAMITE	
		} else if (actionSelected.getAttribute('id') == 'baja-tramite') {
			elementsToSelect.tramite.toSelect = true;
			document.getElementById('list-tramites-container').classList.remove('hidden');
			elementsToHide.push('list-tramites-container');
			document.getElementById('form-popup:baja-tramite-button').classList.remove('hidden');
			elementsToHide.push('form-popup:baja-tramite-button');
			document.getElementById('form-popup:baja-tramite-button').classList.remove('hidden');
			elementsToHide.push('form-popup:mod-tramite-button');
		// MOD TRAMITE	
		} else if (actionSelected.getAttribute('id') == 'mod-tramite') {
			elementsToSelect.tramite.toSelect = true;
			document.getElementById('list-tramites-container').classList.remove('hidden');
			elementsToHide.push('list-tramites-container');
			document.getElementById('nombre-tramite').classList.remove('hidden');
			elementsToHide.push('nombre-tramite');
			document.getElementById('form-popup:mod-tramite-button').classList.remove('hidden');
			elementsToHide.push('form-popup:mod-tramite-button');
		// ALTA DISPLAY	
		} else if (actionSelected.getAttribute('id') == 'alta-display') {
			document.getElementById('ruta-display').classList.remove('hidden');
			elementsToHide.push('ruta-display');
			document.getElementById('form-popup:alta-display-button').classList.remove('hidden');
			elementsToHide.push('form-popup:alta-display-button');
		// BAJA DISPLAY	
		} else if (actionSelected.getAttribute('id') == 'baja-display') {
			elementsToSelect.display.toSelect = true;
			document.getElementById('list-displays-container').classList.remove('hidden');
			elementsToHide.push('list-displays-container');
			document.getElementById('form-popup:baja-display-button').classList.remove('hidden');
			elementsToHide.push('form-popup:baja-display-button');
		// MOD DISPLAY		
		} else if (actionSelected.getAttribute('id') == 'mod-display') {
			elementsToSelect.display.toSelect = true;
			document.getElementById('list-displays-container').classList.remove('hidden');
			elementsToHide.push('list-displays-container');
			document.getElementById('ruta-display').classList.remove('hidden');
			elementsToHide.push('ruta-display');
			document.getElementById('form-popup:mod-display-button').classList.remove('hidden');
			elementsToHide.push('form-popup:mod-display-button');
		}
    }, false);
}