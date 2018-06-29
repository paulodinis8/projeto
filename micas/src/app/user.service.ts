import {Injectable} from '@angular/core';

import {Utilizador} from './utilizador';
import {Observable} from 'rxjs';


import {HttpClient} from '@angular/common/http';
import {catchError} from 'rxjs/operators';

import {Jogo} from './jogo';
import {Categoria} from './categoria';

import {of} from 'rxjs/internal/observable/of';


@Injectable({
  providedIn: 'root',
})

export class UserService {


  private usersUrl = 'http://localhost:8080/utilizador';
  private gamesUrl = 'http://localhost:8080/jogo';
  private categoriaUrl =  'http://localhost:8080/categoria';

  constructor( private http: HttpClient ) { }

  getUser(id: number): Observable<Utilizador> {
    // const url = `${this.usersUrl}/${email}`;
    const url = `${this.usersUrl}/${id}`;

    return this.http.get<Utilizador>(url).pipe(
       catchError(this.handleError<Utilizador>(`getUser id=${id}`))
    );
  }

  getGame(id: number): Observable<Jogo> {
    const url = `${this.gamesUrl}/${id}`;

    return this.http.get<Jogo>(url).pipe(
      catchError(this.handleError<Jogo>('getGame id =${id}'))
    );
  }

  getJogos(): Observable<Jogo[]> {
    return this.http.get<Jogo[]>(this.gamesUrl)
      .pipe(
        catchError(this.handleError<Jogo[]>(`get Jogos`))
      );
  }

  getJogo( id : number): Observable<Jogo> {
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

  // getGameFromCat(categorias: String[]){
  //  ;
  // }

   private handleError<T> (operation = 'operation', result?: T) {
     return (error: any): Observable<T> => {
       console.error(error); // log to console instead
       return of( result as T );
     };
   }


}
