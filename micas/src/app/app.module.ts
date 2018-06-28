import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { IndexComponentComponent } from './index-component/index-component.component';
import { ListajogosComponent } from './listajogos/listajogos.component';
import { CabecalhoComponent } from './cabecalho/cabecalho.component';
import { UserService } from './user.service';

import { HttpClientModule }    from '@angular/common/http';

import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { AppRoutingModule } from './app-routing.module';
import { PerfilUserComponent } from './perfil-user/perfil-user.component';

import { CarouselModule } from 'ngx-bootstrap/carousel';
import { SidebarComponent } from './sidebar/sidebar.component';


@NgModule({
  declarations: [
    AppComponent,
    IndexComponentComponent,
    ListajogosComponent,
    AppComponent,
    CabecalhoComponent,
    PerfilUserComponent,
    SidebarComponent
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
  providers: [UserService]
})
export class AppModule { }
