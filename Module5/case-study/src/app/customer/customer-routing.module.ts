import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {CustomerComponent} from './customer.component';
import {CustomerCreateComponent} from './customer-create/customer-create.component';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerEditComponent} from './customer-edit/customer-edit.component';

const routes: Routes = [
  {path: 'customer', component: CustomerComponent,
    children: [
      {path: 'create', component: CustomerCreateComponent},
      {path: '', component: CustomerListComponent},
      {path: 'edit/:id', component: CustomerEditComponent}
      ]
  },
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class CustomerRoutingModule { }
