import { Component, OnInit } from '@angular/core';
import * as XLSX from 'xlsx';


@Component({
  selector: 'app-excelsheet',
  templateUrl: './excelsheet.component.html',
  styleUrls: ['./excelsheet.component.css']
})
export class ExcelsheetComponent implements OnInit {
exportAsXLSX() {
throw new Error('Method not implemented.');
}

  data:[][];
  excelsheetService: any;
  
  constructor(){}
  ngOnInit(): void {
    
  }
  onFileChange(event:any){
   const target :DataTransfer= <DataTransfer>(event.target);
   if(target.files.length !==1) throw new Error('cannot use multiple files');

  const reader: FileReader= new FileReader();

  reader.onload =(e:any)=>{
    const bstr:string=e.target.result;

    const wb:XLSX.WorkBook=XLSX.read(bstr,{type:'binary'});

    const wsname: string= wb.SheetNames[0];

    const ws:XLSX.WorkSheet =wb.SheetNames[wsname];

    console.log(ws);

    this.data = (XLSX.utils.sheet_to_json(ws,{header:1}));
    console.log(this.data);
    };

  reader.readAsBinaryString(target.files[0]);

  }

 /*  data:any[{ }] 
  // calling the method
  exportAsXLSX():void{
   this.excelsheetService.exportAsExcelFile(this.data,'sample');
  }
*/
 
}


 


