import { Injectable } from "@angular/core";
import { PrivateUserInfo } from "../../models/private-user-info.model"
import { Http } from "@angular/http";

@Injectable()
export class RegistrationService {

    constructor(private http : Http) { }

    //register the user
    register(privateUserInfo : PrivateUserInfo) {
        this.http.post('http://localhost:8085/merlinserver/rest/register/create/', privateUserInfo);
    }

    //check the user registering is using a new username
    isUniqueUsername(username : string) {
        return this.http.get('http://localhost:8085/merlinserver/rest/register/unique/' + username);
    }
}