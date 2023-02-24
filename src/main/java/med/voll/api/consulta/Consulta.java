package med.voll.api.consulta;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long paciente_id;
    private Long medico_id;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_consulta")
    private LocalDate data;

    @Temporal(TemporalType.TIME)
    @Column(name = "hora_consulta")
    private LocalTime hora;

    public Consulta(DadosCadastroConsulta dados) {

        this.paciente_id = dados.paciente_id();
        this.medico_id = dados.medico_id();
        this.data = LocalDate.parse(dados.data().toString());
        this.hora = LocalTime.parse(dados.hora().toString());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Consulta consulta = (Consulta) o;
        return id != null && Objects.equals(id, consulta.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
