import { Component } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { Router } from '@angular/router';
import { GetUserService } from '../../services/get-user/get-user.service';
import { MagicalUser } from '../../models/magical-user.model';
import { UserPrivateData } from '../../models/composite/user-private-data.composite';
import { UserData } from '../../models/composite/user-data.composite';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {
  user: MagicalUser;
  userData: UserData;

  constructor(private router: Router, private login: LoginService, private getUserService: GetUserService) {
    this.user = new MagicalUser();
   }

  userLogin() { 

    this.getUserService.getLogin(this.user).subscribe(
      response => {
        this.userData = response.json();
        
        if(this.userData) {
          this.login.setUserData(this.userData);
          this.router.navigateByUrl('threads');
        } else {
          window.alert('Access Denied');
        }
      });
  }

}
