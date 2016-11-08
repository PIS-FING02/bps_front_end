document.addEventListener("DOMContentLoaded", function() { 
	
	var operadorButton = document.getElementById("form:operador-button");
	var operadorSrButton = document.getElementById("form:operador-sr-button");
	var respSectorButton = document.getElementById("form:respsec-button");
	var adminButton = document.getElementById("form:admin-button");
	var recepcionButton = document.getElementById("form:recepcion-button");
	var consultasButton = document.getElementById("form:consultor-button");
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
	
});
