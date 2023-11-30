document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("formularioPublicacion").addEventListener("submit", function (event) {
        event.preventDefault();
        enviarPublicacion();
    });
});

//function enviarPublicacion() {
//    console.log("Enviando publicación...");
//    var publicacion = document.getElementById("formularioPublicacion").querySelector("input[name='publicacion']").value;
//
//    var xhttp = new XMLHttpRequest();
//    xhttp.open("POST", "../SvPublicacion", true);
//    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//    xhttp.onreadystatechange = function () {
//        if (this.readyState == 4 && this.status == 200) {
//            console.log("Respuesta del servidor:", this.responseText);
//            document.getElementById("resultadoPublicacion").innerHTML = this.responseText;
//        }
//    };
//    xhttp.send("publicacion=" + encodeURIComponent(publicacion));
//}

function enviarPublicacion() {
    console.log("Enviando publicación...");
    var publicacionInput = document.getElementById("formularioPublicacion").querySelector("input[name='publicacion']");
    var publicacion = publicacionInput.value;

    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", "../SvPublicacion", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log("Respuesta del servidor:", this.responseText);
            document.getElementById("resultadoPublicacion").innerHTML = this.responseText;

            // Restaurar el valor del campo al marcador de posición original
            publicacionInput.value = "";
            publicacionInput.defaultValue = publicacionInput.placeholder;
        }
    };
    xhttp.send("publicacion=" + encodeURIComponent(publicacion));
}
