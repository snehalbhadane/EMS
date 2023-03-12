import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { error } from 'console';

@Component({
  selector: 'app-feedback-file-upload',
  templateUrl: './feedback-file-upload.component.html',
  styleUrls: ['./feedback-file-upload.component.css']
})
export class FeedbackFileUploadComponent implements OnInit {

  fileUploadURL="http://localhost:8080/poc_feedback/feedback/api/saveEmployeeFeedback"
  constructor(
    private _http:HttpClient
  ) { }

  ngOnInit(): void {
  }

  file:any;

  selectfile(event: any){
    // console.log(event);
    this.file = event.target.files[0];
    console.log(this.file);

  }

  uploadFile(){
    let formdata=new FormData()
    formdata.append("file", this.file);

    this._http.post(this.fileUploadURL,formdata).subscribe(
      data=>{
        //sucess
         alert("file is uploaded")
        console.log(data);

      },
      (error)=>{
        //error
        console.log(error);
      }
    )



  }




}
