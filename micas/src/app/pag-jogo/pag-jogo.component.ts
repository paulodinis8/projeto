import {Component, OnInit} from '@angular/core';
import {Jogo} from "../jogo";
import {UserService} from "../user.service";
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-pag-jogo',
  templateUrl: './pag-jogo.component.html',
  styleUrls: ['./pag-jogo.component.scss']
})
export class PagJogoComponent implements OnInit {
  game: Jogo;

  constructor(private userService: UserService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.game = new Jogo();
    this.getGame();
  }

  getGame(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.userService.getGame(id)
      .subscribe(game => this.game = game);
  }

}
