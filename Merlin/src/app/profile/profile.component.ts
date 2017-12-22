import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import { GetUserService } from '../services/get-user.service';
import { UserPrivateInfoService } from '../services/user-private-info.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user = {
    'username':  '',
    'firstName': '',
    'lastName': ''
  };
  
  privateInfo = {
    'email': '',
    'phone': '',
    'address': '',
    'city': '',
    'state': ''
  };
  
  isPublicInfo = true;
  isPrivateInfo = false;
  
  username: string;
  constructor(private getUserService: GetUserService, private getPrivateService: UserPrivateInfoService, private login: LoginService) { 
    
  }

  ngOnInit() {
    this.username = this.login.getUsername();
    this.getUserService.getUser(this.username).subscribe(resUser => this.user = resUser);
    this.getPrivateService.getPrivateInfo(this.username).subscribe(resPriv => this.privateInfo = resPriv);
  }

  viewPublicPrivate() {
    if (this.isPublicInfo) {
      this.isPublicInfo = false;
      this.isPrivateInfo = true;
    } else {
      this.isPublicInfo = true;
      this.isPrivateInfo = false;
    }
  }
}
