import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalculatedTaxComponent } from './calculated-tax.component';

describe('CalculatedTaxComponent', () => {
  let component: CalculatedTaxComponent;
  let fixture: ComponentFixture<CalculatedTaxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CalculatedTaxComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CalculatedTaxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
