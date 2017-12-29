import { Component } from '@angular/core';
import { RegistrationService } from '../../services/registration/registration.service';
import { PrivateUserInfo } from '../../models/private-user-info.model';
import { MagicalUser } from '../../models/magical-user.model';
import { CodeList } from '../../models/code-list.model';
import { StateComponent } from '../codelist/state/state.component'
import { CityComponent } from '../codelist/city/city.component'

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent  {
  private magicalUser : MagicalUser
  private privateUserInfo : PrivateUserInfo;
  private city : string
  private state : string

  private usernameIsUnique : boolean //a flag used to tell the user a username has been taken

  constructor(private registerService : RegistrationService) { 
    this.usernameIsUnique = true;
    this.magicalUser = new MagicalUser("", "")
    this.privateUserInfo = new PrivateUserInfo(this.magicalUser, null, null, null, "", "",
                                                 "", "", "");
  }

  register() {
    //check the user they submitted is unique
    var isUnique = this.registerService.isUniqueUsername(this.magicalUser.username) 

    if (isUnique) {
      this.usernameIsUnique = true;
      this.registerService.register(this.privateUserInfo);
    } else {
      this.usernameIsUnique = false;
    }
  }
}