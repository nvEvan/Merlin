import { Component, TemplateRef } from '@angular/core';
import { SimpleNgbModal } from '../../../services/modals/simple.ngb.modal';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { BsModalRef, BsModalService } from 'ngx-bootstrap/modal';

@Component({
  selector: 'ngbd-newthread',
  templateUrl: './newthread.modal.html'
})

export class NewThreadModal {
  public modalRef: BsModalRef;
  constructor(private modalService: BsModalService) {} // {2}

  public openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template); 
    
  }
}