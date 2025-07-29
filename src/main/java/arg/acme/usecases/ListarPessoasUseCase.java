package arg.acme.usecases;

import arg.acme.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ListarPessoasUseCase {

    public List<Pessoa> listarPessoas() {
        return Pessoa.listAll();
    }

    public Pessoa listarPessoaPorId(Long id) {
        return Pessoa.findById(id);
    }
}
