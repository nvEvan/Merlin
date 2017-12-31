import { MagicalUser } from "../../magical-user.model";
import { PrivateUserInfo } from "../../private-user-info.model";
import { MagicalFileUpload } from "../../magical-file-upload.model";
/**
 * Data needed for adept registration
 * @author Alex Peterson
 */
export class AdeptData {
    user: MagicalUser;
    privateUserInfo: PrivateUserInfo;
    magicalFileUpload : MagicalFileUpload
}