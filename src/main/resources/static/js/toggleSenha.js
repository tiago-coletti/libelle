function toggleSenha(button) {
    const input = document.getElementById("password");

    if (!input) return;

    if (input.type === "password") {
        input.type = "text";
        button.textContent = "👁";
    } else {
        input.type = "password";
        button.textContent = "👁";
    }
}