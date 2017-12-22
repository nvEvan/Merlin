export class userPublicInfo{
    
    fname: string;
    lname: string;
    userId: number;//change to number
    username: string;

    constructor(
        fname: string,
        lname: string,
        userId: number,
        username: string
    ){
        this.fname = fname;
        this.lname = lname;
        this.userId = userId;
        this.username = username;
    }
}