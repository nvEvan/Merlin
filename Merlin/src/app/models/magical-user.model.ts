/**
 * Defines Container for MagicalUser Bean
 * @author Antony Lulciuc
 */
export class MagicalUser {
    userId: number;
    username: string;
    password: string;

    constructor(username : string, password : string) {
        this.username = username
        this.password = password
    }
}