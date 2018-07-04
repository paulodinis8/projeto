import {Component, OnInit} from '@angular/core';
import {UserService} from "../user.service";

@Component({
  selector: 'app-criar-jogo',
  templateUrl: './criar-jogo.component.html',
  styleUrls: ['./criar-jogo.component.scss']
})
export class CriarJogoComponent implements OnInit {

  constructor(private userService: UserService) {
  }

  ngOnInit() {
  }

  register(nome: string, link: string, descricao: string, foto: string): void {
    console.log("register");
    this.userService.setJogo(nome, link, descricao, foto)
  }

}
