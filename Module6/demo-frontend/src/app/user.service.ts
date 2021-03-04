import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly URL_API = 'http://localhost:8080/user';
  constructor(
    private http: HttpClient
  ) { }

  findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.URL_API);
  }
}
