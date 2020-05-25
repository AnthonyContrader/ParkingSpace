import { AssignmentParkingDTO } from './../../../dto/assignmentParking';
import { BillService } from './../../../service/billservice';
import { BillDTO } from './../../../dto/billdto';
import { Component, OnInit } from '@angular/core';
import { AssignmentParkingService } from 'src/service/assignmentBill';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {
  billToInsert: BillDTO = new BillDTO();
  assignments: AssignmentParkingDTO[];
  bills: BillDTO[];
  
  constructor(private service: BillService, private aService: AssignmentParkingService) { }

  ngOnInit() {
    this.setAssignments();
    this.getall();
  }

  getall(){
     this.service.getAll().subscribe(bills => this.bills = bills);
  }
  insert(bill:BillDTO){
    console.log(bill.price, bill.billStatus, bill.assignmentId);
    this.service.insert(bill).subscribe(() => this.getall());
  }
  delete(bill: BillDTO){
      this.service.delete(bill.id).subscribe(()=>this.getall());
  }
  update(bill:BillDTO){
    this.service.update(bill).subscribe(()=>this.getall());
  }

  setAssignments(){
    this.aService.getAll().subscribe(assignments => this.assignments = assignments);
  }
}
