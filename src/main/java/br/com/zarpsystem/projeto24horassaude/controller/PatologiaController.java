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

import br.com.zarpsystem.projeto24horassaude.entity.Patologia;
import br.com.zarpsystem.projeto24horassaude.repository.PatologiaRepository;

@RestController
public class PatologiaController {

	@Autowired
	private PatologiaRepository patologiaRepository;

	@RequestMapping(value = "/patologias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar() {
		List<Patologia> patologiaList = patologiaRepository.findAll();

		ResponseEntity<List<Patologia>> response = new ResponseEntity<>(patologiaList, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/patologias/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar(@PathVariable Long id) {
		Patologia patologia = patologiaRepository.findOne(id);

		ResponseEntity<Patologia> response = new ResponseEntity<>(patologia, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/patologias", method = RequestMethod.POST)
	public HttpEntity<Object> inserir(@RequestBody Patologia patologia) {
		patologiaRepository.saveAndFlush(patologia);

		ResponseEntity<Object> response = new ResponseEntity<Object>(patologia, HttpStatus.CREATED);
		return response;
	}

	@RequestMapping(value = "/patologias/{id}", method = RequestMethod.PUT)
	public HttpEntity<Object> alterar(@PathVariable Long id, @RequestBody Patologia patologia) {
		patologiaRepository.saveAndFlush(patologia);

		ResponseEntity<Object> response = new ResponseEntity<Object>(patologia, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/patologias/{id}", method = RequestMethod.DELETE)
	public HttpEntity<Object> excluir(@PathVariable Long id) {
		patologiaRepository.delete(id);

		ResponseEntity<Object> response = new ResponseEntity<Object>(null, HttpStatus.OK);
		return response;
	}

}
