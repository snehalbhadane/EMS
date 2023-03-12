import { EmployeeFeedbackService } from './../service/employeeFeedbackService';
import { EmployeeFeedback } from './../model/employeeFeedback';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-feedback-list',
  templateUrl: './feedback-list.component.html',
  styleUrls: ['./feedback-list.component.css']
})
export class FeedbackListComponent implements OnInit {

  employeeFeedbacks !: EmployeeFeedback[];

  constructor(private myrouter:Router, private service : EmployeeFeedbackService) { }

  ngOnInit(): void {
    this.listEmployeeFeedbacks();
}

  async listEmployeeFeedbacks() {
     this.service.getEmployeeFeedbacks().subscribe((data: EmployeeFeedback[]) => {
     this.employeeFeedbacks = data;
    });
  }
}