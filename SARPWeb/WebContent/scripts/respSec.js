for (var i = 0; i < optionButtons.length; i++) {
	optionButtons[i].addEventListener('click', function(event){
		for (var i = 0; i < optionButtons.length; i++) {
			hideAll();
			optionButtons[i].classList.remove('option-button-selected');
		}
		this.classList.add('option-button-selected');
		var actionSelected = document.getElementsByClassName('option-button-selected')[0];
		popupTitle.innerHTML = actionSelected.innerHTML; 
		// ALTA PUESTO
		if (actionSelected.getAttribute('id') == 'alta-puesto') {
			elementsToHide.push('list-puestos-container');
			document.getElementById('maquina-puesto').classList.remove('hidden');
			elementsToHide.push('maquina-puesto');
			document.getElementById('numero-puesto').classList.remove('hidden');
			elementsToHide.push('numero-puesto');
			document.getElementById('form-popup:alta-puesto-button').classList.remove('hidden');
			elementsToHide.push('form-popup:alta-puesto-button');
		// BAJA PUESTO
		} else if (actionSelected.getAttribute('id') == 'baja-puesto') {
			elementsToSelect.puesto.toSelect = true;
			document.getElementById('list-puestos-container').classList.remove('hidden');
			elementsToHide.push('list-puestos-container');
			document.getElementById('form-popup:baja-puesto-button').classList.remove('hidden');
			elementsToHide.push('form-popup:baja-puesto-button');
		// MOD PUESTO	
		} else if (actionSelected.getAttribute('id') == 'mod-puesto') {
			elementsToSelect.puesto.toSelect = true;
			document.getElementById('list-puestos-container').classList.remove('hidden');
			elementsToHide.push('list-puestos-container');
			document.getElementById('estado-puesto').classList.remove('hidden');
			elementsToHide.push('estado-puesto');
			document.getElementById('numero-puesto').classList.remove('hidden');
			elementsToHide.push('numero-puesto');
			document.getElementById('usuario-puesto').classList.remove('hidden');
			elementsToHide.push('usuario-puesto');
			document.getElementById('form-popup:mod-puesto-button').classList.remove('hidden');
			elementsToHide.push('form-popup:mod-puesto-button');
		// ASIGNAR TRAMITE A PUESTO	
		} else if (actionSelected.getAttribute('id') == 'asignar-tramite-puesto') {
			elementsToSelect.tramite.toSelect = true;
			elementsToSelect.puesto.toSelect = true;
			document.getElementById('list-puestos-container').classList.remove('hidden');
			document.getElementById('list-puestos-container').classList.add('multiple-lists');
			elementsToHide.push('list-puestos-container');
			document.getElementById('list-tramites-container').classList.remove('hidden');
			document.getElementById('list-tramites-container').classList.add('multiple-lists');
			document.getElementById('list-tramites-container').classList.add('last-list');
			elementsToHide.push('list-tramites-container');
			document.getElementById('form-popup:asignar-tramite-puesto-button').classList.remove('hidden');
			elementsToHide.push('form-popup:asignar-tramite-puesto-button');
		// ASIGNAR PUSTO A SECTOR	
		} else if (actionSelected.getAttribute('id') == 'asignar-puesto-sector') {
			elementsToSelect.sector.toSelect = true;
			elementsToSelect.puesto.toSelect = true;
			document.getElementById('list-puestos-container').classList.remove('hidden');
			document.getElementById('list-puestos-container').classList.add('multiple-lists');
			elementsToHide.push('list-puestos-container');
			document.getElementById('list-sectores-container').classList.remove('hidden');
			document.getElementById('list-sectores-container').classList.add('multiple-lists');
			document.getElementById('list-sectores-container').classList.add('last-list');
			elementsToHide.push('list-sectores-container');
			document.getElementById('form-popup:asignar-puesto-sector-button').classList.remove('hidden');
			elementsToHide.push('form-popup:asignar-puesto-sector-button');
		}
	    popup.classList.remove('hidden');
	    event.preventDefault();
    }, false);
}