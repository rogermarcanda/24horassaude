package br.com.zarpsystem.projeto24horassaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zarpsystem.projeto24horassaude.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
