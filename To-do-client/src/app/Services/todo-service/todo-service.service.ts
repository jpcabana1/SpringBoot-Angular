import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Todo } from 'src/app/DTO/todo.model';
import { AbstractHandleError } from '../AbstractHandleError';

@Injectable({
  providedIn: 'root',
})
export class TodoService extends AbstractHandleError {
  url: string = 'http://localhost:8080/';

  constructor(private http: HttpClient) {
    super();
  }

  createTodo(desc: string): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        desc: desc,
      }),
    };

    return this.http
      .post<any>(this.url + 'newTodo', null, httpOptions)
      .pipe(catchError(this.handleError));
  }

  getTodos(): Observable<Todo[]> {
    return this.http
      .get<Todo[]>(this.url + 'getTodos')
      .pipe(retry(3), catchError(this.handleError));
  }
}
