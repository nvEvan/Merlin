import { Injectable } from "@angular/core";
import { Http } from "@angular/http";
import { UserPrivateData } from "../../models/composite/user-private-data.composite";
import { Observable } from "rxjs/Observable";
import { Response } from "@angular/http/src/static_response";
import { AdeptData } from "../../models/composite/registration/adept_data.composite";

/**
 * Service class used for User registration.
 * @author Alex
 */
@Injectable()
export class RegistrationService {

    constructor(private http: Http) { }

    /**
     * Register the apprentice
     * @param Apprentice 
     */
    registerApprentice(apprenticeData: UserPrivateData) {
        this.http.post("http://localhost:8085/merlinserver/rest/register/apprentice", apprenticeData)
            .subscribe(
            data => {

            }, err => {

            }
            );
    }

    /**
     * Register the adept
     * @param adeptData 
     */
    registerAdept(adeptData: AdeptData) {
        this.http.post("http://localhost:8085/merlinserver/rest/register/adept", adeptData)
            .subscribe(
            data => {

            }, err => {

            }
            );
    }

    /**
     * Check the user registering is using a new username
     */
    isUniqueUsername(username: string): Observable<boolean> {
        let url: string = 'http://localhost:8085/merlinserver/rest/register/unique/' + username
        return this.http.get(url).map((response: Response) => response.json());
    }
}