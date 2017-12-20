import { Component, OnInit } from '@angular/core';
import { userPublicInfo } from '../models/user-public-info';
import { userPirvateInfo } from '../models/user-private-info';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  username:string;
  userId:string;
  fname:string;
  lname:string;
  address:string;
  city:string;
  state:string;
  email: string;
  phone: string;

  constructor(private userPublic: userPublicInfo, private userPrivate: userPirvateInfo) {
    userPublic = new userPublicInfo();
    userPrivate = new userPirvateInfo();
    userPublic.fname="Gandalf";
    userPublic.lname="Grey";
    userPublic.userId="GreyBeard";
    userPublic.username="GB101";

    userPrivate.address = "Somewhere";
    userPrivate.city = "Dont Remember";
    userPrivate.email="greybeard@wizards.com";
    userPrivate.phone="911";
    userPrivate.state="No Clue";
    userPrivate.userId="GreyBeard";
    userPrivate.username="GB101";

    

   }

  ngOnInit() {
    this.username = this.userPublic.username.toString();
    this.userId = this.userPublic.userId.toString();
    this.fname = this.userPublic.fname.toString();
    this.lname = this.userPublic.lname.toString();
    this.address = this.userPrivate.address.toString();
    this.city = this.userPrivate.city.toString();
    this.state = this.userPrivate.state.toString();
    this.email = this.userPrivate.email.toString();
    this.phone = this.userPrivate.phone.toString();
  }

}
