window.onload = initPage;

function initPage() {
    nickname = document.getElementById("username");
    nickname.onblur = checkUsername;
}


function checkUsername() {
    alert('Sendin request to the server');
}

function showUsernameStatus() {
    
}
