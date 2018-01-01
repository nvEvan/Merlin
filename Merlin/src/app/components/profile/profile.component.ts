import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { UserPrivateData } from '../../models/composite/user-private-data.composite';
import { UserData } from '../../models/composite/user-data.composite';
import { EditUserInfoService } from '../../services/edit-user-info/edit-user-info.service';
import { PublicUserInfo } from '../../models/public-user-info.model';
import { PrivateUserInfo } from '../../models/private-user-info.model';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userData: UserData;
  edit: boolean;

  constructor(private loginService: LoginService, private editUserInfoService: EditUserInfoService){  }

  ngOnInit() {
    this.userData = this.loginService.getUserData();
    this.edit = false;

    if(!this.userData.publicInfo){
      this.userData.publicInfo = new PublicUserInfo();
    }
   }

   editView(){
     if(this.edit) {
       this.edit = false;
     } else {
       this.edit = true;
     }
   }

   save(){
     this.editUserInfoService.save(this.userData);
     this.editView();
   }

}
