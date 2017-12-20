import { Component, OnInit } from '@angular/core';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  username:string;
  password:string;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  userLogin(){
    if(this.username === "GreyBeard" && this.password === "wizard"){
      this.router.navigateByUrl("profile");
    }
    else{
      window.alert("You just took an arrow to the knee!");
    }
  }

}
