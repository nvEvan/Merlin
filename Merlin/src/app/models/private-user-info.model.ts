/**
 * Defines container for PrivateUserInfo Bean
 * @author Antony Lulciuc
 */
import { MagicalUser } from "./magical-user.model";
import { CodeList } from "./code-list.model";

export class PrivateUserInfo {
    privateUserId: number;
    user: MagicalUser;
    role: CodeList;
    stateCity: CodeList;
    status: CodeList;
    firstName: string;
    lastName: string;
    email: string;
    phoneNumber: string;
    address: string;
}
