import { Component } from '@angular/core';
import { RegistrationService } from '../../services/registration/registration.service';
import { PrivateUserInfo } from '../../models/private-user-info.model';
import { MagicalUser } from '../../models/magical-user.model';
import { CodeList } from '../../models/code-list.model';


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

  private usernameIsUnique : boolean

  constructor(private registerService : RegistrationService) { 
    this.usernameIsUnique = true;
  }

  register() {
    //check the user they submitted is unique
    var isUnique = this.registerService.isUniqueUsername(this.magicalUser.username) 

    if (isUnique) {
      this.registerService.register(this.privateUserInfo);
    } else {
      this.usernameIsUnique = false;
    }
  }
}