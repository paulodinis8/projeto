import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ListajogosComponent} from "./listajogos/listajogos.component";
import {RouterModule, Routes} from "@angular/router";
import {IndexComponentComponent} from "./index-component/index-component.component";
import {PerfilUserComponent} from "./perfil-user/perfil-user.component";

const routes: Routes = [
  { path: 'listajogos', component: ListajogosComponent },
  { path: 'perfil', component: PerfilUserComponent},
  { path: '', component: IndexComponentComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
