package br.com.zarpsystem.projeto24horassaude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zarpsystem.projeto24horassaude.entity.PacienteVacina;
import br.com.zarpsystem.projeto24horassaude.repository.PacienteVacinaRepository;

@RestController
public class PacienteVacinaController {

	@Autowired
	private PacienteVacinaRepository pacienteVacinaRepository;

	@RequestMapping(value = "/paciente-vacinas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar() {
		List<PacienteVacina> pacienteVacinaList = pacienteVacinaRepository.findAll();

		ResponseEntity<List<PacienteVacina>> response = new ResponseEntity<>(pacienteVacinaList, HttpStatus.OK);
		return response;	
	}

	@RequestMapping(value = "/paciente-vacinas/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar(@PathVariable Long id) {
		PacienteVacina pacienteVacina = pacienteVacinaRepository.findOne(id);

		ResponseEntity<PacienteVacina> response = new ResponseEntity<>(pacienteVacina, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/paciente-vacinas", method = RequestMethod.POST)
	public HttpEntity<Object> inserir(@RequestBody PacienteVacina pacienteVacina) {
		pacienteVacinaRepository.saveAndFlush(pacienteVacina);

		ResponseEntity<Object> response = new ResponseEntity<Object>(pacienteVacina, HttpStatus.CREATED);
		return response;
	}

	@RequestMapping(value = "/paciente-vacinas/{id}", method = RequestMethod.PUT)
	public HttpEntity<Object> alterar(@PathVariable Long id, @RequestBody PacienteVacina pacienteVacina) {
		pacienteVacinaRepository.saveAndFlush(pacienteVacina);

		ResponseEntity<Object> response = new ResponseEntity<Object>(pacienteVacina, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/paciente-vacinas/{id}", method = RequestMethod.DELETE)
	public HttpEntity<Object> excluir(@PathVariable Long id) {
		pacienteVacinaRepository.delete(id);

		ResponseEntity<Object> response = new ResponseEntity<Object>(null, HttpStatus.OK);
		return response;
	}

}
