import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MerchantPaymentApplicationComponent } from './merchant-payment-application/merchant-payment-application.component';
import { TransactionDetailsComponent } from './transaction-details/transaction-details.component';
import { FurnitureProductsComponent } from './furniture-products/furniture-products.component';
// import { NavbarComponent } from './navbar/navbar.component';
// import { TransactionDetailsComponent } from './transaction-details/transaction-details.component';


@NgModule({
  declarations: [
    AppComponent,
    MerchantPaymentApplicationComponent,
    TransactionDetailsComponent,
    FurnitureProductsComponent,
    // NavbarComponent,
    // TransactionDetailsComponent,
    
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
