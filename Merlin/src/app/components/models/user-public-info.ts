export class UserPublicInfo {
    
    fname: string;
    lname: string;
    userId: number;
    username: string;

    constructor(fname: string, lname: string, userId: number, username: string) {
        this.fname = fname;
        this.lname = lname;
        this.userId = userId;
        this.username = username;
    }
}
