import { Component, OnInit } from '@angular/core';
import { userPublicInfo } from '../models/user-public-info';
import { userPirvateInfo } from '../models/user-private-info';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userPublic: userPublicInfo;
  userPrivate: userPirvateInfo;
  publicInfo: boolean;
  privateInfo: boolean;
  // username:string;
  // userId:string;
  // fname:string;
  // lname:string;
  // address:string;
  // city:string;
  // state:string;
  // email: string;
  // phone: string;

  constructor() { 
    this.publicInfo = true;
    this.privateInfo = false;
  }

  ngOnInit(userPublic= new userPublicInfo, userPrivate = new userPirvateInfo) {
    this.userPublic = new userPublicInfo();
    this.userPrivate = new userPirvateInfo();
    this.userPublic.fname="Gandalf";
    this.userPublic.lname="Grey";
    this.userPublic.userId="GreyBeard";
    this.userPublic.username="GB101";

    this.userPrivate.address = "Somewhere";
    this.userPrivate.city = "Dont Remember";
    this.userPrivate.email="greybeard@wizards.com";
    this.userPrivate.phone="911";
    this.userPrivate.state="No Clue";
    this.userPrivate.userId="GreyBeard";
    this.userPrivate.username="GB101";

  }
// new code below...
  viewPublic(){
    if(this.publicInfo){
      this.publicInfo = false;
    }
    else{
      this.publicInfo= true;
    }
  }

  viewPrivate(){
    if(this.privateInfo){
      this.privateInfo = false;
    }
    else{
      this.privateInfo= true;
    }
  }

}
