package med.voll.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(

        @NotBlank
        String nome,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String telefone,

        @Size(min = 11, max = 11)
        String cpf,

        @NotNull
        @Valid
        DadosEndereco endereco

) {
}
