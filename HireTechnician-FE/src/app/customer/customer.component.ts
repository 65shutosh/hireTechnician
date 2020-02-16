import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  url = "http://localhost:8080/customer/";

  model : customerModel={
    customerId:0,
    name:'',
    contactNumber:'',
    email:''
  };

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  //getting all address of a customer using customer Id
getAllAddressesOfACustomer(customerId:number): void{
  this.http.get(this.url+customerId+'/addresses').subscribe(
    data=>{
      console.log(data);
      alert("you can check data in browser console");
    },
    err=>{
      alert("some problem occured");
    }
  );
}

//updating customer contactInformation
updateCustomerContactInformation(customerId:number):void{
  this.http.put(this.url+customerId+'/updateContactNumber',this.model.contactNumber).subscribe(
    res=>{
      alert("Your Contact number is updated");
    },
    err=>{
      alert("contact updation failed");
    }
  );
}

// new customer registration
newCustomerRegistration():void{
  this.http.post(this.url+'newCustomer',this.model).subscribe(
res=>{
alert("You are now registered as a customer");
},
err=>{
alert("registration failed");
}
  );
}

//add new address
addNewAddress(customerId:number):void{
  location.href = "http://localhost:4200/address";
}


}

export interface customerModel{
  customerId:number;
  name:String;
  contactNumber:String;
  email:string;
}
