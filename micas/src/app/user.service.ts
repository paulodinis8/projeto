import { Injectable } from '@angular/core';
import { Utilizador } from './utilizador';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';


@Injectable()
export class UserService {
  user : Utilizador;

  getUser(id: number): Observable<Utilizador> {
    return of(this.user);
  }

  constructor() { }

}
