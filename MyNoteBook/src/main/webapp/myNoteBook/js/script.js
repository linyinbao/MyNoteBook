function add(addnew) {
    addnew.className = "add-new add-new-motion";
    setTimeout(hidePlusImg, 500);
    setTimeout(overflow, 1000);
    setTimeout(signupDisplay, 1300);
    setTimeout(loginFormForbidden, 2000);
}

function hidePlusImg() {
    document.getElementById("plus-img")
        .className = "plus-img plus-img-hide";
}

function overflow() {
    document.getElementById("login-card")
        .className = "login-card login-card-signup";
}

function signupDisplay() {
    document.getElementById("add-form")
        .className = "add-form add-form-fadein";
    document.getElementById("nameform")
        .className = "input nameform-leftin";
    document.getElementById("passwordform")
        .className = "input passwordform-leftin";
    document.getElementById("confirmform")
        .className = "input confirmform-leftin";
    document.getElementById("back-to-login")
        .className = "back-to-login back-to-login-motion";
}

function loginFormForbidden() {
    document.getElementById("login-form")
        .style.display = "none";
}

function shake(submithtm) {
    submithtm.className += " shake";
    setTimeout(shakereset, 800);
}

function shakereset() {
    document.getElementById("login-submit")
        .className = "login-submit";
    document.getElementById("add-new-submit")
        .className = "add-new-submit";
}

function goback() {
    document.getElementById("login-form")
        .style.display = "";
    document.getElementById("add-new")
        .className = "add-new add-new-cancel";
    document.getElementById("login-card")
        .style.background = "#fff";
    document.getElementById("login-card")
        .style.transition = "0.3s all";
    document.getElementById("add-form")
        .className = "add-form add-form-fadeout";
    setTimeout(resetLoginCard, 500);
}

function resetLoginCard() {
    document.getElementById("login-card")
        .className = "login-card";
    document.getElementById("login-card")
        .style.background = "";
    document.getElementById("login-card")
        .style.transition = "";
    document.getElementById("add-form")
        .className = "add-form";
    document.getElementById("back-to-login")
        .className = "back-to-login";
    document.getElementById("plus-img")
        .className = "plus-img";
}