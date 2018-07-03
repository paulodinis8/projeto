import {NgModule} from '@angular/core';
import {ListajogosComponent} from "./listajogos/listajogos.component";
import {RouterModule, Routes} from "@angular/router";
import {IndexComponentComponent} from "./index-component/index-component.component";
import {PerfilUserComponent} from "./perfil-user/perfil-user.component";
import {EstatisticasComponent} from "./estatisticas/estatisticas.component";
import {PagJogoComponent} from "./pag-jogo/pag-jogo.component";
import {LoginComponent} from "./login/login.component";
import {SignUpComponent} from "./sign-up/sign-up.component";

const routes: Routes = [
  { path: 'listajogos', component: ListajogosComponent },
  {path: 'perfil/:id', component: PerfilUserComponent},
  { path: '', component: IndexComponentComponent, },
  { path: 'estatisticas', component: EstatisticasComponent},
  { path: 'jogo/:id', component: PagJogoComponent},
  { path: 'login', component: LoginComponent},
  { path: 'signUp', component: SignUpComponent}


];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule { }
