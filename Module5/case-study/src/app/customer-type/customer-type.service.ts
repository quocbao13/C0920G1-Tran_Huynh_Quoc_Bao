import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {CustomerType} from './customer-type';

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {

  private readonly API_URL = 'http://localhost:3000/customer-type';
  constructor(
    private http: HttpClient
  ) { }
  getCustomer(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(this.API_URL)
      // .pipe(
      //   // khi thanh cong
      //   tap(x => console.log('oke')),
      //   // Khi that bai
      //   catchError(err => of([]))
      // )
      ;
  }
}
