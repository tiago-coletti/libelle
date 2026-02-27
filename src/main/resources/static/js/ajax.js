const input = document.querySelector('input[name="q"]') || document.getElementById('busca');
const sugestoesDiv = document.getElementById("sugestoes");

function removerAcentos(str) {
    return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "");
}

if (!input) {
    console.warn('Campo de busca não encontrado.');
} else {
    let termoAtual = '';

    input.addEventListener("input", async () => {
        termoAtual = input.value.trim().toLowerCase();
        if (!termoAtual) {
            sugestoesDiv.innerHTML = "";
            return;
        }

        try {
            const idiomaSelect = document.getElementById('idioma');
            const idioma = idiomaSelect ? idiomaSelect.value : 'de';
            const res = await fetch(`/api/dicionario/sugerir?termo=${encodeURIComponent(termoAtual)}&idioma=${encodeURIComponent(idioma)}`);
            let dados = await res.json();

            // filtra palavras que começam com o termo, ignorando acentos
            dados = dados.filter(p => 
                removerAcentos(p.toLowerCase()).startsWith(removerAcentos(termoAtual))
            );

            sugestoesDiv.innerHTML = dados
                .map(p => `<div class="sugestao">${p}</div>`)
                .join("");

            document.querySelectorAll(".sugestao").forEach(el => {
                el.addEventListener("mouseenter", () => { input.value = el.textContent; });
                el.addEventListener("mouseleave", () => { input.value = termoAtual; });
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
}