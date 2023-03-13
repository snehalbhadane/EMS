import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { EmployeeFeedback } from './../model/employeeFeedback';
import { Component, OnInit } from '@angular/core';
import { EmployeeFeedbackService } from '../service/employeeFeedbackService';

@Component({
  selector: 'app-upload-feedback',
  templateUrl: './upload-feedback.component.html',
  styleUrls: ['./upload-feedback.component.css']
})
export class UploadFeedbackComponent implements OnInit {

  constructor(private service : EmployeeFeedbackService, private fb : FormBuilder,
     private router : Router) { }

  employeeFeedbackForm !: FormGroup;
  employeeFeedbackFile !: File;
  invalidFile = false;
  errorType = false;
  errorList !: String[];

  ngOnInit(): void {
    this.employeeFeedbackForm = this.fb.group({
      employeeFeedbackFile: ['', Validators.required]
    })
  }

  downloadEmployeeFeedbackTemplate() {
    
    let fileName = "employee-feedback-template.xlsx"

    this.service.downloadEmployeeFeedbackTemplate().subscribe((response: any) => {
      if(response) {
        var blob = new Blob([response], {type: "application/octet-stream"});
        var a = document.createElement("a");
        a.href = URL.createObjectURL(blob);
        a.download = fileName;
        a.click();
      }

    });
  }

  employeeFeedbackFileInput(event: any) {

    if(event.target.files.length == 0) {
      this.invalidFile = false;
      return;
    }

    let fileExtension = event.target.files.item(0)?.name.split(".").pop();
    
    if(event.target.files.length > 0 && fileExtension === "xlsx") {
      this.employeeFeedbackFile = event.target.files[0];
      this.invalidFile = false;
    }
    else {
      this.invalidFile = true;
    }
  }

  onSubmit() {
    let formData = new FormData();
    
    formData.append("file", this.employeeFeedbackFile);

    this.service.uploadEmployeeFeedback(formData).subscribe((data : String[]) => {
      this.errorList = data;
      this.errorType = true;
      this.router.navigate(['/upload-feedback'])
    })
 }
}
