import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CustomerRoutingModule} from './customer/customer-routing.module';
import {CustomerModule} from './customer/customer.module';
import { CustomerTypeComponent } from './customer-type/customer-type.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerTypeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    CustomerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
