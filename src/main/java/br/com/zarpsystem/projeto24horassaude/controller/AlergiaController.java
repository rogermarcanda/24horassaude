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

import br.com.zarpsystem.projeto24horassaude.entity.Alergia;
import br.com.zarpsystem.projeto24horassaude.repository.AlergiaRepository;

@RestController
public class AlergiaController {


	@Autowired
	private AlergiaRepository alergiaRepository;
	
	@RequestMapping(value = "/alergias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar(){	
		List<Alergia> alergiaList = alergiaRepository.findAll();
		
		ResponseEntity<List<Alergia>> response = new ResponseEntity<>(alergiaList, HttpStatus.OK);
		return response;	
	}
	
	@RequestMapping(value = "/alergias/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar(@PathVariable Long id){
		Alergia alergia = alergiaRepository.findOne(id);
		
		ResponseEntity<Alergia> response = new ResponseEntity<>(alergia, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(value = "/alergias", method = RequestMethod.POST)
	public HttpEntity<Object> inserir(@RequestBody Alergia alergia){
		alergiaRepository.saveAndFlush(alergia);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(alergia, HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(value = "/alergias/{id}", method = RequestMethod.PUT)
	public HttpEntity<Object> alterar(@PathVariable Long id, @RequestBody Alergia alergia) {
		alergiaRepository.saveAndFlush(alergia);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(alergia, HttpStatus.OK);
		return response;
	}

	
	@RequestMapping(value = "/alergias/{id}", method = RequestMethod.DELETE)
	public HttpEntity<Object> excluir(@PathVariable Long id) {
		alergiaRepository.delete(id);
		
		ResponseEntity<Object> response = new ResponseEntity<Object>(null, HttpStatus.OK);
		return response;
	}
	
}

