import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListajogosComponent } from './listajogos.component';

describe('ListajogosComponent', () => {
  let component: ListajogosComponent;
  let fixture: ComponentFixture<ListajogosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListajogosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListajogosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
