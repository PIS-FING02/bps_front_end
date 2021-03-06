document.addEventListener("DOMContentLoaded", function() { 
	
	var countEstados= document.getElementsByClassName('asignar-container')[0].querySelectorAll('a').length;
	var sectores = document.getElementsByClassName('asignar-container');
	var asignarContainer = document.getElementsByClassName('asignar-container');
	var iconContainer = document.getElementsByClassName('icon-container');
	var json_estado_tramites="[";
	var inputtext = document.getElementById('form-finalizar:json_estado_tramites');


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

	//CLICK OUTSIDE ASIGNAR BOX
	document.onclick = function(e) {
	    if(e.target != document.getElementById('asignar-container')) {
	    	var elem = document.getElementsByClassName('icon-container-selected')[0];
	    	if (elem)
	    		elem.classList.add('hidden');          
	    } 
	}


	for (var i = 0; i < sectores.length; i++){
		var a_classes = sectores[i].querySelectorAll('a')
		for (var j = 0; j < countEstados; j++){
			a_classes[j].addEventListener('click', function(){
					document.getElementById("form-finalizar:finalizar").classList.remove('deactivated');
					var  estado = this.getAttribute('id');
					var id_tramite = this.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.innerHTML;
					json_estado_tramites = json_estado_tramites + '{ "codigo":"'+id_tramite+'" , "resultadoAtencion":"' + estado +'" },';
					console.log(json_estado_tramites);
					inputtext.value = json_estado_tramites;
					this.parentElement.previousElementSibling.innerHTML = estado;
					var original = this.parentElement.previousElementSibling;
				    var clone = original.cloneNode(true);
				    clone.classList.add('tramite-finalizar-oprimido');
				    original.parentNode.replaceChild(clone, original);			
			}, false);
		}
	}

	
})

