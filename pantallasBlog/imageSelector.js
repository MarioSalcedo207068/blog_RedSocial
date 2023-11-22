const image=document.querySelector("img"),
input = document.querySelector("input");

input.addEvenListener("change", () => {
image.src = URL.createObjectURL(input.files[0]);
});