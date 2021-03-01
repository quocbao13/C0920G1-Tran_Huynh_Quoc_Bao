import { Injectable } from '@angular/core';
import {Customer} from './customer';
import {HttpClient} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Router} from '@angular/router';

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

  createCustomer(customer: Partial<Customer>): Observable<Customer> {
    return this.http.post<Customer>(this.API_URL, customer);
  }

  updateCustomer(customer: Customer): Observable<Customer> {
    return this.http.patch<Customer>(`${this.API_URL}/${customer.id}`, customer);
  }

  deleteCustomer(id: number): Observable<Customer> {
    return this.http.delete<Customer>(`${this.API_URL}/${id}`);
  }

  findByName(nameSearch: string, idSearch: string, customerType: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.API_URL + '?name_like=' + nameSearch + '&id_like='
      + idSearch + '&customerType.name=' + customerType);
  }

  sortByName(orderSort: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.API_URL + '?_sort=name&_order=' + orderSort);
  }
}
