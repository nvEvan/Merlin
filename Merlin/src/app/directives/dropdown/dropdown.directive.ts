/**
 * Defines directive for navbar dropdown feature
 * @author Antony Lulciuc
 */
import { Directive,HostListener,HostBinding } from '@angular/core'; 

@Directive({
    selector: '[navdropdown]'
})

export class DropdownDirective {
    private isOpen = false;

    constructor() { 
        // do nothing
    }

    @HostBinding('class.open') 
    get opened() {
        return this.isOpen;
    }

    @HostListener('click') 
    open() {
        this.isOpen = true;
    }

    @HostListener('mouseleave') 
    close() {
        this.isOpen = false;
    }
}