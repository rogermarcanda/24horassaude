package br.com.zarpsystem.projeto24horassaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zarpsystem.projeto24horassaude.entity.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {

}
