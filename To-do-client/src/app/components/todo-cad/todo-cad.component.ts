import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-todo-cad',
  templateUrl: './todo-cad.component.html',
  styleUrls: ['./todo-cad.component.css'],
})
export class TodoCadComponent {
  formTodo: FormGroup;

  constructor(private fb: FormBuilder) {
    this.formTodo = this.fb.group({
      desc: ['', Validators.required],
    });
  }

  onSubmit(): void {
    console.log('submit');
  }
}
