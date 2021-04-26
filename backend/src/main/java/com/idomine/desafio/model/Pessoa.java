package com.idomine.desafio.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "pessoas", indexes = { @Index(name = "idx_pessoas_cpf", columnList = "cpf", unique = true)})
public class Pessoa extends AbstractEntity {

	@Column(name="nome")
	private String nome;

	@Column(name="sexo")
	private String sexo;

	@Email
	@Column(name="email")
	private String email;

	@Column(name="data_nascimento")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate nascimento;

	@Column(name="cpf")
	private String cpf;

	@Column(name="naturalidade")
	private String naturalidade;

	@Column(name="nacionalidade")
	private String nacionalidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

 	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + super.getId() + ", nome=" + nome + ", sexo=" + sexo + ", email=" + email + ", nascimento="
				+ nascimento + ", cpf=" + cpf + ", naturtalidade=" + naturalidade + ", nacionalidade=" + nacionalidade
				+ "]";
	}

}
