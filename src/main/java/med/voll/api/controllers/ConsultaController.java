package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.consulta.Consulta;
import med.voll.api.consulta.ConsultaService;
import med.voll.api.consulta.DadosCadastroConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping
    @Transactional
    public ResponseEntity<Consulta> cadastra(@RequestBody @Valid DadosCadastroConsulta dados) {

        return new ResponseEntity<>(service.cadastrarConsulta(dados), HttpStatus.CREATED);

    }

}
