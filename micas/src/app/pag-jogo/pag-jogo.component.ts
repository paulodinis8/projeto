import {Component, OnInit} from '@angular/core';
import {Jogo} from "../jogo";
import {UserService} from "../user.service";

@Component({
  selector: 'app-pag-jogo',
  templateUrl: './pag-jogo.component.html',
  styleUrls: ['./pag-jogo.component.scss']
})
export class PagJogoComponent implements OnInit {
  game: Jogo;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.game = new Jogo();
    this.getGame();
  }

  getGame(): void {
    this.userService.getGame(1)
      .subscribe(game => this.game = game);
  }

}
