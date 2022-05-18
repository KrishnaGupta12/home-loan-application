import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IntRateCalcComponent } from './int-rate-calc.component';

describe('IntRateCalcComponent', () => {
  let component: IntRateCalcComponent;
  let fixture: ComponentFixture<IntRateCalcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IntRateCalcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IntRateCalcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
