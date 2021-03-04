import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {BankingService} from '../banking.service';
import {Customer} from '../customer';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  bankingForm: FormGroup;
  customers: Customer[];
  idCustomer: number;
  nameCustomer: string;
  customer: Customer;
  constructor(
    private fb: FormBuilder,
    private customerService: CustomerService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private bankingService: BankingService
  ) { }

  ngOnInit(): void {
    const bankingId = Number(this.activatedRoute.snapshot.params.id);
    this.bankingForm = this.fb.group({
      id: ['', [Validators.required]],
      customer: ['', [Validators.required]],
      dayOpen: ['', [Validators.required]],
      dayStart: ['', [Validators.required]],
      time: ['', [Validators.required, Validators.pattern('[3,6,1,5,0]')]],
      money: ['', [Validators.required, Validators.min(1000000)]],
      moneyFree: ['', [Validators.required]],
      sale: ['', [Validators.required]]
    });
    this.customerService.getCustomer().subscribe(value1 => {
      this.customers = value1;
    });
    this.bankingService.getBankingById(bankingId).subscribe(value => {
      this.bankingForm.patchValue(value);
      this.idCustomer = this.bankingForm.controls.customer.value.id;
      this.nameCustomer = this.bankingForm.controls.customer.value.name;
    });
  }

  changeNameCustomer(name: string){
    this.nameCustomer = name;
  }

  editInfoBanking(){
    this.bankingService.updateBanking(this.bankingForm.value).subscribe(value => {});
    this.router.navigate(['/banking']);
  }
}
