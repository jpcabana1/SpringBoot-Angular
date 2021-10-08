/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { TodoErroComponent } from './todo-erro.component';

describe('TodoErroComponent', () => {
  let component: TodoErroComponent;
  let fixture: ComponentFixture<TodoErroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TodoErroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TodoErroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
