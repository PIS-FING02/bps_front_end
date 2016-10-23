var esSector = !!document.getElementById('form-asociacion:es-sector') ? document.getElementById('form-asociacion:es-sector').innerHTML : null;
var entidad = !!document.getElementById('form-asociacion:entidad-llamado') ? document.getElementById('form-asociacion:entidad-llamado').innerHTML : null;
var esAsig = !!document.getElementById('form-asociacion:es-asig') ? document.getElementById('form-asociacion:es-asig').innerHTML : null;


//ENABLE ACTION BUTTONS IF ELEMENT SELECTED
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
		if(entidad == "puesto"){
			document.getElementById('form-entidades:id-puesto-selected').value = document.getElementById('form-asociacion:id-asig').innerHTML;
			document.getElementById('form-entidades:id-puesto-sector-selected').value = document.getElementsByClassName('element-list-selected')[0].previousSibling.getAttribute('nombreMaquina');
		}else if(entidad == "display"){
			document.getElementById('form-entidades:id-display-selected').value = document.getElementById('form-asociacion:id-asig').innerHTML;
			document.getElementById('form-entidades:id-display-sector-selected').value = document.getElementsByClassName('element-list-selected')[0].previousSibling.getAttribute('displayId');
		}else{
			if (esSector == "true") {
				document.getElementById('form-entidades:id-sector-selected').value = document.getElementById('form-asociacion:id-asig').innerHTML;
				document.getElementById('form-entidades:id-tramite-sector-selected').value = document.getElementsByClassName('element-list-selected')[0].previousSibling.getAttribute('codigo');
			} else {
				document.getElementById('form-entidades:id-puesto-selected').value = document.getElementById('form-asociacion:id-asig').innerHTML;	
				document.getElementById('form-entidades:id-tramite-puesto-selected').value = document.getElementsByClassName('element-list-selected')[0].previousSibling.getAttribute('codigo');
			}
		}
	}, false);
}

if(entidad == "tramite"){
	if (esAsig == "true"){
		if (esSector == "true") {
			document.getElementById('form-entidades:asignar-tramite-sector-button').classList.remove('hidden');
		} else {
			document.getElementById('form-entidades:asignar-tramite-puesto-button').classList.remove('hidden');
		}
	}else{
		if (esSector == "true") {
			document.getElementById('form-entidades:desasignar-tramite-sector-button').classList.remove('hidden');
		} else {
			document.getElementById('form-entidades:desasignar-tramite-puesto-button').classList.remove('hidden');
		}
	}
}

if(entidad == "puesto"){
	if (esAsig == "true") {
			document.getElementById('form-entidades:asignar-tramite-sector-button').classList.remove('hidden');
		} else {
			document.getElementById('form-entidades:desasignar-tramite-sector-button').classList.remove('hidden');
		}
}

if(entidad == "display"){
	if (esAsig == "true") {
			document.getElementById('form-entidades:asignar-display-sector-button').classList.remove('hidden');
	} else {
			document.getElementById('form-entidades:desasignar-display-sector-button').classList.remove('hidden');
	}
}





