import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import 'rxjs/add/operator/map';
import { environment } from '../../../environments/environment'
import { MagicalUser } from '../../models/magical-user.model';

@Injectable()
export class UserPrivateInfoService {

  constructor(private http: Http) { }

  getPrivateInfo(username: string) {
    return this.http.get(environment.url + 'user/get/private/' + username).
      map((response: Response) => response.json());
  }

  /**
   * Get all unverified adepts
   */
  getUnverifiedAdepts() {
    return this.http.get(environment.url + 'wizard/unverified_adepts').
      map((response: Response) => response.json());
  }

  /**
   * Verify the adept
   */
  verifyAdept(username: string) {
    var user : MagicalUser = new MagicalUser()
    user.username = username

    //send the request
    return this.http.put(environment.url + 'wizard/verify_adept/', user)
  }
}