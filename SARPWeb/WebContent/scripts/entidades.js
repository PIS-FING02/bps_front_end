var alta = document.getElementsByClassName('alta-button');
var bajas = document.getElementsByClassName('baja-button');
var editar = document.getElementsByClassName('mod-button');
var asignarTramiteSector = document.getElementsByClassName('asignar-sector-button');
var asignarPuestoSector = document.getElementsByClassName('asignar-puesto-button');
var asignarTramitePuesto = document.getElementsByClassName('asignar-tramite-button');
var asignarDisplaySector = document.getElementsByClassName('asignar-display-button');
var iconContainer = document.getElementsByClassName('icon-container');
var asignarContainer = document.getElementsByClassName('asignar-container');

	// ALTA TRAMITE
if (getURLParameter('tipoForm') == 'altaTramite') {
	document.getElementById('alta-mod-tramite-fields').classList.remove('hidden');
	document.getElementById('form:alta-tramite-button').classList.remove('hidden');
	document.getElementById('title-admin').classList.remove('hidden');
	document.getElementById('title-tramites').classList.remove('hidden');
	document.getElementById('sub-title').innerHTML= 'Crear Tramite';
	// MOD TRAMITE
} else if (getURLParameter('tipoForm') == 'modTramite') {
	document.getElementById('alta-mod-tramite-fields').classList.remove('hidden');
	document.getElementById('form:mod-tramite-button').classList.remove('hidden');
	document.getElementById('title-admin').classList.remove('hidden');
	document.getElementById('title-tramites').classList.remove('hidden');
	document.getElementById('form:tramite-selected-codigo').value = getURLParameter('codigo').replace("+", " ");
	document.getElementById('form:tramite-selected-nombre').value = getURLParameter('nombre').replace("+", " ");
	document.getElementById('sub-title').innerHTML= 'Modificar Tramite';
	// ALTA PUESTO
} else if (getURLParameter('tipoForm') == 'altaPuesto') {
	document.getElementById('maquina-puesto').classList.remove('hidden');
	document.getElementById('numero-puesto').classList.remove('hidden');
	document.getElementById('form:alta-puesto-button').classList.remove('hidden');
	document.getElementById('title-gestion').classList.remove('hidden');
	document.getElementById('title-puestos').classList.remove('hidden');
	document.getElementById('sub-title').innerHTML= 'Crear Puesto';
	// MOD PUESTO
} else if (getURLParameter('tipoForm') == 'modPuesto') {
	document.getElementById('numero-puesto').classList.remove('hidden');
	document.getElementById('estado-puesto').classList.remove('hidden');
	document.getElementById('usuario-puesto').classList.remove('hidden');
	document.getElementById('title-gestion').classList.remove('hidden');
	document.getElementById('title-puestos').classList.remove('hidden');
	document.getElementById('form:puesto-selected-numero').value = getURLParameter('numero').replace("+", " ");
	document.getElementById('form:puesto-selected-estado').value = getURLParameter('estado').replace("+", " ");
	document.getElementById('form:puesto-selected-usuario').value = getURLParameter('usuario').replace("+", " ");
	document.getElementById('form:puesto-selected-maquina').value = getURLParameter('maquina').replace("+", " ");
	document.getElementById('form:mod-puesto-button').classList.remove('hidden');
	document.getElementById('sub-title').innerHTML= 'Modificar Puesto';
	// ALTA DISPLAY
} else if (getURLParameter('tipoForm') == 'altaDisplay') {
	document.getElementById('alta-display-fields').classList.remove('hidden');
	document.getElementById('form:alta-display-button').classList.remove('hidden');
	document.getElementById('title-admin').classList.remove('hidden');
	document.getElementById('title-displays').classList.remove('hidden');
	document.getElementById('sub-title').innerHTML= 'Crear Display';
}

// ASIGNAR TRAMITE A SECTOR
for (var i = 0; i < asignarTramiteSector.length; i++){
	asignarTramiteSector[i].addEventListener('click', function(){
		var  esSector = hasClass(document.getElementById("entidad"), "page-sectores");
		if(esSector){
			var id = this.parentElement.parentElement.previousElementSibling.getAttribute('idSector');
			this.href = 'listaTramites.xhtml?esSec=true&entidad=tramite&id=' + id;
		} else {
			var id = this.parentElement.parentElement.previousElementSibling.getAttribute('maquina');
			this.href = 'listaTramites.xhtml?esSec=false&entidad=tramite&id=' + id;
		}
	}, false);
}

// ASIGNAR PUESTO A SECTOR
for (var i = 0; i < asignarPuestoSector.length; i++){
	asignarPuestoSector[i].addEventListener('click', function(){
			var  esSector = hasClass(document.getElementById("entidad"), "page-sectores");
			if(esSector){
				var id = this.parentElement.parentElement.previousElementSibling.getAttribute('idSector');
				this.href = 'listaPuestos.xhtml?esSec=true&entidad=puesto&id=' + id;
			} 
			
		}, false);
	}

// ASIGNAR DISPLAY A SECTOR
for (var i = 0; i < asignarDisplaySector.length; i++){
	asignarDisplaySector[i].addEventListener('click', function(){
		var  esSector = hasClass(document.getElementById("entidad"), "page-sectores");
		if(esSector){
			var id = this.parentElement.parentElement.previousElementSibling.getAttribute('idSector');
			this.href = 'listaDisplays.xhtml?esSec=true&entidad=display&id=' + id;
		} 
	}, false);
}

// ASIGNAR TRAMITE PUESTO
for (var i = 0; i < asignarTramitePuesto.length; i++) {
	asignarTramitePuesto[i].addEventListener('click', function(){
		var esSector = hasClass(document.getElementById("entidad"), "page-sectores");
		if(esSector){
			var id = this.parentElement.previousSibling.previousSibling.getAttribute('idSector');
			this.href = 'listaTramites.xhtml?esSec=true&id=' + id;
		} else {
			var id = this.parentElement.previousSibling.previousSibling.getAttribute('maquina');
			this.href = 'listaTramitesDePuesto.xhtml?esSec=false&id=' + id;
		}
	}, false);
}	

// SHOW ASIGNAR BOX
for (var i = 0; i < iconContainer.length; i++) {
	iconContainer[i].addEventListener('click', function(e){
		for (var i = 0; i < asignarContainer.length; i++) {
			asignarContainer[i].classList.add('hidden');
			asignarContainer[i].classList.remove('icon-container-selected');
		}
		this.nextElementSibling.classList.remove('hidden');
		this.nextElementSibling.classList.add('icon-container-selected');
		e.preventDefault();
		e.stopPropagation();
	}, false);	
}

// CLICK OUTSIDE ASIGNAR BOX
document.onclick = function(e) {
    if(e.target != document.getElementById('asignar-container')) {
    	var elem = document.getElementsByClassName('icon-container-selected')[0];
    	if (elem)
    		elem.classList.add('hidden');          
    } 
}
