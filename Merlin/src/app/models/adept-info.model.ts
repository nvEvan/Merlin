/**
 * Defines container AdeptInfo Bean
 * @author Antony Lulciuc
 */

import { MagicalUser } from "./magical-user.model";
import { CodeList } from "./code-list.model";

 export class AdeptInfo {
     id: number;
     adept: MagicalUser;
     paymentInfo: CodeList;
     price: number;
 }