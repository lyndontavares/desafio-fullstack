import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloWorldComponent } from './hello-world/hello-world.component';
import { MenuComponent } from './menu/menu.component';
import { LoginComponent } from './login/login.component';

import { FormsModule } from '@angular/forms';
import { LogoutComponent } from './logout/logout.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { PessoaAdicionarComponent } from './pessoa-adicionar/pessoa-adicionar.component';
import { PessoaAtualizarComponent } from './pessoa-atualizar/pessoa-atualizar.component';
import { PessoaListarComponent } from './pessoa-listar/pessoa-listar.component';
import { HttpInterceptorService } from './shared/httpInterceptor.service';
import { PessoaConsultarComponent } from './pessoa-consultar/pessoa-consultar.component';

import { ModalModule } from 'ngx-bootstrap/modal';
import { NgxMaskModule, IConfig } from 'ngx-mask'

const maskConfig: Partial<IConfig> = {
  validation: false,
};

@NgModule({
  declarations: [
    AppComponent,
    HelloWorldComponent,
    MenuComponent,
    LoginComponent,
    LogoutComponent,
    PessoaListarComponent,
    PessoaAdicionarComponent,
    PessoaAtualizarComponent,
    PessoaConsultarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ModalModule.forRoot(),
    NgxMaskModule.forRoot(maskConfig),
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
