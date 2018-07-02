import {Component, OnInit} from '@angular/core';
import {UserService} from "../user.service";
import {Utilizador} from "../utilizador";
import {Progresso} from "../progresso";
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-perfil-user',
  templateUrl: './perfil-user.component.html',
  styleUrls: ['./perfil-user.component.css']
})

export class PerfilUserComponent implements OnInit {

  user: Utilizador;

  progressos: Progresso[];

  constructor(private userService: UserService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.user = new Utilizador();
    this.progressos = [];
    this.getUser();
  }

  getUser(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.userService.getUser(1)
      .subscribe(user => {
        this.user = user;
        this.getProgresso(user.id)
      });
  }

  getProgresso(id): void {
    this.userService.getProgresso(id)
      .subscribe(progressos => this.progressos = progressos);
  }

}
