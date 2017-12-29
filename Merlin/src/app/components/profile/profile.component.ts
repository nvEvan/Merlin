import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { GetUserService } from '../../services/get-user/get-user.service';
import { UserPrivateInfoService } from '../../services/user-private-info/user-private-info.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  ngOnInit() { }

}
