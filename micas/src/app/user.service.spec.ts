//<reference path="../../node_modules/@types/jasmine/index.d.ts"/>
import { TestBed, inject } from '@angular/core/testing';

import { UserService } from './user.service';

describe('InfoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserService ]
    });
  });

  it('should be created', inject([UserService], (service: UserService ) => {
    expect(service).toBeTruthy();
  }));
});
