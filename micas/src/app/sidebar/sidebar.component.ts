import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserService} from "../user.service";
import {Categoria} from "../categoria";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})

export class SidebarComponent implements OnInit {

  @Input() filtros: Categoria[];
  @Output() aplicarFiltro : EventEmitter<Categoria> = new EventEmitter<Categoria>();

  categorias : Categoria[];

  constructor( private userService: UserService ) { }

  applyFilter( arg : Categoria ){
    this.aplicarFiltro.emit(arg);
  }

  getCategorias(): void {
    this.userService.getCategorias()
      .subscribe(categorias => this.categorias = categorias);
  }

  ngOnInit() {
    this.categorias = [];
    this.getCategorias();
  }

}

