document.addEventListener("DOMContentLoaded", () => {

    const input =
        document.querySelector('input[name="q"]') ||
        document.getElementById('busca');

    const sugestoesDiv = document.getElementById("sugestoes");

    if (!input || !sugestoesDiv) {
        console.warn("Busca AJAX não inicializada.");
        return;
    }

    function removerAcentos(str) {
        return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
    }

    let termoAtual = "";

    input.addEventListener("input", async () => {

        termoAtual = input.value.trim().toLowerCase();

        if (!termoAtual) {
            sugestoesDiv.innerHTML = "";
            return;
        }

        try {
            const idiomaSelect = document.getElementById("idioma");
            const idioma = idiomaSelect ? idiomaSelect.value : "de";

            const res = await fetch(
                `/api/dicionario/sugerir?termo=${encodeURIComponent(termoAtual)}&idioma=${encodeURIComponent(idioma)}`
            );

            let dados = await res.json();

            // filtro ignorando acentos
            dados = dados.filter(p =>
                removerAcentos(p.toLowerCase())
                    .startsWith(removerAcentos(termoAtual))
            );

            sugestoesDiv.innerHTML = dados
                .map(p => `<div class="sugestao">${p}</div>`)
                .join("");

            document.querySelectorAll(".sugestao").forEach(el => {

                el.addEventListener("mouseenter", () => {
                    input.value = el.textContent;
                });

                el.addEventListener("mouseleave", () => {
                    input.value = termoAtual;
                });

                el.addEventListener("click", () => {
                    input.value = el.textContent;
                    termoAtual = el.textContent;
                    sugestoesDiv.innerHTML = "";
                });

            });

        } catch (err) {
            console.error("Erro ao buscar sugestões:", err);
        }
    });
});
document.addEventListener("click", (event) => {

    const input =
        document.querySelector('input[name="q"]') ||
        document.getElementById("busca");

    const sugestoesDiv = document.getElementById("sugestoes");

    if (!input || !sugestoesDiv) return;

    const clicouNoInput = input.contains(event.target);
    const clicouNasSugestoes = sugestoesDiv.contains(event.target);

    // se clicou fora
    if (!clicouNoInput && !clicouNasSugestoes) {
        sugestoesDiv.innerHTML = "";
    }
});