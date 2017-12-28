/**
 * Defines container for UserBadge Bean
 * @author Antony Lulciuc
 */
import { MagicalUser } from "./magical-user.model";
import { Badge } from "./badge.model";

export class UserBadge {
    id: number;
    user: MagicalUser;
    badge: Badge;
}