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

import br.com.zarpsystem.projeto24horassaude.entity.PacientePatologia;
import br.com.zarpsystem.projeto24horassaude.repository.PacientePatologiaRepository;

@RestController
public class PacientePatologiaController {

	@Autowired
	private PacientePatologiaRepository pacientePatologiaRepository;
	
	@RequestMapping(value = "/paciente-patologias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar(){	
		List<PacientePatologia> pacientePatologiaList = pacientePatologiaRepository.findAll();
		
		ResponseEntity<List<PacientePatologia>> response = new ResponseEntity<>(pacientePatologiaList, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/paciente-patologias/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar(@PathVariable Long id){
		PacientePatologia pacientePatologia = pacientePatologiaRepository.findOne(id);
		
		ResponseEntity<PacientePatologia> response = new ResponseEntity<>(pacientePatologia, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/paciente-patologias", method = RequestMethod.POST)
	public HttpEntity<Object> inserir(@RequestBody PacientePatologia pacientePatologia){
		pacientePatologiaRepository.saveAndFlush(pacientePatologia);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(pacientePatologia, HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(value = "/paciente-patologias/{id}", method = RequestMethod.PUT)
	public HttpEntity<Object> alterar(@PathVariable Long id, @RequestBody PacientePatologia pacientePatologia) {
		pacientePatologiaRepository.saveAndFlush(pacientePatologia);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(pacientePatologia, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/paciente-patologias/{id}", method = RequestMethod.DELETE)
	public HttpEntity<Object> excluir(@PathVariable Long id) {
		pacientePatologiaRepository.delete(id);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(null, HttpStatus.OK);
		return response;
	}
	
	
}
