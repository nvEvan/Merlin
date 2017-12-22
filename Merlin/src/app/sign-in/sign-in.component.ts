import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';
import { UserPrivateInfoService } from '../services/user-private-info.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  info = {};
  username:string;
  password:string;

  constructor(private router: Router, private login: LoginService, private getUserInfo: UserPrivateInfoService) { }

  ngOnInit() {
  }

  userLogin(){
    this.getUserInfo.getPrivateInfo(this.username).subscribe(rInfo => this.info = rInfo);
    
    console.log(this.info);
    console.log(this.info);
    if(this.info.password === this.password){
      this.login.setUsername(this.username);
      this.router.navigateByUrl('profile');
      
    }
    else{
      console.log('false');
    }
    //this.router.navigateByUrl("profile");
    //   
    // }
    // else{
    //   window.alert("You shall not pass!");
    // }

  }

}
