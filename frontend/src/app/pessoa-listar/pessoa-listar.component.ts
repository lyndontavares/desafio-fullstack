import { Observable } from "rxjs";
import { Component, OnInit, TemplateRef } from "@angular/core";
import { Router } from '@angular/router';
import { Pessoa } from "../shared/pessoa";
import { PessoaService } from "../shared/pessoa.service";
import { BsModalService } from 'ngx-bootstrap/modal';
import { BsModalRef } from 'ngx-bootstrap/modal/bs-modal-ref.service';

@Component({
  selector: "app-pessoa-listar",
  templateUrl: "./pessoa-listar.component.html",
})
export class PessoaListarComponent implements OnInit {

  modalRef: BsModalRef;
  pessoas: Observable<Pessoa[]>;
  idToBeDeleted;

  constructor(
    private pessoaService: PessoaService,
    private modalService: BsModalService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.pessoas = this.pessoaService.getAll();
  }

  doDelete() {
    this.modalService.hide()
    this.pessoaService.delete(this.idToBeDeleted)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  onDetails(id: number){
    this.router.navigate(['details', id]);
  }

  onUpdate(id: number){
    this.router.navigate(['update', id]);
  }

  openModal(template: TemplateRef<any>, id: any) {
    this.modalRef = this.modalService.show(template, { class: 'modal-sm' });
    this.idToBeDeleted = id;
  }

  doClose() {
    this.modalService.hide()
  }

}
