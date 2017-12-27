/**
 * Defines container for Appointment Bean
 * @author Antony Lulciuc
 */
import { MagicalUser } from "./magical-user.model";
import { CodeList } from "./code-list.model";

export class Appointment {
    id: number;
    adept: MagicalUser;
    apprentice: MagicalUser;
    state: CodeList;
    startDateTime: Date;
    endDateTime: Date;
}