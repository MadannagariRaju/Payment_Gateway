import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { FurnitureProductsComponent } from './furniture-products/furniture-products.component';
import { MerchantPaymentApplicationComponent } from './merchant-payment-application/merchant-payment-application.component';
import { TransactionDetailsComponent } from './transaction-details/transaction-details.component';

const routes: Routes = [
  {path:'',component:FurnitureProductsComponent},
  {path: 'payment', component: MerchantPaymentApplicationComponent },
  {path:'check' ,component: TransactionDetailsComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
