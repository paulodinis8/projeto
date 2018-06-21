import { Component, OnInit } from '@angular/core';
import { Utilizador } from '../utilizador';
import { UserService } from '../user.service';


@Component({
  selector: 'app-cabecalho',
  templateUrl: './cabecalho.component.html',
  styleUrls: ['./cabecalho.component.css']
})

export class CabecalhoComponent implements OnInit {

  user : Utilizador;

  constructor( private userService: UserService) { }

  ngOnInit() {
    this.getUser();
  }

  getUser(): void {
    this.userService.getUser(1)
      .subscribe(user => this.user = user);
  }

}
