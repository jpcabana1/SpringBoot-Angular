import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/DTO/todo.model';
import { TodoService } from 'src/app/Services/todo-service/todo-service.service';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css'],
})
export class TodoListComponent implements OnInit {

  lista : Todo[];
  
  constructor(private todoService : TodoService) {
    this.lista = [];
  }

  ngOnInit() {
    this.todoService.getTodos().subscribe(
      (resp: Todo[]) =>{
          this.lista = [...resp]
      },
      (err : any) =>{
        console.log(err);
      }
    )
  }
}
