let allowedKeys = {
    13: 'enter',
    37: 'left',
    38: 'up',
    39: 'right',
    40: 'down',
    65: 'a',
    66: 'b',
};

let konamiCode = ['up', 'up', 'down', 'down', 'left', 'right', 'left', 'right', 'b', 'a', 'enter'];

let codePosition = 0;

document.addEventListener('keyup', function(e) {
    let key = allowedKeys[e.keyCode];
    let requiredKey = konamiCode[codePosition];
    if (key === requiredKey) {
        codePosition++;
        if (codePosition === konamiCode.length) {
            addLives();
            codePosition = 0;
        }
    } else {
        codePosition = 0;
    }
});

function addLives() {
    document.body.style.backgroundImage = "url('img/victoryGus')";
    let audio = new Audio('img/ff-victory.mp3');
    audio.play();
    setTimeout(function(){alert("You have added 30 lives!");}, 100);
}