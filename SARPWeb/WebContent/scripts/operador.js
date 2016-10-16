var prioridad = document.getElementById("prioridad");

if(prioridad=1){
	document.getElementById("info-sae-hora").classList.remove('hidden');
	document.getElementById("info-sae-fecha").classList.remove('hidden');
}else{
	document.getElementById("info-sae-hora").classList.add('hidden');
	document.getElementById("info-sae-fecha").classList.remove('hidden');
}