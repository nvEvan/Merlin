/**
 * Used to send request to server for new threads 
 * @author Antony Lulciuc
 */
import { IMThread } from "../../im-thread.model";

export class IMThreadParams {
    token: string;
    thread: IMThread;
}