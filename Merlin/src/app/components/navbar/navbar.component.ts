import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login/login.service';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
  
export class NavbarComponent implements OnInit {

  username:string;

  constructor(private router: Router, private login: LoginService){}

  ngOnInit(){  }

  signout(){
    this.login.logout();
    this.router.navigateByUrl('home');
  }
}
