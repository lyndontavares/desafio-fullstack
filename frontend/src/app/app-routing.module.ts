import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HelloWorldComponent } from './hello-world/hello-world.component';
import { LoginComponent } from './login/login.component';
import { PessoaAdicionarComponent } from './pessoa-adicionar/pessoa-adicionar.component';
import { PessoaAtualizarComponent } from './pessoa-atualizar/pessoa-atualizar.component';
import { PessoaConsultarComponent } from './pessoa-consultar/pessoa-consultar.component';
import { PessoaListarComponent } from './pessoa-listar/pessoa-listar.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},

  {path: 'hello-world', component: HelloWorldComponent},
  {path: 'logout', component: LoginComponent},

  { path: 'persons', component: PessoaListarComponent },
  { path: 'add', component: PessoaAdicionarComponent },
  { path: 'update/:id', component: PessoaAtualizarComponent },
  { path: 'details/:id', component: PessoaConsultarComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
