import {Component, OnInit} from '@angular/core';
import {CustomerService} from '../customer.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {Customer} from '../customer';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  customerForm: FormGroup;
  customer: Customer;

  constructor(
    private customerService: CustomerService,
    private fb: FormBuilder,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.customerForm = this.fb.group({
      idCustomerType: ['', [Validators.required]],
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
    }).unsubscribe();
    this.router.navigate(['/customer']);
  }

}
