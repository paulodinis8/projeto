import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {IndexComponentComponent} from './index-component/index-component.component';
import {ListajogosComponent} from './listajogos/listajogos.component';
import {CabecalhoComponent} from './cabecalho/cabecalho.component';
import {UserService} from './user.service';

import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {PerfilUserComponent} from './perfil-user/perfil-user.component';

import {CarouselModule} from 'ngx-bootstrap/carousel';
//import { SidebarComponent } from './sidebar/sidebar.component';
import {PagJogoComponent} from './pag-jogo/pag-jogo.component';
import {SidebarComponent} from './sidebar/sidebar.component';
import {EstatisticasComponent} from './estatisticas/estatisticas.component';
import { LoginComponent } from './login/login.component';
import { SignUpComponent } from './sign-up/sign-up.component';


@NgModule({
  declarations: [
    AppComponent,
    IndexComponentComponent,
    ListajogosComponent,
    AppComponent,
    CabecalhoComponent,
    PerfilUserComponent,
    SidebarComponent,
    EstatisticasComponent,
    PagJogoComponent,
    LoginComponent,
    SignUpComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    CarouselModule.forRoot(),
  ],
  bootstrap: [
    AppComponent
  ],
  providers: [
    UserService
  ]
})
export class AppModule { }
