document.getElementById('idioma').addEventListener('change', function() {
    const idioma = this.value;
    let texto = '';

    if(idioma === 'pt') {
        texto = 'Você escolheu Português';
        console.log(texto);
    } else if(idioma === 'de') {
        texto = 'Você escolheu Alemão';
        console.log(texto);
    }

    document.getElementById('resultado').innerText = texto;
});