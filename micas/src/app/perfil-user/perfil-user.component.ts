import {Component, OnInit} from '@angular/core';
import {UserService} from "../user.service";
import {Utilizador} from "../utilizador";
import {Jogo} from "../jogo";

@Component({
  selector: 'app-perfil-user',
  templateUrl: './perfil-user.component.html',
  styleUrls: ['./perfil-user.component.css']
})
export class PerfilUserComponent implements OnInit {
  user: Utilizador;
  game: Jogo;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.user = new Utilizador();
    this.game = new Jogo();
    this.getUser();
    this.getGame();

  }

  getUser(): void {
    this.userService.getUser(1)
      .subscribe(user => this.user = user);
  }

  getGame(): void {
    this.userService.getGame(1)
      .subscribe(game => this.game = game);
  }
}
