/**
 * Defines container for Receipt Bean
 * @author Antony Lulciuc
 */
import { MagicalUser } from "./magical-user.model";

export class Receipt {
    receiptId: number;
    apprentice: MagicalUser;
    adept: MagicalUser;
    timestamp: Date;
    description: string;
    amount: number;
}