import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginSucessComponent } from './login-sucess.component';

describe('LoginSucessComponent', () => {
  let component: LoginSucessComponent;
  let fixture: ComponentFixture<LoginSucessComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginSucessComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginSucessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
