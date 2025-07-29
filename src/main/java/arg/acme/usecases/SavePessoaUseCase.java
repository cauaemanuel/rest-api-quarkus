package arg.acme.usecases;

import arg.acme.controller.dto.CreatePessoaDto;
import arg.acme.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ApplicationScoped
public class SavePessoaUseCase {

    @Transactional
    public void execute(CreatePessoaDto createPessoaDto) {
        Pessoa pessoa = new Pessoa(createPessoaDto.nome(),
                                    createPessoaDto.email(),
                                    LocalDateTime.now());
        Pessoa.persist(pessoa);
    }
}
