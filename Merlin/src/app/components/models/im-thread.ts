import { MagicalUser } from "./magical-user";
import { CodeList } from "./codelist";

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

