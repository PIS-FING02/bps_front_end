var optionButtons = document.getElementsByClassName("option-button");
for (var i = 0; i < optionButtons.length; i++) {
	optionButtons[i].addEventListener('click', function(){
		for (var i = 0; i < optionButtons.length; i++) {
			optionButtons[i].classList.remove("option-button-selected");
		}
		this.classList.add("option-button-selected");
    }, false);
}

function hasClass(elem, klass ) {
    return (" " + elem.className + " " ).indexOf( " "+klass+" " ) > -1;
}