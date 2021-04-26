package com.idomine.desafio.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idomine.desafio.bean.Github;

@CrossOrigin(origins = {"http://localhost:8080","http://localhost:4200","http://localhost:8081"})
@RestController
@RequestMapping("/api/v1")
public class LinkProjetoController {

	@RequestMapping("/github")
	public Github getLink() {
		return new Github("https://github.com/lyndontavares/desafio-softpan");
	}
}