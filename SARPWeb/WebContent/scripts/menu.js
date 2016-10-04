var operadorButton = document.getElementById("operador-button");
var operadorSrButton = document.getElementById("operador-sr-button");
var respSectorButton = document.getElementById("respsec-button");
var adminButton = document.getElementById("admin-button");
var recepcionButton = document.getElementById("recepcion-button");
var consultasButton = document.getElementById("consultor-button");
var role = document.getElementById("user-rol");

function enableRol(rol, button) {
	if (role.classList.contains(rol)) {
		button.classList.remove('hidden');
	}
}

enableRol("ADMIN", adminButton);
enableRol("RESPSEC", respSectorButton);
enableRol("OPERADOR", operadorButton);
enableRol("OPERADORSR", operadorSrButton);
enableRol("RECEPCION", recepcionButton);
enableRol("CONSULTOR", consultasButton);
