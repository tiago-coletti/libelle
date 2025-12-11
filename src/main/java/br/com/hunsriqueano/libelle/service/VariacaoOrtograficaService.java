package br.com.hunsriqueano.libelle.service;

import br.com.hunsriqueano.libelle.entity.VariacaoOrtografica;
import br.com.hunsriqueano.libelle.repository.VariacaoOrtograficaRepository;
import org.apache.commons.codec.language.ColognePhonetic;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariacaoOrtograficaService {

    private final VariacaoOrtograficaRepository repository;
    private final ColognePhonetic algoritmoFonetico;

    public VariacaoOrtograficaService(VariacaoOrtograficaRepository repository, ColognePhonetic algoritmoFonetico) {
        this.repository = repository;
        this.algoritmoFonetico = algoritmoFonetico;
    }

    public List<VariacaoOrtografica> buscarPorSimilaridade(String termo) {
        if (termo == null || termo.trim().isEmpty()) {
            return List.of();
        }
        String codigoDoTermo = algoritmoFonetico.encode(termo);
        return repository.findByCodigoFonetico(codigoDoTermo);
    }

    public List<VariacaoOrtografica> listarTodos() {
        return repository.findAll();
    }

    public Optional<VariacaoOrtografica> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public VariacaoOrtografica salvar(VariacaoOrtografica variacao) {
        if (variacao.getTexto() != null && !variacao.getTexto().isEmpty()) {
            String codigo = algoritmoFonetico.encode(variacao.getTexto());
            variacao.setCodigoFonetico(codigo);
        }
        return repository.save(variacao);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}