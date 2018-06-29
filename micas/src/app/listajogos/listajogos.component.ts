import { Component, OnInit } from '@angular/core';
import { UserService } from "../user.service";

import { Jogo } from "../jogo";
import { Categoria } from "../categoria";
import {forEach} from "@angular/router/src/utils/collection";


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
    this.getJogos();
  }

  handleMyEvent( arg ): void{
    let index  =  this.filtros.indexOf(arg);
    if(  index == -1) this.filtros.push( arg );
    else this.filtros.splice(index,1);
  }


  getJogos(): void{
    this.userService.getJogos()
    .subscribe(jogos => this.jogos = jogos);

    // caso nao haja filtros aplicados vamos imprimir todos os jogos
    if( this.filtros.length == 0 ) return ;

    for( let i = 0; i < this.jogos.length; i ++ ){
      let flag = false;

      //  cat é uma lista de categorias ( mas em string)
      let cat : string[] = this.jogos[i].categorias.map( function (x) {  return x.descricao; });

      // verificar se o jogo em questao tem pelo menos uma categoria que procuramos
      for( let j = 0; j < this.filtros.length && !flag; j++)
        if( cat.indexOf( this.filtros[j] )  != -1 ) flag = true;

      // caso nao tenha, eliminamos
      if( !flag ){
        this.jogos.splice(i,1);
      }
    }
  }

}
