import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Routes, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { TodoNavbarComponent } from './components/todo-navbar/todo-navbar.component';
import { TodoListComponent } from './components/todo-list/todo-list.component';
import { TodoCadComponent } from './components/todo-cad/todo-cad.component';
import { TodoErroComponent } from './components/todo-erro/todo-erro.component';

import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';

const routes: Routes = [
  { path: 'list', component: TodoListComponent },
  { path: 'cad', component: TodoCadComponent },
  { path: '', component: TodoListComponent },
  { path: '**', component: TodoErroComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    TodoNavbarComponent,
    TodoListComponent,
    TodoCadComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
