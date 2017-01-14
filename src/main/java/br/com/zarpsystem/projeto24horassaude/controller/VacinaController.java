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

import br.com.zarpsystem.projeto24horassaude.entity.Vacina;
import br.com.zarpsystem.projeto24horassaude.repository.VacinaRepository;

@RestController
public class VacinaController {

	@Autowired
	private VacinaRepository vacinaRepository;

	@RequestMapping(value = "/vacinas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar() {
		List<Vacina> vacinaList = vacinaRepository.findAll();

		ResponseEntity<List<Vacina>> response = new ResponseEntity<>(vacinaList, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/vacinas/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<?> buscar(@PathVariable Long id) {
		Vacina vacina = vacinaRepository.findOne(id);

		ResponseEntity<Vacina> response = new ResponseEntity<>(vacina, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/vacinas", method = RequestMethod.POST)
	public HttpEntity<Object> inserir(@RequestBody Vacina vacina) {
		vacinaRepository.saveAndFlush(vacina);

		ResponseEntity<Object> response = new ResponseEntity<Object>(vacina, HttpStatus.CREATED);
		return response;
	}

	@RequestMapping(value = "/vacinas/{id}", method = RequestMethod.PUT)
	public HttpEntity<Object> alterar(@PathVariable Long id, @RequestBody Vacina vacina) {
		vacinaRepository.saveAndFlush(vacina);

		ResponseEntity<Object> response = new ResponseEntity<Object>(vacina, HttpStatus.OK);
		return response;
	}

	@RequestMapping(value = "/vacinas/{id}", method = RequestMethod.DELETE)
	public HttpEntity<Object> excluir(@PathVariable Long id) {
		vacinaRepository.delete(id);

		ResponseEntity<Object> response = new ResponseEntity<Object>(null, HttpStatus.OK);
		return response;
	}

}
