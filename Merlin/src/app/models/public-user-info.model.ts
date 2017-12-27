/**
 * Defines constainer for PublicUserInfo Bean
 * @author Antony Lulciuc
 */
import { MagicalUser } from "./magical-user.model";
import { CodeList } from "./code-list.model";

export class PublicUserInfo {
    publicUserId: number;
    user: MagicalUser;
    role: CodeList;
    firstName: string;
    lastName: string;
    email: string;
    phoneNumber: string;
    address: string;
    description: string;
    image: Blob;
}
