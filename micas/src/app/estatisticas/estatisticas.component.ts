import { Component, OnInit } from '@angular/core';
import {Categoria} from "../categoria";
import {UserService} from "../user.service";
import { Trofeu, Pontos, Progresso, Registo } from "../trofeu";

@Component({
  selector: 'app-estatisticas',
  templateUrl: './estatisticas.component.html',
  styleUrls: ['./estatisticas.component.scss']
})
export class EstatisticasComponent implements OnInit {

  categorias : Categoria[];
  trofeus : { [path: string] :number; }[];
  array : number[];

  constructor(  private userService: UserService ) { }

  ngOnInit() {
    this.getCategorias();
    this.getTrofeus();
  }

  getCategorias(): void {
    this.userService.getCategorias()
      .subscribe(categorias => {
        this.categorias = categorias;
        this.getTrofeus();
      });
  }

  getTrofeus(): void {
    this.userService.getTrofeus(1).subscribe(trofeus => {

        for( let trofeu of trofeus){

          let categoriasTrofeu = trofeu.registo.progresso.jogo.categorias;

          for( let cat of categoriasTrofeu){
            let index = this.categorias.indexOf(cat);
            if( trofeu.pontos.tipo in trofeus[index]  )
              this.trofeus[index][trofeu.pontos.tipo] += trofeu.pontos.pontos;
            else
              this.trofeus[index][trofeu.pontos.tipo] = trofeu.pontos.pontos;
          }
        }
        this.array =  Array.apply(null, {length: this.categorias.length}).map(Function.call, Number);
    });
  }




}
