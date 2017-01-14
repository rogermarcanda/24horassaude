package br.com.zarpsystem.projeto24horassaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zarpsystem.projeto24horassaude.entity.PacientePatologia;

public interface PacientePatologiaRepository extends JpaRepository<PacientePatologia, Long> {

}
