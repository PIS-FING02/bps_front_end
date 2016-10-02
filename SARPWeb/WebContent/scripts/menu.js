var operadorButton = document.getElementById("operador-button");
var operadorSrButton = document.getElementById("operador-sr-button");
var respSectorButton = document.getElementById("respsec-button");
var adminButton = document.getElementById("admin-button");
var recepcionButton = document.getElementById("recepcion-button");
var consultasButton = document.getElementById("consultor-button");
var rol = loginBean.getRole();

function roleButtons(role){
	if (role ="operador")
		operadorButton.classList.remove("hidden");
	else if (role = "respsec")
		respSectorButton.classList.remove("hidden");
	else if (role = "operadorsr")
		operadorSrButton.classList.remove("hidden");
	else if (role = "admin")
		adminButton.classList.remove("hidden");
	else if (role = "recepcion")
		recepcionButton.classList.remove("hidden");
	else if (role = "consultor")
		consultasButton.classList.remove("hidden");
}
