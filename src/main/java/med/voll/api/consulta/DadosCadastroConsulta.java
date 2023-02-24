package med.voll.api.consulta;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record DadosCadastroConsulta(

        @NotNull(message = "Paciente não pode ser nulo!")
        Long paciente_id,

        Long medico_id,

        @NotNull
        LocalDate data,

        @NotNull
        LocalTime hora

) {
}
