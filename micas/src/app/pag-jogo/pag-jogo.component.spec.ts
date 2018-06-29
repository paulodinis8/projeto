import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {PagJogoComponent} from './pag-jogo.component';

describe('PagJogoComponent', () => {
  let component: PagJogoComponent;
  let fixture: ComponentFixture<PagJogoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [PagJogoComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PagJogoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
