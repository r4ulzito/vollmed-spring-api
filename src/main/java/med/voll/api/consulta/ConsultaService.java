package med.voll.api.consulta;

import med.voll.api.validators.ClinicOpenValidator;
import med.voll.api.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;
    private List<Validator> validators;

    public Consulta cadastrarConsulta(DadosCadastroConsulta dados) {

        this.validators = new ArrayList<>();
        this.validators.add(new ClinicOpenValidator());
        this.validators.forEach(validator -> validator.validate(dados));

        return this.repository.save(new Consulta(dados));

    }

}
