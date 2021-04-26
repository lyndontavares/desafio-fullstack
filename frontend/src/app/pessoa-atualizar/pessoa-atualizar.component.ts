import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Pessoa } from '../shared/pessoa';
import { PessoaService } from '../shared/pessoa.service';
import { formatCPF, formatDateSQL, formatSQLDate, toUpper } from '../shared/string.helper';

@Component({
  selector: 'app-pessoa-atualizar',
  templateUrl: './pessoa-atualizar.component.html',
})
export class PessoaAtualizarComponent implements OnInit {

  id: number;
  pessoa: Pessoa;
  submitted = false;
  errorMessage = []

  constructor(private route: ActivatedRoute,private router: Router,
    private pessoaService: PessoaService) { }

  ngOnInit() {
    this.pessoa = new Pessoa();
    this.id = this.route.snapshot.params['id'];
    this.pessoaService.get(this.id)
      .subscribe(data => {
        console.log(data)
        this.pessoa = data;
        this.pessoa.nascimento = formatSQLDate(this.pessoa.nascimento)
      }, error => console.log(error));
  }

  update() {
    this.errorMessage = []
    let pes: Pessoa = new Pessoa()
    pes['id'] = this.pessoa.id
    pes['nome'] = toUpper(this.pessoa.nome)
    pes['sexo'] = toUpper(this.pessoa.sexo)
    pes['nascimento'] = formatDateSQL(this.pessoa.nascimento)
    pes['email'] = this.pessoa.email
    pes['cpf'] = formatCPF(this.pessoa.cpf)
    pes['naturalidade'] = toUpper(this.pessoa.naturalidade)
    pes['nacionalidade'] = toUpper(this.pessoa.nacionalidade)

    this.pessoaService.update(this.id, pes)
      .subscribe(data => {
        console.log(data);
        this.pessoa = new Pessoa();
        this.gotoList();
      }, error => {
        this.submitted = false;
        this.errorMessage = error.error
        console.log(error)
      });
  }

  onSubmit() {
    this.update();
  }

  gotoList() {
    this.router.navigate(['/persons']);
  }
}
