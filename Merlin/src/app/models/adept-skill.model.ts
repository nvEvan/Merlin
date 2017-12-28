/**
 * Defines container for AdeptSkill Bean
 * @author Antony Lulciuc
 */
import { CodeList } from "./code-list.model";

export class AdeptSkill {
    id: number;
    adept: CodeList;
    skill: CodeList;
}