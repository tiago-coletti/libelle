const input = document.querySelector('input[name="q"]') || document.getElementById('busca');
    const sugestoesDiv = document.getElementById("sugestoes");

        // Função que faz a requisição AJAX e mostra sugestões
        if (!input) {
            console.warn('Campo de busca não encontrado (esperado: input[name="q"] ou id="busca").');
        } else {
        input.addEventListener("input", async () => {
            const termo = input.value.trim();

            // Se o campo estiver vazio, limpa sugestões
            if (!termo) {
                sugestoesDiv.innerHTML = "";
                return;
            }

            try {
                // determina idioma selecionado
                const idiomaSelect = document.getElementById('idioma');
                const idioma = idiomaSelect ? idiomaSelect.value : 'de';
                // AJAX para buscar sugestões no Spring Boot
                console.debug('Buscando sugestões — termo:', termo, 'idioma:', idioma);
                const res = await fetch(`/api/dicionario/sugerir?termo=${encodeURIComponent(termo)}&idioma=${encodeURIComponent(idioma)}`);
                const dados = await res.json();
                console.debug('Sugestões recebidas:', dados);

                // Monta a lista de sugestões
                sugestoesDiv.innerHTML = dados
                    .map(p => `<div class="sugestao">${p}</div>`)
                    .join("");

                // Permite clicar na sugestão para preencher o input
                document.querySelectorAll(".sugestao").forEach(el => {
                    el.addEventListener("click", () => {
                        input.value = el.textContent;
                        sugestoesDiv.innerHTML = "";
                    });
                });

            } catch (err) {
                console.error("Erro ao buscar sugestões:", err);
            }
        });
        }