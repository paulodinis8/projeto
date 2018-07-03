import {Injectable} from '@angular/core';

import {Utilizador} from './utilizador';
import {Observable} from 'rxjs';


import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError} from 'rxjs/operators';

import {Jogo} from './jogo';
import {Categoria} from './categoria';

import {of} from 'rxjs/internal/observable/of';
import {Pagina} from "./pagina";
import {Progresso} from "./progresso";


@Injectable({
  providedIn: 'root',
})

export class UserService {


  private usersUrl = 'http://localhost:8080/utilizador';
  private gamesUrl = 'http://localhost:8080/jogo';
  private categoriaUrl = 'http://localhost:8080/categoria';
  private progressoUserUrl = 'http://localhost:8080/progresso/user';

  constructor( private http: HttpClient ) { }

  getUser(id: number): Observable<Utilizador> {
    // const url = `${this.usersUrl}/${email}`;
    const url = `${this.usersUrl}/${id}`;

    return this.http.get<Utilizador>(url).pipe(
       catchError(this.handleError<Utilizador>(`getUser id=${id}`))
    );
  }

  setUser(  nome: string, localidade: string, email : string, idade : number, password : string, genero : string, totalPontos : number, foto: string) {
    const url = `${this.usersUrl}`;

    var json = JSON.stringify(
      {
        totalPontos:totalPontos,
        nome: nome,
        genero: genero,
        email: email,
        localidade: localidade,
        password: password,
        idade: idade
      });

    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    var params = json;

    this.http.post<Utilizador>(url, params, httpOptions)
      .subscribe(result => {
        console.log(result);
      });

  }


  getJogos(pag: number, filtros: number[]): Observable<Pagina> {
    let url = `${this.gamesUrl}?page=${pag}&size=6&filter=${filtros}`;
    console.log(url);
    return this.http.get<Pagina>( url )
      .pipe(
        catchError(this.handleError<Pagina>(`get Jogos`))
      );
  }

  getJogo(id: number): Observable<Jogo> {
    return this.http.get<Jogo>(`${this.gamesUrl}/${id}`)
      .pipe(
        catchError(this.handleError<Jogo>(`get Jogos`))
      );
  }

   getCategorias(): Observable<Categoria[]>{
     return this.http.get<Categoria[]>(this.categoriaUrl)
       .pipe(
         catchError(this.handleError<Categoria[]>(`Get categorias`))
       );
   }

  getProgresso(id: number): Observable<Progresso[]> {
    return this.http.get<Progresso[]>(`${this.progressoUserUrl}/${id}`)
      .pipe(
        catchError(this.handleError<Progresso[]>('get progresso by user'))
      );
  }

  private handleError<T> (operation = 'operation', result?: T) {
     return (error: any): Observable<T> => {
       console.error(error); // log to console instead
       return of( result as T );
     };
   }


}
