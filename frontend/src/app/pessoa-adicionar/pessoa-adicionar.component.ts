import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pessoa } from '../shared/pessoa';
import { PessoaService } from '../shared/pessoa.service';
import { formatCPF, formatDateSQL, toUpper } from '../shared/string.helper';

@Component({
  selector: 'app-pessoa-adicionar',
  templateUrl: './pessoa-adicionar.component.html',
})
export class PessoaAdicionarComponent implements OnInit {

  pessoa: Pessoa = new Pessoa();
  submitted = false;
  errorMessage=[]

  constructor(private employeeService: PessoaService,
    private router: Router) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.pessoa = new Pessoa();
  }

  onSubmit() {
    this.errorMessage = []
    if (this.pessoa.nascimento && this.pessoa.nascimento.length!=8) {
      this.errorMessage.push('DT.NASCIMENTO Inválida')
      this.submitted = false;
    } else {
      this.save();
    }

  }

  save() {
    let pes: Pessoa = new Pessoa()
    pes['nome'] = toUpper(this.pessoa.nome)
    pes['sexo'] = toUpper(this.pessoa.sexo)
    pes['nascimento'] = formatDateSQL(this.pessoa.nascimento)
    pes['email'] = this.pessoa.email
    pes['cpf'] = formatCPF(this.pessoa.cpf)
    pes['naturalidade'] = toUpper(this.pessoa.naturalidade)
    pes['nacionalidade'] = toUpper(this.pessoa.nacionalidade)

    this.employeeService
      .create( pes ).subscribe(data => {
        this.submitted = true;
        console.log(data)
        this.errorMessage = []
        this.pessoa = new Pessoa();
        this.gotoList();

      },
        error => {
          this.submitted = false;
           this.errorMessage=error.error
           console.log(error)}
        );
  }

  gotoList() {
    this.errorMessage = []
    this.router.navigate(['/persons']);
  }

  voltar() {
    this.gotoList()
  }
}
