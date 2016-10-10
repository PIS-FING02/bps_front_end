for (var i = 0; i < listElements.length; i++) {
	listElements[i].addEventListener('click', function(){
		for (var i = 0; i < listElements.length; i++) {
			listElements[i].classList.remove('element-list-selected');
		}
		var buttonSelected = document.getElementsByClassName('option-button-selected')[0];
		this.classList.add('element-list-selected');
		document.getElementById('form-popup:puesto-selected-maquina').value = this.previousSibling.getAttribute('maquina');
		document.getElementById('form-popup:puesto-selected-usuario').value = this.previousSibling.getAttribute('usuario');
		document.getElementById('form-popup:puesto-selected-estado').value = this.previousSibling.getAttribute('estado');
		var sad = this.previousSibling.getAttribute('numero');
		document.getElementById('form-popup:puesto-selected-numero').value = sad;
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
			document.getElementById('numero').classList.remove('hidden');
			elementsToHide.push('numero');
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
			document.getElementById('estado').classList.remove('hidden');
			elementsToHide.push('estado');
			document.getElementById('numero').classList.remove('hidden');
			elementsToHide.push('numero');
			document.getElementById('usuario').classList.remove('hidden');
			elementsToHide.push('usuario');
			document.getElementById('form-popup:mod-puesto-button').classList.remove('hidden');
			elementsToHide.push('form-popup:mod-puesto-button');
		} 
	    popup.classList.remove('hidden');
	    event.preventDefault();
    }, false);
}