import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login/login.service';
import { DropdownDirective } from '../../directives/dropdown/dropdown.directive';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
  
export class NavbarComponent implements OnInit {
  username: string;
  isWizard: boolean;

  constructor(private router: Router, private login: LoginService){
    this.username = this.login.getUserData().user.username;
    this.isWizard = this.login.getUserData().privateUserInfo.role.id == 433;
  }

  ngOnInit(){  }

  signout(){
    this.login.logout();
    this.router.navigateByUrl('home');
  }
}
