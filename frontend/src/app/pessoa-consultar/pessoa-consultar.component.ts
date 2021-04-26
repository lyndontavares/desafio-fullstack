
import { Component, OnInit, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Pessoa } from '../shared/pessoa';
import { PessoaService } from '../shared/pessoa.service';

@Component({
  selector: 'app-pessoa-consultar',
  templateUrl: './pessoa-consultar.component.html',
})
export class PessoaConsultarComponent implements OnInit {

  id: number;
  employee: Pessoa;

  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: PessoaService) { }

  ngOnInit() {
    this.employee = new Pessoa();

    this.id = this.route.snapshot.params['id'];

    this.employeeService.get(this.id)
      .subscribe(data => {
        console.log(data)
        this.employee = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['persons']);
  }
}
