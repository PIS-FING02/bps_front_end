document.addEventListener("DOMContentLoaded", function() { 
	
	//Esto es para esconder el Notice
	var divNotice = document.getElementById("notice-holder");
	//Luego de 5 segundos lo escondo
	setInterval(function(){
		if(!!divNotice){
			divNotice.style.display = "none";
		} 
	}, 5000);
	
});