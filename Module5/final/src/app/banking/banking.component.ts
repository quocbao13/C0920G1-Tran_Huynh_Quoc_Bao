import { Component, OnInit } from '@angular/core';
import {Customer} from './customer';
import {Banking} from './banking';
import {CustomerService} from './customer.service';
import {BankingService} from './banking.service';

@Component({
  selector: 'app-banking',
  templateUrl: './banking.component.html',
  styleUrls: ['./banking.component.css']
})
export class BankingComponent implements OnInit {

  customers: Customer[] = [];
  bankingList: Banking[] = [];
  p = 0;
  idBanking: number;
  idSearch = '';
  nameCustomerSearch = '';
  constructor(private customerService: CustomerService, private bankingService: BankingService) { }

  ngOnInit(): void {
    this.bankingService.getBanking().subscribe(value => {
      this.bankingList = value;
    });
  }

  showDelete(id: number): void{
    this.idBanking = id;
  }

  delete(): void{
    this.bankingService.deleteBanking(this.idBanking).subscribe(value => {
      this.ngOnInit();
    });
  }

  search(): void{
    this.bankingService.find(this.idSearch, this.nameCustomerSearch).subscribe(value => {
      this.bankingList = value;
    });
  }
}
