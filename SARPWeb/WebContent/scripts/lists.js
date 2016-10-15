var esSector = document.getElementById('es-sector')

// ENABLE ACTION BUTTONS IF ELEMENT SELECTED
for (var i = 0; i < listElements.length; i++) {
	listElements[i].addEventListener('click', function(){
		for (var i = 0; i < listElements.length; i++) {
			listElements[i].classList.remove('element-list-selected');
		}
		this.classList.add('element-list-selected');
		for (var i = 0; i < listActionButtons.length; i++) {
			listActionButtons[i].classList.remove('deactivated');
			listActionButtons[i].disabled = false;
		}	
		if (esSector) {
			document.getElementById('form-puesto:id-sector-selected').value = document.getElementById('form-puesto:id-asig').innerHTML;
		} else {
			document.getElementById('form-puesto:id-tramite-selected').value = document.getElementById('form-puesto:id-asig').innerHTML;	
		}
		document.getElementById('form-puesto:id-tramite-selected').value = document.getElementsByClassName('element-list-selected')[0].previousSibling.getAttribute('codigo');
	}, false);
}

if (esSector) {
	document.getElementById('form-puesto:asignar-tramite-sector-button').classList.remove('hidden');
} else {
	document.getElementById('form-puesto:asignar-tramite-puesto-button').classList.remove('hidden');
}