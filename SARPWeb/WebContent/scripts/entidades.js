document.addEventListener("DOMContentLoaded", function() { 
	
	var alta = document.getElementsByClassName('alta-button');
	var bajas = document.getElementsByClassName('baja-button');
	var editar = document.getElementsByClassName('mod-button');
	var asignarTramiteSector = document.getElementsByClassName('asignar-sector-button');
	var asignarPuestoSector = document.getElementsByClassName('asignar-puesto-button');
	var asignarTramitePuesto = document.getElementsByClassName('asignar-tramite-button');
	var asignarDisplaySector = document.getElementsByClassName('asignar-display-button');
	var desasignarTramiteSector = document.getElementsByClassName('desasignar-sector-button');
	var desasignarPuestoSector = document.getElementsByClassName('desasignar-puesto-button');
	var desasignarTramitePuesto = document.getElementsByClassName('desasignar-tramite-button');
	var desasignarDisplaySector = document.getElementsByClassName('desasignar-display-button');
	var iconContainer = document.getElementsByClassName('icon-container');
	var asignarContainer = document.getElementsByClassName('asignar-container');
	var desasignarContainer = document.getElementsByClassName('desasignar-container');
	var detallesLinks = document.getElementsByClassName('details-link');

	for (var i = 0; i < detallesLinks.length; i++){
		var props = detallesLinks[i].parentElement.previousElementSibling;
		if (hasClass(detallesLinks[i], 'tramite-detail-link')) {
			detallesLinks[i].href = 'forms.xhtml?tipoForm=detallesTramite&nombre=' + props.getAttribute('nombre') + '&codigo=' + props.getAttribute('codigo');
		} else if (hasClass(detallesLinks[i], 'puesto-detail-link')) {
			detallesLinks[i].href = 'forms.xhtml?tipoForm=detallesPuesto&maquina=' + props.getAttribute('maquina') + '&usuario='
			+ props.getAttribute('usuario') + '&estado=' + props.getAttribute('estado') + '&numero=' + props.getAttribute('numero');
		} else if (hasClass(detallesLinks[i], 'sector-detail-link')) {
			detallesLinks[i].href = 'forms.xhtml?tipoForm=detallesSector&id=' + props.getAttribute('idSector') + '&nombre='
			+ props.getAttribute('nombre') + '&ruta=' + props.getAttribute('ruta');
		}
	}

		// ALTA TRAMITE
	if (getURLParameter('tipoForm') == 'altaTramite') {
		document.getElementById('codigo-tramite').classList.remove('hidden');
		document.getElementById('nombre-tramite').classList.remove('hidden');
		document.getElementById('form:tramite-selected-nombre').classList.add('in-form');
		document.getElementById('form:tramite-selected-codigo').classList.add('in-form');
		document.getElementById('form:alta-tramite-button').classList.remove('hidden');
		document.getElementById('form-links:title-admin').classList.remove('hidden');
		document.getElementById('form-links:title-tramites').classList.remove('hidden');
		document.getElementById('sub-title').innerHTML= 'Crear Tramite';
		document.getElementById('form:cancel-button-tramites').classList.remove("hidden");
		// MOD TRAMITE
	} else if (getURLParameter('tipoForm') == 'modTramite') {
		document.getElementById('nombre-tramite').classList.remove('hidden');
		document.getElementById('codigo-tramite').classList.remove('hidden');
		document.getElementById('form:tramite-selected-codigo').classList.add('in-form');
		document.getElementById('form:tramite-selected-nombre').classList.add('in-form');
		document.getElementById('form:tramite-selected-codigo').classList.add('read-only');
		document.getElementById('form:tramite-selected-codigo').readOnly = 'true';
		document.getElementById('form:mod-tramite-button').classList.remove('hidden');
		document.getElementById('form-links:title-admin').classList.remove('hidden');
		document.getElementById('form-links:title-tramites').classList.remove('hidden');
		document.getElementById('form:tramite-selected-codigo').value = getURLParameter('codigo').replace("+", " ");
		document.getElementById('form:tramite-selected-nombre').value = getURLParameter('nombre').replace("+", " ");
		document.getElementById('sub-title').innerHTML= 'Modificar Tramite';
		document.getElementById('form:cancel-button-tramites').classList.remove("hidden");
		// ALTA PUESTO
	} else if (getURLParameter('tipoForm') == 'altaPuesto') {
		document.getElementById('maquina-puesto').classList.remove('hidden');
		document.getElementById('numero-puesto').classList.remove('hidden');
		document.getElementById('form:puesto-selected-numero').classList.add('in-form');
		document.getElementById('form:puesto-selected-maquina').classList.add('in-form');
		document.getElementById('form:alta-puesto-button').classList.remove('hidden');
		document.getElementById('form-links:title-gestion').classList.remove('hidden');
		document.getElementById('form-links:title-puestos').classList.remove('hidden');
		document.getElementById('form:puesto-selected-numero').value = '';
		document.getElementById('form:puesto-selected-maquina').value = '';
		document.getElementById('id-sector').classList.remove('hidden');
		document.getElementById('form:sector-selected-id').classList.add('read-only');
		document.getElementById('form:sector-selected-id').readOnly = 'true';
		document.getElementById('form:sector-selected-id').value = getURLParameter('id').replace("+", " ");
		document.getElementById('id-label').innerHTML = 'Sector: ';
		document.getElementById('sub-title').innerHTML= 'Crear Puesto';
		document.getElementById('form:cancel-button-puestos').classList.remove("hidden");
		// MOD PUESTO
	} else if (getURLParameter('tipoForm') == 'modPuesto') {
		document.getElementById('form:puesto-selected-estado').value = getURLParameter('estado').replace("+", " ");
		document.getElementById('form:puesto-selected-usuario').value = getURLParameter('usuario').replace("+", " ");
		document.getElementById('form:puesto-selected-maquina').value = getURLParameter('maquina').replace("+", " ");
		var usr = document.getElementById('form:puesto-selected-usuario').value;
		document.getElementById('form:puesto-selected-numero').classList.add('in-form');
		document.getElementById('usuario-puesto').classList.remove('hidden');
		document.getElementById('estado-puesto').classList.remove('hidden');
		document.getElementById('numero-puesto').classList.remove('hidden');
		document.getElementById('maquina-puesto').classList.remove('hidden');
		if (usr != '-') {
			document.getElementById('form:puesto-selected-usuario').classList.remove('hidden');
		} else {
			document.getElementById('puesto-selected-usuario-dummy').classList.remove('hidden');
		}
		document.getElementById('form:puesto-selected-usuario').classList.add('read-only');
		document.getElementById('form:puesto-selected-maquina').classList.add('read-only');
		document.getElementById('form:puesto-selected-usuario').readOnly = 'true';
		document.getElementById('form:puesto-selected-maquina').readOnly = 'true';
		document.getElementById('form-links:title-gestion').classList.remove('hidden');
		document.getElementById('form-links:title-puestos').classList.remove('hidden');
		document.getElementById('form:mod-puesto-button').classList.remove('hidden');
		document.getElementById('sub-title').innerHTML= 'Modificar Puesto';
		document.getElementById('form:cancel-button-puestos').classList.remove("hidden");
		// ALTA DISPLAY
	} else if (getURLParameter('tipoForm') == 'altaDisplay') {
		document.getElementById('alta-display-fields').classList.remove('hidden');
		document.getElementById('form:display-selected-id').classList.add('in-form');
		document.getElementById('form:alta-display-button').classList.remove('hidden');
		document.getElementById('form-links:title-admin').classList.remove('hidden');
		document.getElementById('form-links:title-displays').classList.remove('hidden');
		document.getElementById('sub-title').innerHTML= 'Crear Display';
		document.getElementById('form:cancel-button-displays').classList.remove("hidden");
		// DETALLES TRAMITE
	} else if (getURLParameter('tipoForm') == 'detallesTramite') {
		document.getElementById('nombre-tramite').classList.remove('hidden');
		document.getElementById('codigo-tramite').classList.remove('hidden');
		document.getElementById('form:tramite-selected-codigo').classList.add('read-only');
		document.getElementById('form:tramite-selected-nombre').classList.add('read-only');
		document.getElementById('form:tramite-selected-codigo').readOnly = 'true';
		document.getElementById('form:tramite-selected-nombre').readOnly = 'true';
		document.getElementById('form-links:title-admin').classList.remove('hidden');
		document.getElementById('form-links:title-tramites').classList.remove('hidden');
		document.getElementById('form:tramite-selected-codigo').value = getURLParameter('codigo').replace("+", " ");
		document.getElementById('form:tramite-selected-nombre').value = getURLParameter('nombre').replace("+", " ");
		document.getElementById('cancel-button').classList.add('hidden');
		document.getElementById('sub-title').innerHTML= 'Detalles de Tramite';
		// DETALLES PUESTO
	} else if (getURLParameter('tipoForm') == 'detallesPuesto') {
		document.getElementById('form:puesto-selected-estado-forshow').value = getURLParameter('estado').replace("+", " ");
		document.getElementById('form:puesto-selected-usuario').value = getURLParameter('usuario').replace("+", " ");
		document.getElementById('form:puesto-selected-maquina').value = getURLParameter('maquina').replace("+", " ");
		document.getElementById('form:puesto-selected-numero').value = getURLParameter('numero').replace("+", " ");
		var usr = document.getElementById('form:puesto-selected-usuario').value;
		document.getElementById('usuario-puesto').classList.remove('hidden');
		document.getElementById('numero-puesto').classList.remove('hidden');
		document.getElementById('maquina-puesto').classList.remove('hidden');
		document.getElementById('estado-puesto').classList.remove('hidden');
		document.getElementById('form:puesto-selected-estado').classList.add('hidden');
		document.getElementById('form:puesto-selected-estado-forshow').classList.remove('hidden');
		if (usr != '-') {
			document.getElementById('form:puesto-selected-usuario').classList.remove('hidden');
		} else {
			document.getElementById('puesto-selected-usuario-dummy').classList.remove('hidden');
		}
		document.getElementById('form:puesto-selected-usuario').classList.add('read-only');
		document.getElementById('form:puesto-selected-maquina').classList.add('read-only');
		document.getElementById('form:puesto-selected-estado-forshow').classList.add('read-only');
		document.getElementById('form:puesto-selected-numero').classList.add('read-only');
		document.getElementById('form:puesto-selected-usuario').readOnly = 'true';
		document.getElementById('form:puesto-selected-maquina').readOnly = 'true';
		document.getElementById('form:puesto-selected-estado-forshow').readOnly = 'true';
		document.getElementById('form:puesto-selected-numero').readOnly = 'true';
		document.getElementById('form-links:title-gestion').classList.remove('hidden');
		document.getElementById('form-links:title-puestos').classList.remove('hidden');
		document.getElementById('cancel-button').classList.add('hidden');
		document.getElementById('sub-title').innerHTML= 'Detalles de Puesto';
		// DETALLES SECTOR
	} else if (getURLParameter('tipoForm') == 'detallesSector') {
		document.getElementById('id-sector').classList.remove('hidden');
		document.getElementById('nombre-sector').classList.remove('hidden');
		document.getElementById('ruta-sector').classList.remove('hidden');
		document.getElementById('form:sector-selected-id').classList.add('read-only');
		document.getElementById('form:sector-selected-nombre').classList.add('read-only');
		document.getElementById('form:sector-selected-ruta').classList.add('read-only');
		document.getElementById('form:sector-selected-id').readOnly = 'true';
		document.getElementById('form:sector-selected-nombre').readOnly = 'true';
		document.getElementById('form:sector-selected-ruta').readOnly = 'true';
		document.getElementById('form-links:title-gestion').classList.remove('hidden');
		document.getElementById('form-links:title-puestos').classList.remove('hidden');
		document.getElementById('form:sector-selected-id').value = getURLParameter('id').replace("+", " ");
		document.getElementById('form:sector-selected-nombre').value = getURLParameter('nombre').replace("+", " ");
		document.getElementById('form:sector-selected-ruta').value = getURLParameter('ruta').replace("+", " ");
		document.getElementById('cancel-button').classList.add('hidden');
		document.getElementById('sub-title').innerHTML= 'Detalles de Sector';
	}

	// ASIGNAR TRAMITE A SECTOR
	for (var i = 0; i < asignarTramiteSector.length; i++){
		asignarTramiteSector[i].addEventListener('click', function(){
			var esSector = hasClass(document.getElementById("entidad"), "page-sectores");
			if(esSector){
				var id = this.parentElement.parentElement.previousElementSibling.getAttribute('idSector');
				this.href = 'listaTramites.xhtml?esSec=true&esAsig=true&entidad=tramite&id=' + id;
			} else {
				var id = this.parentElement.parentElement.previousElementSibling.getAttribute('maquina');
				this.href = 'listaTramites.xhtml?esSec=false&esAsig=true&entidad=tramite&id=' + id;
			}
		}, false);
	}

	// DESASIGNAR TRAMITE A SECTOR
	for (var i = 0; i < desasignarTramiteSector.length; i++){
		desasignarTramiteSector[i].addEventListener('click', function(){
			var esSector = hasClass(document.getElementById("entidad"), "page-sectores");
			if(esSector){
				var id = this.parentElement.parentElement.previousElementSibling.getAttribute('idSector');
				this.href = 'listaTramites.xhtml?esSec=true&esAsig=false&entidad=tramite&id=' + id;
			} else {
				var id = this.parentElement.parentElement.previousElementSibling.getAttribute('maquina');
				this.href = 'listaTramites.xhtml?esSec=false&esAsig=false&entidad=tramite&id=' + id;
			}
		}, false);
	}

	// ASIGNAR PUESTO A SECTOR
	for (var i = 0; i < asignarPuestoSector.length; i++){
		asignarPuestoSector[i].addEventListener('click', function(){
				var esSector = hasClass(document.getElementById("entidad"), "page-sectores");
				if(esSector){
					var id = this.parentElement.parentElement.previousElementSibling.getAttribute('idSector');
					this.href = 'listaPuestos.xhtml?busqueda=false&esSec=true&esAsig=true&entidad=puesto&id=' + id;
				} 
				
			}, false);
		}

	// DESASIGNAR PUESTO A SECTOR
	for (var i = 0; i < desasignarPuestoSector.length; i++){
		desasignarPuestoSector[i].addEventListener('click', function(){
				var  esSector = hasClass(document.getElementById("entidad"), "page-sectores");
				if(esSector){
					var id = this.parentElement.parentElement.previousElementSibling.getAttribute('idSector');
					this.href = 'listaPuestos.xhtml?busqueda=false&esSec=true&esAsig=false&entidad=puesto&id=' + id;
				} 
			}, false);
		}

	// ASIGNAR DISPLAY A SECTOR
	for (var i = 0; i < asignarDisplaySector.length; i++){
		asignarDisplaySector[i].addEventListener('click', function(){
			var esSector = hasClass(document.getElementById("entidad"), "page-sectores");
			if(esSector){
				var id = this.parentElement.parentElement.previousElementSibling.getAttribute('idSector');
				this.href = 'listaDisplays.xhtml?esSec=true&esAsig=true&entidad=display&id=' + id;
			} 
		}, false);
	}

	// DESASIGNAR DISPLAY A SECTOR
	for (var i = 0; i < desasignarDisplaySector.length; i++){
		desasignarDisplaySector[i].addEventListener('click', function(){
			var esSector = hasClass(document.getElementById("entidad"), "page-sectores");
			if(esSector){
				var id = this.parentElement.parentElement.previousElementSibling.getAttribute('idSector');
				this.href = 'listaDisplays.xhtml?esSec=true&esAsig=false&entidad=display&id=' + id;
			} 
		}, false);
	}

	// ASIGNAR TRAMITE PUESTO
	for (var i = 0; i < asignarTramitePuesto.length; i++) {
		asignarTramitePuesto[i].addEventListener('click', function(){
			var esSector = hasClass(document.getElementById("entidad"), "page-sectores");
			if(esSector){
				var id = this.parentElement.previousSibling.previousSibling.getAttribute('idSector');
				this.href = 'listaTramites.xhtml?esSec=true&esAsig=true&entidad=tramite&id=' + id;
			} else {
				var id = this.parentElement.previousSibling.previousSibling.getAttribute('maquina');
				this.href = 'listaTramitesDePuesto.xhtml?esSec=false&esAsig=true&entidad=tramite&id=' + id;
			}
		}, false);
	}	

	// DESASIGNAR TRAMITE PUESTO
	for (var i = 0; i < desasignarTramitePuesto.length; i++) {
		desasignarTramitePuesto[i].addEventListener('click', function(){
			var esSector = hasClass(document.getElementById("entidad"), "page-sectores");
			if(esSector){
				var id = this.parentElement.previousSibling.previousSibling.getAttribute('idSector');
				this.href = 'listaTramites.xhtml?esSec=true&esAsig=false&id=' + id;
			} else {
				var id = this.parentElement.previousSibling.previousSibling.getAttribute('maquina');
				this.href = 'listaTramitesDePuesto.xhtml?esSec=false&esAsig=false&entidad=tramite&id=' + id;
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

	//SHOW DESASIGNAR BOX
	for (var i = 0; i < iconContainer.length; i++) {
		iconContainer[i].addEventListener('click', function(e){
			for (var i = 0; i < desasignarContainer.length; i++) {
				desasignarContainer[i].classList.add('hidden');
				desasignarContainer[i].classList.remove('icon-container-selected');
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

	
})

