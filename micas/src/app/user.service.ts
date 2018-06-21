import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

import { Utilizador } from './utilizador';
import { Jogo } from './jogo';



@Injectable()

export class UserService {

  private usersUrl = 'localhost:8080/utilizador'; // URL to web api
  private gamesUrl = 'localhost:8080/jogo';

  constructor( private http: HttpClient ) { }

  getUser(id: number): Observable<Utilizador> {
    const url = `${this.usersUrl}/${id}`;

    return this.http.get<Utilizador>(url)
      .pipe(
        catchError(this.handleError<Utilizador>(`getUser id=${id}`))
      );
  }

  getGame(id: number): Observable<Jogo> {
    const url = `${this.gamesUrl}/${id}`;

    return this.http.get<Jogo>(url)
      .pipe(
        catchError(this.handleError<Jogo>(`getGame id=${id}`))
      );
  }

  getGameFromCat( categorias: String[]){
    ;
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error); // log to console instead
      return of( result as T );
    };
  }


}
