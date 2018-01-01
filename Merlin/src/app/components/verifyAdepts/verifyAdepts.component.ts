import { Component, OnInit } from "@angular/core";
import { PrivateUserInfo } from "../../models/private-user-info.model";
import { UserPrivateInfoService } from "../../services/user-private-info/user-private-info.service";

@Component({
    selector: 'app-verifyAdepts',
    templateUrl: './verifyAdepts.component.html'

})

export class VerifyAdepts implements OnInit {
    unverifiedAdepts: PrivateUserInfo[]
    loading: boolean

    constructor(private privateUserInfoService: UserPrivateInfoService) {
        this.loading = true
    }

    /**
     * Pull all unverified adepts from the server
     */
    ngOnInit() {
      this.grabUnverifiedAdepts()
    }

    /**
     * Verify the account
     * @param username of the adept being verified
     */
    verify(username: string): void {
        var self = this
        //pull all unverified adepts from the server
        this.privateUserInfoService.verifyAdept(username).subscribe(
            data => {
                self.grabUnverifiedAdepts()
            }
        ) 
   
    }

    /**
     * Pull all unverified adepts from the server
     */
    grabUnverifiedAdepts(): void {
        this.privateUserInfoService.getUnverifiedAdepts()
        .subscribe(response => {
            this.unverifiedAdepts = response //set the array of adepts
            this.loading = false
        })
    }
}