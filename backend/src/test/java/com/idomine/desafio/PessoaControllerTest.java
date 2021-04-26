package com.idomine.desafio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.idomine.desafio.controller.PessoaController;
import com.idomine.desafio.model.Pessoa;

 
@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaControllerTest {

    @Autowired
    private PessoaController controller;
    
    @Test
    public void teste_adicionar_pessoa_valida() {
 
	    ResponseEntity<Object> response = controller.add(pessoaValida() );
	    
	    assertTrue(  response.getBody() instanceof Pessoa);
 
    }
    
    
    @Test
    public void teste_adicionar_pessoa_invalida() {
    	
    	ResponseEntity<Object> response = controller.add(pessoaInvalida());
    
    	assertFalse(  response.getBody() instanceof Pessoa);
    }
    
    private Pessoa pessoaValida() {
    	 Pessoa pessoa = new Pessoa();
    	    pessoa.setCpf("88888888888");
    	    pessoa.setDataCriacao(LocalDateTime.now());
    	    pessoa.setEmail("email@gmail.com");
    	    pessoa.setNascimento(LocalDate.of(1964, 11, 9));
    	    pessoa.setNacionalidade("BRASIL");
    	    pessoa.setNaturalidade("FORTALEZA");
    	    pessoa.setNome("LYNDON TAVARES");
    	    pessoa.setSexo("M");
    	    return pessoa;
    }
    
    private Pessoa pessoaInvalida() {
        Pessoa pessoa = new Pessoa();
        pessoa.setDataCriacao(LocalDateTime.now());
        pessoa.setEmail("");
        pessoa.setNacionalidade("BRASIL");
        pessoa.setNaturalidade("FORTALEZA");
        pessoa.setSexo("M");
        return pessoa;
    }
    
    
	
}
