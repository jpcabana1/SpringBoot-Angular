import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TodoService } from 'src/app/Services/todo-service/todo-service.service';

@Component({
  selector: 'app-todo-cad',
  templateUrl: './todo-cad.component.html',
  styleUrls: ['./todo-cad.component.css'],
})
export class TodoCadComponent implements OnInit {
  formTodo: FormGroup;

  constructor(private fb: FormBuilder, private todoService: TodoService) {
    this.formTodo = this.fb.group({
      desc: ['', Validators.required],
    });
  }
  ngOnInit(): void {
    console.log(this.formTodo.value);
  }

  onSubmit(): void {
    let desc = this.formTodo.get('desc')?.value;
    console.log(desc);
    this.todoService.createTodo(desc).subscribe(
      (resp: any) => {
        console.log(resp);
      },
      (err: any) => {
        console.log(err);
      }
    );
  }
}
