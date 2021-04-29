import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {

  url = "http://localhost:8080/request/";

  model: requestModel={
    serviceTaken:''
  };

  model2 : data={
    customerId:0,
    addressId:0
  }

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  //Requesting New Service
  requestForService(customerId:number,addressId:number):void{
   // const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    this.http.post(this.url+'new/customer/'+customerId+'/address/'+addressId,this.model,{responseType:'test' as 'json'}).subscribe(
      res=>{
        alert(res);
        console.log(res.toString);
      },
      err=>{
        console.log(err);
        alert("creating new request failed");
      }
    );

  }

  //All pending Requests
  pendingRequest():void{
    this.http.get(this.url+'pending').subscribe(
      res=>{
        console.log(res);
        alert("check browser console to check pending data");
      },
      err=>{
        alert("checking pending requestes failed");
      }
    );
  }


}

export interface requestModel{
  serviceTaken:String;
}

export interface data{
  customerId:number;
  addressId:number;
}
