import { Component, OnInit } from '@angular/core';
import {UserService} from "../user.service";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {


  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  register(nome: string, localidade: string, email : string, idade : number, password : string, genero : string, totalPontos : number, foto: string): void{
    console.log("register");
    this.userService.setUser(nome, localidade, email, idade, password, genero, totalPontos, foto)
  }


}
