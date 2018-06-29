import { NgModule } from '@angular/core';
import {ListajogosComponent} from "./listajogos/listajogos.component";
import {RouterModule, Routes} from "@angular/router";
import {IndexComponentComponent} from "./index-component/index-component.component";
import {PerfilUserComponent} from "./perfil-user/perfil-user.component";
import {EstatisticasComponent} from "./estatisticas/estatisticas.component";

const routes: Routes = [
  { path: 'listajogos', component: ListajogosComponent },
  { path: 'perfil', component: PerfilUserComponent},
  { path: '', component: IndexComponentComponent, },
  { path: "estatisticas", component: EstatisticasComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule { }
