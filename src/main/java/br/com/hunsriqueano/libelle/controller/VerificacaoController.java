    package br.com.hunsriqueano.libelle.controller;

    import java.util.HashMap;
    import java.util.Map;
    import java.util.Optional;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.ResponseBody;

    import br.com.hunsriqueano.libelle.entity.Usuario;
    import br.com.hunsriqueano.libelle.repository.UsuarioRepository;

    @Controller
    public class VerificacaoController {

        @Autowired
        private UsuarioRepository usuarioRepository;

        // abre a página
        @GetMapping("/verificar_email")
        public String verificarEmail() {
            return "verificar_email";
        }

       @PostMapping("/verificar-codigo")
        @ResponseBody
        public Map<String, Object> verificarCodigo(@RequestBody Map<String, String> dados) {

            String codigo = dados.get("codigo");

            Map<String, Object> resposta = new HashMap<>();

            Optional<Usuario> usuarioOpt = usuarioRepository.findByCodigoVerificacao(codigo);

            if (usuarioOpt.isEmpty()) {
                resposta.put("ok", false);
                resposta.put("erro", "Código inválido");
                return resposta;
            }

            Usuario usuario = usuarioOpt.get();

            usuario.setEmailVerificado(true);

            usuario.setCodigoVerificacao(null);

            usuarioRepository.save(usuario);

            resposta.put("ok", true);
            return resposta;
        }
    }