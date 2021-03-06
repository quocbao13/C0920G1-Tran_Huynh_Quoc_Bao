import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerComponent } from './customer.component';
import { CustomerCreateComponent } from './customer-create/customer-create.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CustomerRoutingModule} from './customer-routing.module';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { CustomerDetailComponent } from './customer-detail/customer-detail.component';
import {NgxSortableModule} from 'ngx-sortable';



@NgModule({
  declarations: [CustomerComponent, CustomerCreateComponent, CustomerListComponent, CustomerEditComponent, CustomerDetailComponent],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        FormsModule,
        CustomerRoutingModule,
        HttpClientModule,
        RouterModule,
        NgxPaginationModule,
        NgxSortableModule
    ]
})
export class CustomerModule { }
