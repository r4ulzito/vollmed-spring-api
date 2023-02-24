package med.voll.api.validators;

import med.voll.api.consulta.DadosCadastroConsulta;
import med.voll.api.exceptions.clinicClosedException.ClinicClosedException;

import java.time.LocalTime;
import java.util.Objects;

public class ClinicOpenValidator implements Validator {

    private LocalTime openHour = LocalTime.parse("07:00:00");
    private LocalTime closeHour = LocalTime.parse("19:00:00");

    public void validate(DadosCadastroConsulta dados) {

        if (dados.hora().isBefore(this.openHour) ||
                dados.hora().isAfter(this.closeHour) ||
                Objects.equals(dados.data().getDayOfWeek().toString(), "SUNDAY")) {

            throw new ClinicClosedException("Horário da consulta inválido!");

        }

    }

}
