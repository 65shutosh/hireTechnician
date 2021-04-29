import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.css']
})
export class AddressComponent implements OnInit {

  model : AddressModel={
    locality:'',
    city:'',
    zip : 0,
    landMark:'',
    customerId:0
  };

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

sendAddress(customerId :number):void{
let url = "http://localhost:8080/newAddress/"
this.http.post(url+customerId,this.model).subscribe(
res => {
  alert("success in adding new address");
  location.reload();
},
err=>{
alert("There is some error giving new address");
}
);
}

getAllAddresses():void{
  let url="http://localhost:8080/getAddresses";
  this.http.get(url).subscribe(
    data=>{
      alert(data);
      console.log(data);
    },
    error=>{
      alert("some problem");
    }
    );
}


}

export interface AddressModel{
  locality:String;
  city:String;
  zip:number;
  landMark:string;
  customerId:number;
}