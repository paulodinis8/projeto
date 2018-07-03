import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserService} from "../user.service";
import {Categoria, CategoriaPai} from "../categoria";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})

export class SidebarComponent implements OnInit {

  @Input() filtros: Categoria[];
  @Output() aplicarFiltro : EventEmitter<Categoria> = new EventEmitter<Categoria>();

  map : { [path: string] :Categoria[]; };


  constructor( private userService: UserService ) { }

  applyFilter( arg : Categoria ){
    this.aplicarFiltro.emit(arg);
  }

  getCategorias(): void {
    this.userService.getCategorias()
      .subscribe(categorias => {
          for( let cat of categorias ){
            if( cat.categoriaPai.designacao in this.map )
              this.map[cat.categoriaPai.designacao].push(cat);
            else
              this.map[cat.categoriaPai.designacao] = [cat];

          }
        }
      );
  }

  getKeys(): string[]{
    let arr = [];
    for( let key in this.map ) arr.push(key);
    return arr;
  }


  ngOnInit() {
    this.map = {};
    this.getCategorias();
  }

}

