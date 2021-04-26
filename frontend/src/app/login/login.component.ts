import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from './auth.service';
import { environment } from './../../environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password : string;
  errorMessage = 'Senha/Usuário inválido!';
  successMessage: string;
  invalidLogin = false;
  loginSuccess = false;
  baseUrl =environment.baseUrl

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) {   }

  ngOnInit() {
  }

  handleLogin() {
    this.authenticationService.authenticationService(this.username, this.password).subscribe((result)=> {
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = `Olá ${this.username}!`;
      this.router.navigate(['/persons']);
    }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });
  }
}
