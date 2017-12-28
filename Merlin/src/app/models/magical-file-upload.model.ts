/**
 * Defines container for MagicalFileUpload Bean
 * @author Antony Lulciuc
 */
import { MagicalUser } from "./magical-user.model";
import { CodeList } from "./code-list.model";

export class MagicalFileUpload {
    id: number;
    user: MagicalUser;
    fileType: CodeList;
    fileName: string;
    file: Blob;
}
