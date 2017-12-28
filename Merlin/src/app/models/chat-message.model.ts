import { UserData } from "./composite/user-data.composite";

/**
 * Base definition for Instant Message 
 * @author Antony Lulciuc
 */
export class ChatMessage{
    $key?: string;
    email?: string;
    userName?: string;
    message?: string;
    timeSent?: Date = new Date();

    constructor(data: UserData, message: string) {
        this.email = data.privateInfo.email;
        this.userName = data.general.username;
        this.message = message;
    }
}