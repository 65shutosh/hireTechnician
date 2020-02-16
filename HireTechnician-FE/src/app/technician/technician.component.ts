import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-technician',
  templateUrl: './technician.component.html',
  styleUrls: ['./technician.component.css']
})
export class TechnicianComponent implements OnInit {

  url = "http://localhost:8080/technician/"

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  model : technicianModel={
    technicianId:0,
    name:'',
    contactNumber:'',
    email:'',
    govID:'',
    address :{
      locality:'',
      city:'',
       zip:0,
       landMark:''
    }
  };
  
  // registering new Technician
  newTechnicianRegistration():void{
    this.http.post(this.url+'new',this.model).subscribe(
      res=>{
        alert("your registration is successFull");
      },
      err=>{
        alert("Registration failed");
      }
    );
  }


  //updating Technician contact Information
  updateTechnicianContactInformation(technicianId:number):void{
    this.http.put(this.url+technicianId+'/updateContactNumber',this.model.contactNumber).subscribe(
      res=>{
        alert("contact updated");
      },
      err=>{
        alert("contact updation failed");
      }
    );
  }

  //check availability status of technician
  checkAvailabilityStatus(technicianId:number):void{
    this.http.get(this.url+'availability/'+technicianId).subscribe(
      res=>{
        if(res==true)
        alert("you are currently available for work");
        else
        alert("you are currently Unavailable for work");
      },
      err=>{
        alert("availability check failed");
      }
    );
  }

 //change Availability Status to available
  makeStatusAsAvailable(technicianId:number):void{
    this.http.put(this.url+'available/'+technicianId,null).subscribe(
    res=>{
      console.log(res);
      if(res==true)
      alert("Now You are available for any new request of service");
      else
      alert("now you are unavialable");
    },
    err=>{
      alert("availability change failed");
    }
  );
  }

//change availability status to Unavailable
makeStatusAsUnavailable(technicianId:number):void{
  this.http.put(this.url+'unavailable/'+technicianId,null).subscribe(
    res=>{
      console.log(res);
      if(res==true)
      alert("Now You are available for any new request of service");
      else
      alert("now you are Unavialable and unless you make your self available no new work will be assigned to you");
    },
    err=>{
      alert("availability change failed");
    }
  );
}



}

export interface AddressModel{
  locality:String;
  city:String;
  zip:number;
  landMark:string;
}

export interface technicianModel{
  technicianId:number;
  name:String;
  contactNumber:String;
  email:string;
  govID:String;
  address:AddressModel;
}