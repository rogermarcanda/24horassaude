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

import br.com.zarpsystem.projeto24horassaude.entity.Paciente;
import br.com.zarpsystem.projeto24horassaude.repository.PacienteRepository;

@RestController
public class PacienteController {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@RequestMapping(value = "/pacientes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar(){	
		List<Paciente> pacienteList = pacienteRepository.findAll();

		ResponseEntity<List<Paciente>> response = new ResponseEntity<>(pacienteList, HttpStatus.OK);
		return response;	
	}
	
	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar(@PathVariable Long id){
		Paciente paciente = pacienteRepository.findOne(id);

		ResponseEntity<Paciente> response = new ResponseEntity<>(paciente, HttpStatus.OK);
		return response;	
	}
	
	@RequestMapping(value = "/pacientes", method = RequestMethod.POST)
	public HttpEntity<Object> inserir(@RequestBody Paciente paciente){
		pacienteRepository.saveAndFlush(paciente);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(paciente, HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.PUT)
	public HttpEntity<Object> alterar(@PathVariable Long id, @RequestBody Paciente paciente) {
		pacienteRepository.saveAndFlush(paciente);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(paciente, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.DELETE)
	public HttpEntity<Object> excluir(@PathVariable Long id) {
		pacienteRepository.delete(id);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(null, HttpStatus.OK);
		return response;
	}
	
	
}
