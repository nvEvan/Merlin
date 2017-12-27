/**
 * Defines container for Tkoen Bean
 * @author Antony Lulciuc
 */
import { MagicalUser } from "./magical-user.model";

export class Token {
    id: number;
    user: MagicalUser;
    token: string;
    expDate: Date;
}