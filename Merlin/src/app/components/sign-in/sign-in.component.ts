import { Component } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { Router } from '@angular/router';
import { GetUserService } from '../../services/get-user/get-user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {

  private user = {
    password: null,
    userId: null,
    username: null
  };
  private username: string;
  private password: string;

  constructor(private router: Router, private login: LoginService, private getUserService: GetUserService) { }

  userLogin() { 
    // Obtains a user based on username
    this.getUserService.getLogin(this.username).subscribe( data => {
      
      // Assign the js object to our user object
      this.user = data.json();

      // If the user is valid then the login service stores the username and reroutes to profile page
      // Otherwise the user is shown a window telling them they are denied access.
      if(this.user.username === this.username && this.user.password === this.password){
        this.login.setUsername(this.username);
        this.router.navigateByUrl('profile');
      }
      else{
        window.alert('Access Denied');
      }
    });
  }

}
