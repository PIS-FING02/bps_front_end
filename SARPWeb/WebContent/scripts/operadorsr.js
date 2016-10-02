var abrirPuestoButton = document.getElementById("abrir-puesto-button");
var cerrarPuestoButton = document.getElementById("cerrar-puesto-button");
var verPausadosButton = document.getElementById("ver-pausados-button");
var verAtrasadosButton = document.getElementById("ver-atrasados-button");
var llamarSiguienteButton = document.getElementById("llamar-siguiente-button");
var llamarADemandaButton = document.getElementById("llamar-a-demanda-button");

abrirPuestoButton.addEventListener('click', function(){
	abrirPuestoButton.classList.add("hidden");
	cerrarPuestoButton.classList.remove("hidden");
	llamarSiguienteButton.classList.remove('deactivated');
	verPausadosButton.classList.remove('secondary-deactivated');
	verAtrasadosButton.classList.remove('deactivated');
	llamarADemandaButton.classList.remove('deactivated');
}, false);

cerrarPuestoButton.addEventListener('click', function(){
	abrirPuestoButton.classList.remove("hidden");
	cerrarPuestoButton.classList.add("hidden");
	llamarSiguienteButton.classList.add('deactivated');
	verPausadosButton.classList.add('secondary-deactivated');
	verAtrasadosButton.classList.add('deactivated');
	llamarADemandaButton.classList.add('deactivated');
}, false);

