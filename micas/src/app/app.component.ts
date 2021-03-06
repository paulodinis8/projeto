///<reference path="user.service.ts"/>
import {Component, OnInit} from '@angular/core';
import {Utilizador} from './utilizador';
import {UserService} from './user.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  user: Utilizador;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.user = new Utilizador();
    this.getUser();
  }

  getUser(): void {
    this.userService.getUser(2)
      .subscribe(user => this.user = user);
  }

}
