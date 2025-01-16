import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchantPaymentApplicationComponent } from './merchant-payment-application.component';

describe('MerchantPaymentApplicationComponent', () => {
  let component: MerchantPaymentApplicationComponent;
  let fixture: ComponentFixture<MerchantPaymentApplicationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MerchantPaymentApplicationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MerchantPaymentApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
