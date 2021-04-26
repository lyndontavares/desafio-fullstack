package com.idomine.desafio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idomine.desafio.helper.CpfHelper;
import com.idomine.desafio.model.Pessoa;
import com.idomine.desafio.repository.PessoaRepository;

/**
 * 
 * @Nome - obrigatório
 * @Sexo
 * @E-mail - não obrigatório, deve ser validado caso preenchido
 * @Data de Nascimento - obrigatório, deve ser validada
 * @Naturalidade
 * @Nacionalidade
 * @CPF - obrigatório, deve ser validado (formato e não pode haver dois cadastros com mesmo cpf)
 */

@Service
public class PessoaValidationService {
  
  @Autowired
  PessoaRepository repoPessoa;
  
  public List<String> validar(Pessoa pessoa, boolean isNovoRegistro) {
	  List<String> errors = new ArrayList<>();
	  
	  //EXISTE
	  if (!isNovoRegistro ) {
		  if( !repoPessoa.findById(pessoa.getId()).isPresent() ) {
			  errors.add("ID "+pessoa.getId()+ " não cadastrado ");
		  }
	  }
	  
	  //NOME
	  if ( pessoa.getNome()==null || "".equals( pessoa.getNome()) ) {
		  errors.add("NOME é obrigatório");
	  } else if ( pessoa.getNome()==null && pessoa.getNome().length() > 100 ) {
		  errors.add("NOME máximo: 100 caracteres");
	  }
	  
	  //SEXO
	  if (pessoa.getSexo()!=null && !"MF".contains(pessoa.getSexo())) {
		  errors.add("SEXO inválido. Informe M ou F");
	  } else if ( pessoa.getSexo()!=null && pessoa.getSexo().length() > 1 ) {
		  errors.add("SEXO máximo: 1 caracteres");
	  }
	  
	  //DT.NASCIMENTO
	  if (pessoa.getNascimento()==null) {
		  errors.add("DT.NASCIMENTO é obrigatório");
	  }
	  
	  //CPF
	  if ( pessoa.getCpf()==null || "".equals( pessoa.getCpf()) ) {
		  errors.add("CPF é obrigatório");
	  } else {
		  
		  if ( !CpfHelper.isCpf( pessoa.getCpf() ) ) {
			  errors.add("CPF Inválido");
		  } else {
			 Optional<Pessoa> pessoaBusca = repoPessoa.findByCpf( pessoa.getCpf()); 
			 boolean isCpfEncontrado = pessoaBusca.isPresent(); 
			 
			 if ( isNovoRegistro && isCpfEncontrado ) {
				 errors.add("CPF Já cadastrado");
			 }
			 
			 if ( !isNovoRegistro && pessoaBusca.isPresent() && pessoa.getId() != pessoaBusca.get().getId() ) {
				 errors.add("CPF Já cadastrado");
			 }
		  } 
	  }
	  	  	  
	  return errors;
  }
}
