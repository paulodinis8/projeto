///<reference path="user.service.ts"/>
import {Component, OnInit} from '@angular/core';
import {Utilizador} from './utilizador';
import {UserService} from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  Utizador: Utilizador[];

  constructor(private userService: UserService){ }

  ngOnInit() {

  }

}
