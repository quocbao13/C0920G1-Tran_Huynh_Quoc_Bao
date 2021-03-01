import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../customer.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Customer} from '../customer';
import {CustomerType} from '../../customer-type/customer-type';
import {CustomerTypeService} from '../../customer-type/customer-type.service';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  customerForm: FormGroup;
  customer: Customer;
  customerTypes: CustomerType[];

  constructor(
    private customerService: CustomerService,
    private fb: FormBuilder,
    private router: Router,
    private customerTypeService: CustomerTypeService
  ) {
  }

  ngOnInit(): void {
    this.customerTypeService.getCustomer().subscribe(value => {
      this.customerTypes = value;
      console.log(this.customerTypes);
    });
    this.customerForm = this.fb.group({
      customerType: ['', [Validators.required]],
      name: ['', [Validators.required]],
      dayOfBirth: ['', [Validators.required]],
      idCard: ['', [Validators.required]],
      phone: ['', [Validators.required]],
      email: ['', [Validators.required]],
      address: ['', [Validators.required]]
    });
  }

  createCustomer(): void {
    console.log(this.customerForm.value);
    this.customerService.createCustomer(this.customerForm.value).subscribe(value => {
    });
    this.router.navigate(['/customer']);
  }

}
