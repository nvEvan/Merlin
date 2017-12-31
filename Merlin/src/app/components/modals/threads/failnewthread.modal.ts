import { Component, TemplateRef, ViewChild } from '@angular/core';
import { SimpleNgbModal } from '../../../services/modals/simple.ngb.modal';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';

@Component({
  selector: 'ngbd-newthread',
  templateUrl: './failnewthread.modal.html'
})

export class FailNewThreadModal {
  @ViewChild('template')
  private template: TemplateRef<any>;
  public modalRef: BsModalRef;

  constructor(private modalService: BsModalService) {} // {2}

  public openModal() {
    this.modalRef = this.modalService.show(this.template); 
    
  }
}