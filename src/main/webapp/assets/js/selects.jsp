function seleccionado(valueToSelect, id){
 	let element = document.getElementById(id);
    element.value = valueToSelect;
}

function verificarDesc(tipo) {
	   let campo = document.getElementById('descuento');
	   if (tipo == 'Porcentual'){
	   if( parseFloat(campo.value) > 100) { 
	          campo.value= 100;
	     }
	   }
}

function esconder(tipo) {
		let select = document.getElementById('combo');
		let campo = document.getElementById('descuento');
		let seleccion = document.getElementById('atraccion3');
		if (tipo == 'AXB') {
			select.style.display = "block";
			campo.style.display = "none";
			campo.removeAttribute("required");
			seleccion.setAttribute("required", "true");
		} else {
			campo.style.display = "block";
			select.style.display = "none";
			seleccion.removeAttribute("required");
			campo.setAttribute("required", "true");
		}
		if (tipo == "") {
			campo.style.display = "none";
			select.style.display = "none";
			campo.removeAttribute("required");
			seleccion.removeAttribute("required");
		}
	}
	
function mostrar(tipo) {
	let select = document.getElementById('combo');
	let campo = document.getElementById('descuento');
	let seleccion = document.getElementById('atraccion3');
		if (tipo == 'AXB') {
			select.style.display = "block";
			campo.style.display = "none";
			campo.removeAttribute("required");
			seleccion.setAttribute("required", "true");
		} else {
			campo.style.display = "block";
			select.style.display = "none";
			seleccion.removeAttribute("required");
			campo.setAttribute("required", "true");
		}
		if (tipo == "") {
			campo.style.display = "none";
			select.style.display = "none";
			campo.removeAttribute("required");
			seleccion.removeAttribute("required");
		}
}