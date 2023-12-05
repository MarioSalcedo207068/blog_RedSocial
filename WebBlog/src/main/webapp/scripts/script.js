const slidePage = document.querySelector(".slidepage");
const firstNextBtn = document.querySelector(".nextBtn");
const prevBtnSec = document.querySelector(".prev-1");
const nextBtnFirst = document.querySelector(".next-1");
const prevBtnThird = document.querySelector(".prev-2");
const nextBtnSec = document.querySelector(".next-2");
const prevBtnFourth = document.querySelector(".prev-3");
const nextBtnThird = document.querySelector(".next-3");
const prevBtnFifth = document.querySelector(".prev-4");
const nextBtnFourth = document.querySelector(".next-4");
const submitBtn = document.querySelector(".submit");




nextBtnFourth.addEventListener("click", function () {
    slidePage.style.marginLeft = "-100%";
});

prevBtnSec.addEventListener("click", function () {
    slidePage.style.marginLeft = "0%";
});
prevBtnThird.addEventListener("click", function () {
    slidePage.style.marginLeft = "-25%";
});
prevBtnFourth.addEventListener("click", function () {
    slidePage.style.marginLeft = "-50%";
});
prevBtnFifth.addEventListener("click", function () {
    slidePage.style.marginLeft = "-75%";
});
submitBtn.addEventListener("click", function () {
    var paginaLogin = "paginas/Login.jsp";
    setTimeout(function () {
        alert("Se ha registrado Exitosamente");
        window.location.href = paginaLogin;
    }, 800);
});

function validarNombre() {
    var nombreInput1 = document.getElementById('nombre');
    var nombreInput2 = document.getElementById('apellidoP');
    var nombreInput3 = document.getElementById('apellidoM');
    var nombre = nombreInput1.value;
    var apellidoP = nombreInput2.value;
    var apellidoM = nombreInput3.value;
    var patronLetras = /^[A-Za-z]+$/;
    if (patronLetras.test(nombre) && patronLetras.test(apellidoP) && patronLetras.test(apellidoM)) {
        firstNextBtn.addEventListener("click", function () {
            slidePage.style.marginLeft = "-25%";
        });
    } else {
        alert('Ingresa solo letras en los campos');
    }
}

function validarCorreo() {
    var correo = document.getElementById('email').value;
    var patronCorreo = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (patronCorreo.test(correo)) {
        return true
    } else {
       alert('El formato del correo electrónico es incorrecto.');
       return false
    }
}

function validarTelefono() {
    var telefonoInput = document.getElementById('telefono');
    var telefono = telefonoInput.value;
    var patronTelefono = /^\d{10}$/;
    if (patronTelefono.test(telefono)) {
        if(validarCorreo()){
            nextBtnSec.addEventListener("click", function () {
                slidePage.style.marginLeft = "-50%";
            });
        }
    } else {
        alert('Ingresa un número telefónico válido de 10 dígitos.');
    }
}

function validarLocalidad(){
    var Input1 = document.getElementById('estado');
    var Input2 = document.getElementById('ciudad');
    var Input3 = document.getElementById('municipio');
    var estado = Input1.value;
    var ciudad = Input2.value;
    var municipio = Input3.value;
    var patronLetras = /^[A-Za-z]+$/;
    if (patronLetras.test(estado) && patronLetras.test(ciudad) && patronLetras.test(municipio)) {
        nextBtnThird.addEventListener("click", function () {
            slidePage.style.marginLeft = "-75%";
        });
    } else {
        alert('Ingresa solo letras en los campos');
    }
}