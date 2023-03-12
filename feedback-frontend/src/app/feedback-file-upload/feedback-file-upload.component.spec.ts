import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbackFileUploadComponent } from './feedback-file-upload.component';

describe('FeedbackFileUploadComponent', () => {
  let component: FeedbackFileUploadComponent;
  let fixture: ComponentFixture<FeedbackFileUploadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeedbackFileUploadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FeedbackFileUploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
