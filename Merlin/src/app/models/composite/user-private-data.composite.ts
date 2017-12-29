import { MagicalUser } from "../magical-user.model";
import { PrivateUserInfo } from "../private-user-info.model";

/**
 * This is a temporary user build until the public info dao is ready
 * @author Nasir Alauddin
 */
export class UserPrivateData {
    user: MagicalUser;
    privateInfo: PrivateUserInfo;
}