let heading = document.getElementById("myHeading");

heading.addEventListener("mouseenter", function() {
    heading.style.backgroundColor = "yellow";
});

heading.addEventListener("mouseleave", function() {
    heading.style.backgroundColor = "transparent";
});