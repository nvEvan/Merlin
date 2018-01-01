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
import { OnInit, OnChanges } from '@angular/core/src/metadata/lifecycle_hooks';
import { CodeListService } from '../../services/codelist/codelist.service';
import { MagicalFileUpload } from '../../models/magical-file-upload.model';
import { environment } from '../../../environments/environment';
import { Http, Headers, RequestOptions } from '@angular/http/';

/**
 * Component for user registration
 * @author Alex
 */
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

/**
 * Holds all data for apprentice and adept registration.
 * And contains registration page error handling.
 */
export class RegisterComponent implements OnInit, OnChanges {
  @ViewChild("citydiv") citySelect: ElementRef
  @ViewChild("statediv") stateSelect: ElementRef
  @ViewChild('uploadForm') form: ElementRef;

  private magicalUser: MagicalUser
  private privateUserInfo: PrivateUserInfo
  private registerData: UserPrivateData
  private formData: FormData;

  confirmPassword: string = ""
  loading: boolean = true
  url: string;
  showPasswordAlert: boolean = false
  showUsernameAlert: boolean = false
  showStateCityAlert: boolean = false
  fieldsAreBlank: boolean = false
  adeptAccount: boolean = false

  roles: CodeList[]

  /**
   * Initialize the select option for user role
   */
  ngOnInit() {
    this.codeListService.getCodeListsByCode("USER-ROLE")
      .subscribe(response => {
        this.roles = response
        this.roles.shift() //removes the wizard role
        this.loading = false
      });

      window.dispatchEvent(new Event('resize'));
  }

  ngOnChanges(changes) {
    let city = this.citySelect.nativeElement.children[0].children[0].value
    let state = this.stateSelect.nativeElement.children[0].children[0].value
  }

  constructor(private registerService: RegistrationService, private router: Router, private http: Http,
    private codeListService: CodeListService) {
    this.registerData = new UserPrivateData()

    this.magicalUser = new MagicalUser()
    this.privateUserInfo = new PrivateUserInfo()
    this.privateUserInfo.user = this.magicalUser

    //for registering apprentices
    this.registerData.privateUserInfo = this.privateUserInfo
    this.registerData.user = this.magicalUser

    this.url = environment.url;
  }

  /**
   * Attempt to register the new user.
   */
  register(): void {
    //check the user's info is ready to be registered
    if (this.allFieldsAreEntered() && !this.showUsernameAlert && !this.showPasswordAlert) {
      if (this.privateUserInfo.role.value.toString() == "APPRENTICE") { //register an apprentice account
        this.registerService.registerApprentice(this.registerData);
      } else {
        this.registerService.registerAdept(this.registerData, this.formData);
      }
      this.router.navigate(['home'])
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
    this.showPasswordAlert = this.magicalUser.password != this.confirmPassword
  }

  /**
   * Check that all fields have been entered
   * @return true if all these cases are true
   */
  allFieldsAreEntered(): boolean {
    let allFieldsAreEntered: boolean = this.privateUserInfo.address != null &&
      this.privateUserInfo.email != null && this.privateUserInfo.lastName != null &&
      this.privateUserInfo.phoneNumber != null && this.privateUserInfo.firstName != null &&
      this.privateUserInfo.role != null && this.privateUserInfo.stateCity != null &&
      this.magicalUser.password != null
       
    if (!allFieldsAreEntered) return false
    //if the user registering is an adept they must provide a file of certification
    if (this.privateUserInfo.role.id == 434)
      allFieldsAreEntered = allFieldsAreEntered && this.formData != null

    this.fieldsAreBlank = !allFieldsAreEntered
    
    return allFieldsAreEntered
  }

  /**
   * Confirm that the city and state selected are a match.
   */
  checkCityState(): void {
    let city = this.citySelect.nativeElement.children[0].children[0].value
    let state = this.stateSelect.nativeElement.children[0].children[0].value

    if (city == null || state == null)
      return

    //check if the user inputted a valid state/city combination
    this.codeListService.getStateCityCode(state, city).subscribe(
      data => {
        this.privateUserInfo.stateCity = data
        this.showStateCityAlert = data == null
      }
    )
  }

  /**
   * Listens for a user selecting their role.
   */
  roleChange(): void {
    let role = this.privateUserInfo.role
    if (role != null) {
      this.adeptAccount = this.privateUserInfo.role.id == 434
    }
  }

  /**
   * React to the adept uploading a file
   */
  fileChange(event): void {
    let file = event.target.files[0];
    let headers = new Headers();
    let options = new RequestOptions({ headers: headers });

    if (file == null)
      return;

    this.formData = new FormData();
    this.formData.append("form[]", file, file.name);
  }

  onResize(event, box) {
    var target = event.target;
    var height = target.innerHeight;
    
    box.style.height = height + "px";
  }

}