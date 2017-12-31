/**
 * Defines class which containes public/private information to be shared amongst multiple screens
 * @author Antony Lulciuc
 */
import { MagicalUser } from "../magical-user.model";
import { PrivateUserInfo } from "../private-user-info.model";
import { PublicUserInfo } from "../public-user-info.model";

export class UserData {
    token: string;
    user: MagicalUser;
    privateUserInfo: PrivateUserInfo;
    publicUserInfo: PublicUserInfo;
}