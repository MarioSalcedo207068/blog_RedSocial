const slidePage = document.querySelector(".slidepage");
const firstNextBtn = document.querySelector(".nextBtn");
const prevBtnSec = document.querySelector(".prev-1");
const nextBtnSec = document.querySelector(".next-1");
const prevBtnThird = document.querySelector(".prev-2");
const nextBtnThird = document.querySelector(".next-2");
const prevBtnFourth = document.querySelector(".prev-3");
const nextBtnFourth = document.querySelector(".next-3");
const prevBtnFifth = document.querySelector(".prev-4");
const submitBtn = document.querySelector(".submit");

firstNextBtn.addEventListener("click", function () {
    slidePage.style.marginLeft = "-25%";
});
nextBtnSec.addEventListener("click", function () {
    slidePage.style.marginLeft = "-50%";
});
nextBtnThird.addEventListener("click", function () {
    slidePage.style.marginLeft = "-75%";
});
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