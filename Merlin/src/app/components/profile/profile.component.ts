import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { UserPrivateData } from '../../models/composite/user-private-data.composite';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  userData: UserPrivateData;
  
  constructor(private loginService: LoginService){  }

  ngOnInit() {
    this.userData = this.loginService.getUser();
   }

}
