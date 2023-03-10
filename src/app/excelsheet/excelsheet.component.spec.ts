import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExcelsheetComponent } from './excelsheet.component';

describe('ExcelsheetComponent', () => {
  let component: ExcelsheetComponent;
  let fixture: ComponentFixture<ExcelsheetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExcelsheetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExcelsheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
