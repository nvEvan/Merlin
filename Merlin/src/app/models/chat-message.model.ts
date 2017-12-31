/**
 * Base definition for Instant Message 
 * @author Antony Lulciuc
 */
import { UserData } from "./composite/user-data.composite";

export class ChatMessage{
    $key?: string;
    email?: string;
    userName?: string;
    message?: string;
    timeSent?: string;

    constructor(data: UserData, message: string, date: string) {
        this.email = data.privateUserInfo.email;
        this.userName = data.user.username;
        this.message = message;
        this.timeSent = date;
    }
}