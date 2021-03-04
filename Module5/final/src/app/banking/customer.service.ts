import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {Banking} from './banking';
import {Customer} from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private readonly API_URL = 'http://localhost:3000/customer';
  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  getCustomer(): Observable<Customer[]>{
    return this.http.get<Customer[]>(this.API_URL);
  }

  getCustomerById(id: number): Observable<Customer>{
    return this.http.get<Customer>(`${this.API_URL}/${id}`);
  }

  updateCustomer(customer: Customer): Observable<Customer> {
    return this.http.patch<Customer>(`${this.API_URL}/${customer.id}`, customer);
  }
}
