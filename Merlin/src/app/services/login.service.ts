import { Injectable } from '@angular/core';

@Injectable()
export class LoginService {

  constructor() { }

  login(username: string, password: string){
    if(username === "GB101" && password === "gg"){
      window.alert("Login Accepted")
    }
    else{
      window.alert("Access Denied");
    }
  }

}
