import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';
import {CustomerService} from '../customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[] = [];
  p = 1;
  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.customerService.getCustomer()
      .subscribe((value) => {
        this.customers = value;
      });
  }

  delete(id: number): void{
    this.customerService.deleteCustomer(id);
    this.ngOnInit();
  }

  searchName(nameSearch: string): void{
    this.customerService.findByName(nameSearch).subscribe(value => {
      this.customers = value;
    });
  }
}
