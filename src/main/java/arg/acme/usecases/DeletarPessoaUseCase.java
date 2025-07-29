package arg.acme.usecases;

import arg.acme.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.UUID;

@ApplicationScoped
public class DeletarPessoaUseCase {

    @Transactional
    public void deletarPessoa(Long id) {
        Pessoa.deleteById(id);
    }
}
