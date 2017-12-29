import { Component } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { Router } from '@angular/router';
import { GetUserService } from '../../services/get-user/get-user.service';
import { MagicalUser } from '../../models/magical-user.model';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {

  user: MagicalUser;
  userInfo: any;

  constructor(private router: Router, private login: LoginService, private getUserService: GetUserService) {
    this.user = new MagicalUser();
   }

  userLogin() { 
    console.log(this.user);
    this.getUserService.getLogin(this.user).subscribe(
      response => {
        console.log(response.json());
        this.userInfo = response.json();
        if(this.userInfo){
          this.router.navigateByUrl('profile');
        } else {
          window.alert('Access Denied');
        }
      });
  }

}
