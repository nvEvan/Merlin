import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { UserData } from '../../models/composite/user-data.composite';
import { environment } from '../../../environments/environment'
@Injectable()
export class EditUserInfoService {

  constructor(private http: Http) { }

  save(userData: UserData){
    this.http.post(environment.url + 'Edit/MagicalPrivateInfo', userData).subscribe();
  }

}
