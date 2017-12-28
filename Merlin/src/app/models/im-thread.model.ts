import { MagicalUser } from "./magicaluser.model";
import { CodeList } from "./codelist.model";

/**
 * Defines container for IMThread Bean
 * @author Antony Lulciuc
 */
export class IMThread {
    id: number;
    creator: MagicalUser;
    status: CodeList;
    name: string;
    link: string;
    threadCreationDate: Date;
};

