import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { DownloadService } from '../Service/download.service';


@Component({
  selector: 'app-download',
  templateUrl: './download.component.html',
  styleUrls: ['./download.component.css']
})
export class DownloadComponent implements OnInit {

  colItem: any;
  data: any[];
  downloadService: any;
  
  constructor( private downloadservice:DownloadService){}
   ngOnInit(): void {
    
   }

   // Download File in excel format
   content:any=[
    {
      employeeId:1016662,
      employeename:"vamshi",
      email:"vamshi@gmail.com",
      desingnation:"software enigneer",
      grade:"B.tech",
      resourceType:"Developer",
    /*   Doj:2022-08-23, */
      totalExp:3,
      irm:"Yogeshwar",
      current_Alloctions:"Pune",
      current_Location:"Hyderbad",
      Project:"Poc Project"
    },
    {
      employeeId:1016663,
      employeename:"Umesh",
      email:"umesh@gmail.com",
      desingnation:"software testing",
      grade:"Degree",
      resourceType:"Testing",
    /*   Doj:2022-08-12, */
      totalExp:2,
      irm:"Maruti",
      current_Alloctions:"Pune",
      current_Location:"Hyderbad",
      Project:"java shared"
    }
  ]
  
  array:any=[
    /* ["employeeId","employeeName","email","designation","grade","resourceType","Doj","totalExp","irm","current_Allocation","current_location","project"],
     ["101662","vamshi","vamshi@gmail.com","Software Enigneer","Btech","Developer","2022/0/-23","3","Yogeswar","Pune","Hyderbad","Poc Project"] */
  ];

  file(){
    

    for(let i=0;i<=this.content.length;i++){
    
      var o;
      var newArray:any=[];
      for(o in this.content[i]){
       newArray.push(o);

      }
      break;
    }
    this.array.push(newArray);
 for(let i=0;i<=this.content.length;i++){
  this.array.push(Object.values(this.content[i]))
 
 }
  var CsvString="";
  this.array.forEach((RowItem:any,RowIndex:any) => {
   RowItem.forEach((colItem:any,colIndex:any)=>{
    CsvString += this.colItem +',';
   }) 
   CsvString +="\r\n";

  });
  CsvString = "data:application/csv" +encodeURIComponent(CsvString);
  var x =document.createElement("A"); //<a></a>
  x.setAttribute("href",CsvString);
  x.setAttribute("download","Employee.csv");
 document.body.appendChild(x);
 x.click();
this.array=[];


  }
  
  // calling the method
  exportAsXLSX():void{
    this.downloadService.exportAsExcelFile(this.data,'sample');
   }

   
}
