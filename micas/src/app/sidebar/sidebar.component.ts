import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserService} from "../user.service";
import {Categoria} from "../categoria";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})

export class SidebarComponent implements OnInit {

  @Input() filtros: string[];
  @Output() aplicarFiltro : EventEmitter<string> = new EventEmitter<string>();
  categorias : Categoria[];

  constructor( private userService: UserService ) { }

  applyFilter( arg ){
    console.log("appling filter" + arg);
    this.aplicarFiltro.emit(arg);
  }

  getCategorias(): void {
    this.userService.getCategorias()
      .subscribe(categorias => this.categorias = categorias);
  }

  ngOnInit() {
    this.getCategorias();
  }

}

