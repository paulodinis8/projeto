import { Component, OnInit } from '@angular/core';
import {UserService} from "../user.service";
import {Utilizador} from "../utilizador";

@Component({
  selector: 'app-perfil-user',
  templateUrl: './perfil-user.component.html',
  styleUrls: ['./perfil-user.component.css']
})
export class PerfilUserComponent implements OnInit {
  user: Utilizador;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.getUser();
    this.user = new Utilizador();
  }

  getUser(): void {
    this.userService.getUser(2)
      .subscribe(user => this.user = user);
    //.subscribe((user) => {
    //  console.log(user);
    //}

  }
}
