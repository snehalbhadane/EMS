import { Injectable } from '@angular/core';
/* import * as FileSaver from 'file-saver';
import * as XLSX from 'xlsx';

const EXCEL_TYPE ='application/vnd.openxmlformats-officedocument.spredsheet.sheet;charset-UTF8';
const EXCEL_EXTENSION ='.xlsx';
 */
@Injectable({
  providedIn: 'root'
})
export class DownloadService {

  constructor() { }

 /*  public exportAsExcelFile(Json:any[],excelFileName:string):void{
    const Worksheet:XLSX.WorkSheet =XLSX.utils.json_to_sheet(Json);
    const Workbook :XLSX.WorkBook={Sheets:{'data':Worksheet},SheetNames:['data']};
    const excelBuffer:any =XLSX.write(Workbook,{bookType:'xlsx',type:'array'});
    this.saveAsExcelFile(excelBuffer,excelFileName);
  }
    saveAsExcelFile(buffer: any, fileName: any):void{
      const data :Blob=new Blob([buffer],{type:EXCEL_TYPE});
    FileSaver.saveAS(data,fileName + '_export_' + new Date().getTime()+EXCEL_EXTENSION);
    }
   */
}
