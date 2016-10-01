var cancelButton = document.getElementById("popup-cancel-button");
var closeButton = document.getElementById("popup-close-button");
var confirmButton = document.getElementById("open-popup-button");
var popup = document.getElementById("nuevo-numero-popup");
var optionButtons = document.getElementsByClassName("option-button");

cancelButton.addEventListener('click', function(){
	popup.classList.add("hidden");
}, false);

closeButton.addEventListener('click', function(){
	popup.classList.add("hidden");
}, false);

confirmButton.addEventListener('click', function(){ 
	if (!confirmButton.classList.contains('deactivated')) {
		popup.classList.remove("hidden");
	}
}, false);

for (var i = 0; i < optionButtons.length; i++) {
	optionButtons[i].addEventListener('click', function(){
		confirmButton.classList.remove('deactivated');
    }, false);
}