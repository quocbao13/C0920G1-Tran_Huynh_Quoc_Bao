import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CustomerRoutingModule} from './customer/customer-routing.module';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
