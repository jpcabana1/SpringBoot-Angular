import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { AbstractHandleError } from '../AbstractHandleError';

@Injectable({
  providedIn: 'root',
})
export class TodoServiceService extends AbstractHandleError {
  url: string = 'http://localhost:8080/newTodo';

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
      .post<any>(this.url, null, httpOptions)
      .pipe(retry(3), catchError(this.handleError));
  }
}
