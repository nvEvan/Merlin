import { Component } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { Router } from '@angular/router';
import { GetUserService } from '../../services/get-user/get-user.service';
import { MagicalUser } from '../../models/magical-user.model';
import { shared } from '../../../shared/shared';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {
  user: MagicalUser;

  constructor(private router: Router, private login: LoginService, private getUserService: GetUserService) { 
    this.user = new MagicalUser();
  }

  userLogin() { 
    this.getUserService.getLogin(this.user).subscribe(data => {
      if (data) {
        debugger;
        var info = data.json().user;

        shared.data.info.general = new MagicalUser();
        shared.data.info.general.username = info.username;
        this.router.navigateByUrl('threads');
      }
    })
  }

}
