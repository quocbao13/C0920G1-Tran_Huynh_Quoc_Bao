import { Component, OnInit } from '@angular/core';
import {Customer} from '../customer';
import {CustomerService} from '../customer.service';
import {CustomerType} from '../../customer-type/customer-type';
import {CustomerTypeService} from '../../customer-type/customer-type.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[] = [];
  customerTypes: CustomerType[] = [];
  idCus: number;
  p = 1;
  checkClick = true;
  nameSearch = '';
  idSearch = '';
  customerType = '';
  constructor(private customerService: CustomerService, private  customerTypeService: CustomerTypeService) {
  }

  ngOnInit(): void {
    this.customerService.getCustomer()
      .subscribe((value) => {
        this.customers = value;
      });
    this.customerTypeService.getCustomer()
      .subscribe(value => {
        this.customerTypes = value;
      });
  }

  showDelete(id: number): void{
    this.idCus = id;
  }

  delete(): void{
    this.customerService.deleteCustomer(this.idCus).subscribe(value => {
      this.ngOnInit();
    });
  }

  search(): void{
    console.log(this.customerType);
    this.customerService.findByName(this.nameSearch, this.idSearch, this.customerType).subscribe(value => {
      this.customers = value;
    });
  }

  sortName(): void{
    const asc = 'asc';
    const desc = 'desc';
    if (this.checkClick){
      this.customerService.sortByName(asc).subscribe(value => {
        this.customers = value;
      });
      this.checkClick = false;
    } else {
      this.customerService.sortByName(desc).subscribe(value => {
        this.customers = value;
      });
      this.checkClick = true;
    }
  }
}
