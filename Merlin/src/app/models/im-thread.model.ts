/**
 * Defines container for IMThread Bean
 * @author Antony Lulciuc
 */
import { MagicalUser } from "./magical-user.model";
import { CodeList } from "./code-list.model";

export class IMThread {
    id: number;
    creator: MagicalUser;
    status: CodeList;
    name: string;
    link: string;
    threadCreationDate: string;
};

