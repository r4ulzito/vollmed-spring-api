CREATE TABLE consultas (

    id bigint not null auto_increment,
    paciente_id bigint not null,
    medico_id bigint not null,
    data_consulta DATE,
    hora_consulta TIME,

    primary key(id),
    foreign key (paciente_id) references pacientes(id),
    foreign key (medico_id) references medicos(id)

);