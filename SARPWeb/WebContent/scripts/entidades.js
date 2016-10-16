var alta = document.getElementsByClassName('alta-button');
var bajas = document.getElementsByClassName('baja-button');
var editar = document.getElementsByClassName('mod-button');
var asignarTramiteSector = document.getElementsByClassName('asignar-sector-button');
var asignarPuestoSector = document.getElementsByClassName('asignar-puesto-button');
var asignarTramitePuesto = document.getElementsByClassName('asignar-tramite-button');
var asignarDisplaySector = document.getElementsByClassName('asignar-display-button');



// ALTAS
if(alta[0]){
	alta[0].addEventListener('click', function(){
		if (hasClass(this, 'tipo-tramite')) {
			popupTitle.innerHTML = "Alta Tramite"; 
			document.getElementById('nombre-tramite').classList.remove('hidden');
			elementsToHide.push('nombre-tramite');
			document.getElementById('form-tramite:alta-tramite-button').classList.remove('hidden');
			elementsToHide.push('form-tramite:alta-tramite-button');
		} else if (hasClass(this, 'tipo-display')) {
			popupTitle.innerHTML = "Alta Display"; 
			document.getElementById('id-display').classList.remove('hidden');
			elementsToHide.push('id-display');
			document.getElementById('form-display:alta-display-button').classList.remove('hidden');
			elementsToHide.push('form-display:alta-display-button');
		} else {
			popupTitle.innerHTML = "Alta Puesto"; 
			elementsToHide.push('list-puestos-container');
			document.getElementById('maquina-puesto').classList.remove('hidden');
			elementsToHide.push('maquina-puesto');
			document.getElementById('numero-puesto').classList.remove('hidden');
			elementsToHide.push('numero-puesto');
			document.getElementById('form-puesto:alta-puesto-button').classList.remove('hidden');
			elementsToHide.push('form-puesto:alta-puesto-button');
		}
		popup.classList.remove("hidden");
	}, false);
}

//	BAJAS
for (var i = 0; i < bajas.length; i++) {
	bajas[i].addEventListener('click', function(){
		var parent = this.parentElement;
		updateInputs(parent);
		if (hasClass(this, 'tipo-tramite')) {
			document.getElementById('form-tramite:baja-tramite-button').click();	
		} else if (hasClass(this, 'tipo-display')) {
			document.getElementById('form-display:baja-display-button').click();				
		} else if (hasClass(this, 'tipo-puesto')) {
			document.getElementById('form-puesto:baja-puesto-button').click();				
		}
	}, false);
}

// MODS
for (var i = 0; i < editar.length; i++) {
	editar[i].addEventListener('click', function(){
		updateInputs(this.parentElement);
		if (hasClass(this, 'tipo-tramite')) {
			popupTitle.innerHTML = "Modificar Tramite"; 
			document.getElementById('nombre-tramite').classList.remove('hidden');
			elementsToHide.push('nombre-tramite');
			document.getElementById('form-tramite:mod-tramite-button').classList.remove('hidden');
			elementsToHide.push('form-tramite:mod-tramite-button');
		} else if (hasClass(this, 'tipo-display')) {

		} else if (hasClass(this, 'tipo-puesto')) {
			popupTitle.innerHTML = "Modificar Puesto"; 
			document.getElementById('estado-puesto').classList.remove('hidden');
			elementsToHide.push('estado-puesto');
			document.getElementById('numero-puesto').classList.remove('hidden');
			elementsToHide.push('numero-puesto');
			document.getElementById('usuario-puesto').classList.remove('hidden');
			elementsToHide.push('usuario-puesto');
			document.getElementById('form-puesto:mod-puesto-button').classList.remove('hidden');
			elementsToHide.push('form-puesto:mod-puesto-button');
		}
		popup.classList.remove("hidden");
	}, false);
}

for (var i = 0; i < asignarTramiteSector.length; i++){
	asignarTramiteSector[i].addEventListener('click', function(){
		var  esSector = hasClass(document.getElementById("entidad"), "page-sectores");
		if(esSector){
			var id = this.parentElement.previousSibling.previousSibling.getAttribute('idSector');
			this.href = 'listaTramites.xhtml?esSec=true&entidad=tramite&id=' + id;
		} else {
			var id = this.parentElement.previousSibling.previousSibling.getAttribute('maquina');
			this.href = 'listaTramites.xhtml?esSec=false&entidad=tramite&id=' + id;
		}
		
	}, false);
}

for (var i = 0; i < asignarPuestoSector.length; i++){
	asignarPuestoSector[i].addEventListener('click', function(){
			var  esSector = hasClass(document.getElementById("entidad"), "page-sectores");
			if(esSector){
				var id = this.parentElement.previousSibling.previousSibling.getAttribute('idSector');
				this.href = 'listaPuestos.xhtml?esSec=true&entidad=puesto&id=' + id;
			} 
			
		}, false);
	}

for (var i = 0; i < asignarDisplaySector.length; i++){
	asignarDisplaySector[i].addEventListener('click', function(){
			var  esSector = hasClass(document.getElementById("entidad"), "page-sectores");
			if(esSector){
				var id = this.parentElement.previousSibling.previousSibling.getAttribute('idSector');
				this.href = 'listaDisplays.xhtml?esSec=true&entidad=display&id=' + id;
			} 
			
		}, false);
	}

for (var i = 0; i < asignarTramitePuesto.length; i++) {
	asignarTramitePuesto[i].addEventListener('click', function(){
		var esSector = hasClass(document.getElementById("entidad"), "page-sectores");
		if(esSector){
			var id = this.parentElement.previousSibling.previousSibling.getAttribute('idSector');
			this.href = 'listaTramites.xhtml?esSec=true&id=' + id;
		} else {
			var id = this.parentElement.previousSibling.previousSibling.getAttribute('maquina');
			this.href = 'listaTramites.xhtml?esSec=false&id=' + id;
		}
		
	}, false);
}	


//UPDATE INPUT VALUES AFTER SELECTING ELEMENT FROM LIST
function updateInputs (element) {
	if (hasClass(element, 'tramite-element')) {
		document.getElementById('form-tramite:tramite-selected-codigo').value = element.previousElementSibling.getAttribute('codigo');
		document.getElementById('form-tramite:tramite-selected-nombre').value = element.previousElementSibling.getAttribute('nombre');
	} else if (hasClass(element, 'display-element')){
		document.getElementById('form-display:display-selected-id').value = element.previousElementSibling.getAttribute('id');
	} else if (hasClass(element, 'puesto-element')){
		document.getElementById('form-puesto:puesto-selected-maquina').value = element.previousElementSibling.getAttribute('maquina');
		document.getElementById('form-puesto:puesto-selected-usuario').value = element.previousElementSibling.getAttribute('usuario');
		document.getElementById('form-puesto:puesto-selected-estado').value = element.previousElementSibling.getAttribute('estado');
		document.getElementById('form-puesto:puesto-selected-numero').value = element.previousElementSibling.getAttribute('numero');
	}
}
