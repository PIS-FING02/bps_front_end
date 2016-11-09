document.addEventListener("DOMContentLoaded", function() { 
	var prioridad = document.getElementById("prioridad").innerHTML;

	if(prioridad == "1"){
		document.getElementById("info-sae-hora").classList.remove('hidden');
		document.getElementById("info-sae-fecha").classList.remove('hidden');
	}else{
		document.getElementById("info-sae-hora").classList.add('hidden');
		document.getElementById("info-sae-fecha").classList.add('hidden');
	}
	
	var desviarButton = document.getElementsByClassName('desviar-button');
	var cerrarModal = document.getElementsByClassName('cerrar-modal');
	
	if(!!desviarButton){
		desviarButton[0].addEventListener('click', function(){

			var modal =  document.getElementById('modal');
			if(!!modal){
				document.getElementById("modal").className = "";
				document.getElementById("modal").className = "modal";
			}
				
		});
	}
	
	if(!!cerrarModal){
		
		cerrarModal[0].addEventListener('click', function(){
			
			var modal =  document.getElementById('modal');
			if(!!modal){
				
				document.getElementById("modal").className = "";
				document.getElementById("modal").className = "modal hidden";
			}
			
		});
	}
	
});
