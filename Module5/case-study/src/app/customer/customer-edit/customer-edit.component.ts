import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../customer.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {Customer} from '../customer';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customerFormEdit: FormGroup;

  constructor(
    private fb: FormBuilder,
    private customerService: CustomerService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const customerId = Number(this.activatedRoute.snapshot.params.id);
    this.customerService.getCustomerById(customerId).subscribe(value => {
      this.customerFormEdit = this.fb.group({
        id: [value.id, [Validators.required]],
        idCustomerType: [value.idCustomerType, [Validators.required]],
        name: [value.name, [Validators.required]],
        dayOfBirth: [value.dayOfBirth, [Validators.required]],
        idCard: [value.idCard, [Validators.required]],
        phone: [value.phone, [Validators.required]],
        email: [value.email, [Validators.required]],
        address: [value.address, [Validators.required]]
      });
    });
  }

  editInfoCustomer(){
    console.log(this.customerFormEdit.value);
    this.customerService.updateCustomer(this.customerFormEdit.value).subscribe(value => {});
    this.router.navigate(['/customer']);
  }
}
