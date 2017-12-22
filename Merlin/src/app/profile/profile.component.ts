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
  user = {};
  stuff={};
  publicInfo = true;
  privateInfo = false;
  username:string;
  constructor(private getUserService: GetUserService, private getPrivateService: UserPrivateInfoService, private login: LoginService) { 
    
  }

  ngOnInit() {
    this.username = this.login.getUsername();
    this.getUserService.getUser(this.username).subscribe(resUser => this.user= resUser);
    this.getPrivateService.getPrivateInfo(this.username).subscribe(resPriv => this.stuff = resPriv);
  }

  viewPublicPrivate(){
    if(this.publicInfo ){
      this.publicInfo = false;
      this.privateInfo = true;
    }
    else{
      this.publicInfo = true;
      this.privateInfo = false;
    }
  }
}
