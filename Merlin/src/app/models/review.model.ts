/**
 * Defines containerfor Review Bean
 * @author Antony Lulciuc
 */
import { MagicalUser } from "./magical-user.model";

export class Review {
    id: number;
    apprentice: MagicalUser;
    adept: MagicalUser;
    description: string;
    score: number;
}