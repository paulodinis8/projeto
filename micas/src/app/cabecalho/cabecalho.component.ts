///<reference path="../../../node_modules/rxjs/internal/Observable.d.ts"/>
import {Component, OnInit} from '@angular/core';
import {Utilizador} from '../utilizador';
import {UserService} from '../user.service';


@Component({
  selector: 'app-cabecalho',
  templateUrl: './cabecalho.component.html',
  styleUrls: ['./cabecalho.component.css'],
  providers: [UserService]
})

export class CabecalhoComponent implements OnInit {
    title = 'Bau de Jogos';
    user: Utilizador;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
      this.user = new Utilizador();
      this.getUser();
  }

  getUser(): void {
    this.userService.getUser(1)
      .subscribe(user => this.user = user);
  }

}
