import {Component, OnInit} from '@angular/core';
import {UserService} from "../user.service";

import {Pagina} from "../pagina";
import {Categoria} from "../categoria";

@Component({
  selector: 'app-listajogos',
  templateUrl: './listajogos.component.html',
  styleUrls: ['./listajogos.component.css']
})


export class ListajogosComponent implements OnInit {

  pag : Pagina;
  filtros : Categoria[];

  constructor( private userService: UserService) { }

  ngOnInit() {
    this.pag = null;
    this.filtros = [];
    this.getJogos(0,[]);
  }

  avancaPag():void {
    if( ! this.pag.last ){
      this.getJogos( this.pag.number +1, this.filtros.map( function (x) :number { return x.id }));
    }
    console.log("pag last? " + this.pag.last);
  }

  retrocedePag():void {
    if( ! this.pag.first ){
      this.getJogos( this.pag.number -1, this.filtros.map( function (x) :number { return x.id }));
    }
  }


  handleMyEvent( arg : Categoria): void {
    let index  =  this.filtros.indexOf( arg );
    if(  index == -1) this.filtros.push( arg );
    else this.filtros.splice( index,1);
    this.getJogos(0, this.filtros.map( function (x) :number { return x.id }) );
  }

  getJogos( pagNumber: number, filter : number[] ): void {

    this.userService.getJogos(pagNumber, filter )
      .subscribe(pag => this.pag = pag);

    //debugger

    if( this.pag) console.log("received page number:" + pagNumber + " whith filters:" + filter + " jogos:" + this.pag.numberOfElements );
    else console.log("ERRROOOO");
  }

}
