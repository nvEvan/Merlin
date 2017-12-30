import { Component, ElementRef, AfterViewInit, ViewChild } from '@angular/core';
import { RegistrationService } from '../../services/registration/registration.service';
import { PrivateUserInfo } from '../../models/private-user-info.model';
import { MagicalUser } from '../../models/magical-user.model';
import { CodeList } from '../../models/code-list.model';
import { StateComponent } from '../codelist/state/state.component'
import { CityComponent } from '../codelist/city/city.component'
import { UserPrivateData } from '../../models/composite/user-private-data.composite';
import { Observable } from "rxjs/Observable";
import { Router } from '@angular/router';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';
import { CodeListService } from '../../services/codelist/codelist.service';

/**
 * Component for user registration
 * @author Alex
 */
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})



export class RegisterComponent implements OnInit {
  @ViewChild("citydiv") citySelect: ElementRef
  @ViewChild("statediv") stateSelect: ElementRef

  private magicalUser: MagicalUser
  private privateUserInfo: PrivateUserInfo
  private apprenticeData: UserPrivateData
  private city: string
  private state: string
  confirmPassword: string = ""

  showPasswordAlert: boolean = false
  showUsernameAlert: boolean = false

  roles: CodeList[]

  /**
   * Initialize the select option for user role
   */
  ngOnInit() {
    this.codeListService.getCodeListsByCode("USER-ROLE")
      .subscribe(response => {
        this.roles = response;
        this.roles.shift();
      })
  }

  constructor(private registerService: RegistrationService, private router: Router,
    private codeListService: CodeListService) {
    this.magicalUser = new MagicalUser()
    this.privateUserInfo = new PrivateUserInfo()
  }

  /**
   * Attempt to register the new user.
   */
  register(): void {
    let city = this.citySelect.nativeElement.children[0].children[0].value
    let state = this.stateSelect.nativeElement.children[0].children[0].value

    if (city == null || state == null)
      return

    //check if the user inputted a valid state/city combination
    this.codeListService.getStateCityCode(state, city).subscribe(
      data => {
        this.privateUserInfo.stateCity = data
      }
    )

    //check the user's info is ready to be registered
    if (this.allFieldsAreEntered() && !this.showUsernameAlert && !this.showPasswordAlert) {
      if (this.privateUserInfo.role.value.toString() == "APPRENTICE") { //register an apprentice account

        this.apprenticeData = new UserPrivateData()
        this.privateUserInfo.user = this.magicalUser
        this.apprenticeData.privateUserInfo = this.privateUserInfo
        this.apprenticeData.user = this.magicalUser

        console.log("registering the user")
        console.log(JSON.stringify(this.apprenticeData))
        this.registerService.registerApprentice(this.apprenticeData);

        this.router.navigate(['home'])
      }
    }
  }

  /**
   * Ensure that the user is registering a unique username
   */
  usernameIsUnique(): void {
    if (this.magicalUser.username != null && this.magicalUser.username.length > 0) {

      this.registerService.isUniqueUsername(this.magicalUser.username)
        .subscribe(data => {
          this.showUsernameAlert = !data
        })
    } else {
      this.showUsernameAlert = false
    }
  }

  /**
   * Check that the user's passwords match
   */
  passwordsMatch(): void {
    if (this.magicalUser.password == null || this.magicalUser.password.length < 1)
      this.showPasswordAlert = false

    this.showPasswordAlert = this.magicalUser.password != this.confirmPassword
  }

  /**
   * Check that all fields have been entered
   * @return true if all these cases are true
   */
  allFieldsAreEntered(): boolean {
    return this.privateUserInfo.address != null && this.privateUserInfo.email != null &&
      this.privateUserInfo.lastName != null && this.privateUserInfo.phoneNumber != null &&
      this.privateUserInfo.firstName != null && this.privateUserInfo.role != null &&
      this.privateUserInfo.stateCity != null
  }
}