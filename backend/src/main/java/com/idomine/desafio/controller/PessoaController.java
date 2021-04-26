package com.idomine.desafio.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idomine.desafio.exception.ResourceNotFoundException;
import com.idomine.desafio.model.Pessoa;
import com.idomine.desafio.repository.PessoaRepository;
import com.idomine.desafio.service.PessoaValidationService;
 
@CrossOrigin(origins = {"http://localhost:8080","http://localhost:4200","http://localhost:8081"})
@RestController
@RequestMapping("/api/v1")
public class PessoaController {
	
	private final String NOT_FOUND =  "Pessoa não encontrada para este ID "; 
	
	@Autowired
	private PessoaRepository employeeRepository;
	
	@Autowired
	private PessoaValidationService validService;

	@GetMapping("/pessoas")
	public List<Pessoa> getAll() {
		return employeeRepository.findAll();
	}

	@GetMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> getById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Pessoa pessoa = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + id));
		return ResponseEntity.ok().body(pessoa);
	}

	@PostMapping("/pessoas")
	public ResponseEntity<Object> add(@Valid @RequestBody Pessoa pessoa) {
		
		List<String> errors = validService.validar(pessoa, true);
		
		if ( errors.isEmpty()) {
			pessoa.setDataCriacao(LocalDateTime.now());
	 		Pessoa pessoaNew =  employeeRepository.save(pessoa);
			return ResponseEntity.ok(pessoaNew);
		} else {
			return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
		}
		
	}

	@PutMapping("/pessoas/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,@Valid @RequestBody Pessoa pessoa)   {
		
		List<String> errors = validService.validar(pessoa, false);
		 
		if ( errors.isEmpty()) {
			pessoa.setDataAtualizacao(LocalDateTime.now());
	 		Pessoa pessoaUpdated =  employeeRepository.save(pessoa);
			return ResponseEntity.ok(pessoaUpdated);
		} else {
			return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/pessoas/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Pessoa pessoa = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + id));

		employeeRepository.delete(pessoa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
