import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../user.service";
import {Utilizador} from "../utilizador";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  user: Utilizador;
  email: string;

  constructor(private userService: UserService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.user = new Utilizador();
  }

  getUserEmail(): void {
    this.userService.getUserEmail(this.email)
      .subscribe(user => {
        this.user = user;
      });
  }

}
