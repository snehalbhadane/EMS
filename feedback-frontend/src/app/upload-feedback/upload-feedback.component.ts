import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-upload-feedback',
  templateUrl: './upload-feedback.component.html',
  styleUrls: ['./upload-feedback.component.css']
})
export class UploadFeedbackComponent implements OnInit {



  UploadfeedbackURL="http://localhost:8080/poc_feedback/feedback/api/saveEmployeeFeedback"
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

    this._http.post(this.UploadfeedbackURL,formdata).subscribe(
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

}}
