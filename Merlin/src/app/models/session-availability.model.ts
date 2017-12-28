/**
 * Defines container for SessionAvailability Bean
 * @author Antony Lulciuc
 */
import { MagicalUser } from "./magical-user.model";

export class SessionAvailability {
    sessionAvailabiltyId: number;
    adept: MagicalUser;
    startDateTime: Date;
    endDateTime: Date;
    recurringTime: boolean;
}