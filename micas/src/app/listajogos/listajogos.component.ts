import { Component, OnInit } from '@angular/core';
import { UserService } from "../user.service";

import { Jogo } from "../jogo";
import { Categoria } from "../categoria";


@Component({
  selector: 'app-listajogos',
  templateUrl: './listajogos.component.html',
  styleUrls: ['./listajogos.component.css']
})

export class ListajogosComponent implements OnInit {

  jogos : Jogo[];
  filtros : string[];

  constructor( private userService: UserService) { }

  ngOnInit() {
    //getJogos( filtros);
  }

  handleMyEvent( arg ): void{
    var index  =  this.filtros.indexOf(arg);
    if(  index == -1) this.filtros.push( arg );
    else this.filtros.splice(index,1);
  }

  /*
  getJogos(): void{
    this.userService.getJogos( filtros)
    .subscribe(jogos => this.jogos = jogos);
  }
   */
}
