import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {Banking} from './banking';

@Injectable({
  providedIn: 'root'
})
export class BankingService {

  private readonly API_URL = 'http://localhost:3000/banking';
  constructor(
    private http: HttpClient,
    private router: Router
  ) { }

  getBanking(): Observable<Banking[]>{
    return this.http.get<Banking[]>(this.API_URL);
  }

  getBankingById(id: number): Observable<Banking>{
    return this.http.get<Banking>(`${this.API_URL}/${id}`);
  }

  createBanking(banking: Partial<Banking>): Observable<Banking> {
    return this.http.post<Banking>(this.API_URL, banking);
  }

  updateBanking(banking: Banking): Observable<Banking> {
    return this.http.patch<Banking>(`${this.API_URL}/${banking.id}`, banking);
  }

  deleteBanking(id: number): Observable<Banking> {
    return this.http.delete<Banking>(`${this.API_URL}/${id}`);
  }

  find(idSearch: string, nameCustomerSearch: string): Observable<Banking[]> {
    return this.http.get<Banking[]>(this.API_URL + '?customer.name_like=' + nameCustomerSearch + '&id_like=' + idSearch);
  }
}
