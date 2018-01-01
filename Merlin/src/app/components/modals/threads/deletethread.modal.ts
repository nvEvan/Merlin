/**
 * @description Defines modal used to display failed attempt to create a new thread
 * @author Antony Lulciuc
 */
import { Component, TemplateRef, ViewChild } from '@angular/core';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';

@Component({
  selector: 'ngbd-deletethread',
  templateUrl: './deletethread.modal.html'
})

export class DeleteThreadModal {
  @ViewChild('template')
  private template: TemplateRef<any>;
  public modalRef: BsModalRef;
  pass: boolean = false;

  constructor(private modalService: BsModalService) {} // {2}

  /**
   * Dispplays modal on screen
   */
  public openModalPass() {
    this.pass = true;
    this.modalRef = this.modalService.show(this.template); 
  }

   /**
   * Dispplays modal on screen
   */
  public openModalFail() {
    this.pass = false;
    this.modalRef = this.modalService.show(this.template); 
  }
}