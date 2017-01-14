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

import br.com.zarpsystem.projeto24horassaude.entity.PacienteAlergia;
import br.com.zarpsystem.projeto24horassaude.repository.PacienteAlergiaRepository;

@RestController
public class PacienteAlergiaController {


	@Autowired
	private PacienteAlergiaRepository pacienteAlergiaRepository;
	
	@RequestMapping(value = "/paciente-alergias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar(){	
		List<PacienteAlergia> pacienteAlergiaList = pacienteAlergiaRepository.findAll();
		
		ResponseEntity<List<PacienteAlergia>> response = new ResponseEntity<>(pacienteAlergiaList, HttpStatus.OK);
		return response;	
	}
	
	@RequestMapping(value = "/paciente-alergias/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar(@PathVariable Long id){
		PacienteAlergia pacienteAlergia = pacienteAlergiaRepository.findOne(id);
		
		ResponseEntity<PacienteAlergia> response = new ResponseEntity<>(pacienteAlergia, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/paciente-alergias", method = RequestMethod.POST)
	public HttpEntity<Object> inserir(@RequestBody PacienteAlergia pacienteAlergia){
		pacienteAlergiaRepository.saveAndFlush(pacienteAlergia);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(pacienteAlergia, HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(value = "/paciente-alergias/{id}", method = RequestMethod.PUT)
	public HttpEntity<Object> alterar(@PathVariable Long id, @RequestBody PacienteAlergia pacienteAlergia) {
		pacienteAlergiaRepository.saveAndFlush(pacienteAlergia);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(pacienteAlergia, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/paciente-alergias/{id}", method = RequestMethod.DELETE)
	public HttpEntity<Object> excluir(@PathVariable Long id) {
		pacienteAlergiaRepository.delete(id);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(null, HttpStatus.OK);
		return response;
	}
	
	
}

