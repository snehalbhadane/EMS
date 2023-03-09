import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Employee } from '../model/employee';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
onsearchtextchanged() {
}
  emplist:Employee[];
enteredsearchvalue: any;
  constructor(){}
  ngOnInit(): void {
    
  }

 /*  enteredsearchvalue:string='';
  @Output()
  searchtextchanged:EventEmitter<string> = new EventEmitter<string>;
  
  onsearchtextchanged(){
this.searchtextchanged.emit(this.enteredsearchvalue);

  } */

}




