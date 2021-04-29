import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RequestComponent } from './request/request.component';
import { CustomerComponent } from './customer/customer.component';
import { NavigationComponent } from './navigation/navigation.component';
import { Router, RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { TechnicianComponent } from './technician/technician.component';
import { AddressComponent } from './address/address.component';


const appRoutes: Routes = [
  {
    path: 'customer',
    component: CustomerComponent
  },
  {
    path: 'technician',
    component: TechnicianComponent
  },
  {
    path: 'request',
    component: RequestComponent

  },
  {
    path: 'address',
    component: AddressComponent
  }
];


@NgModule({
  declarations: [
    AppComponent,
    RequestComponent,
    CustomerComponent,
    NavigationComponent,
    TechnicianComponent,
    AddressComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes, { enableTracing: true })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
