import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../customer.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerTypeService} from '../../customer-type/customer-type.service';
import {CustomerType} from '../../customer-type/customer-type';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customerFormEdit: FormGroup;
  customerTypes: CustomerType[];

  constructor(
    private fb: FormBuilder,
    private customerService: CustomerService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private customerTypeService: CustomerTypeService
  ) { }

  ngOnInit(): void {
    const customerId = Number(this.activatedRoute.snapshot.params.id);
    this.customerFormEdit = this.fb.group({
      id: ['', [Validators.required]],
      customerType: ['', [Validators.required]],
      name: ['', [Validators.required]],
      dayOfBirth: ['', [Validators.required]],
      idCard: ['', [Validators.required]],
      phone: ['', [Validators.required]],
      email: ['', [Validators.required]],
      address: ['', [Validators.required]]
    });
    this.customerTypeService.getCustomer().subscribe(value1 => {
      this.customerTypes = value1;
    });
    this.customerService.getCustomerById(customerId).subscribe(value => {
      this.customerFormEdit.patchValue(value);
    });
  }

  editInfoCustomer(){
    console.log(this.customerFormEdit.value);
    this.customerService.updateCustomer(this.customerFormEdit.value).subscribe(value => {});
    this.router.navigate(['/customer']);
  }
}
