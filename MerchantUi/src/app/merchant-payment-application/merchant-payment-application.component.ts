import { HttpClient } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-merchant-payment-application',
  standalone: false,
  templateUrl: './merchant-payment-application.component.html',
  styleUrls: ['./merchant-payment-application.component.css']
})
export class MerchantPaymentApplicationComponent{
  // Initialize form object with default values
  constructor(private http: HttpClient, private route: ActivatedRoute) {}
  
  
  amount: number = 0 ;
  productName: string = '';


    form = {
    cardHolderName: '',
    cvv: '',
    productName: this.productName,
    cardNumber: '',
    amount:this.amount
  }

  ngOnInit(): void {
    // Capture query parameters
    this.route.queryParams.subscribe((params: { [x: string]: string | number; }) => {
      this.productName = String(params['name'] || '');  // Always a string
      this.amount = +params['price'] || 0; // Convert price to number
    });
        // Update the form object with the values from the query parameters
        this.form.productName = this.productName;
        this.form.amount = this.amount;
  }
  

  
  successMessage: any = ''  // Message for successful response
  errorMessage: any = '';    // Message for error response


  // productName: any = '';
  // productPrice: number = 0;

  // ngOnInit() {
  //   this.route.queryParams.subscribe((params: { [x: string]: string | number; }) => {
  //     this.productName = params['name'];
  //     this.productPrice = isNaN(+params['price']) ? 0 : +params['price']; // Convert string to number
  //     console.log(typeof this.productPrice)
  //   });
  // }

  closeSuccessMessage() {
    this.successMessage = null;
  }

  // Close the error message
  closeErrorMessage() {
    this.errorMessage = null;
  }




  // Handle form submission
  onSubmit() {
    console.log('Data being sent to backend:', this.form);

    // Reset messages before sending the request
    this.successMessage = '';
    this.errorMessage = '';

    // Make POST request to backend API
    this.http.post('http://localhost:8080/makepayment', this.form)
      .subscribe((response: any) => {
        console.log('Response from backend:', response);

        
        // Display success message based on response
        if (response.status === 'SUCCESS') {
          this.successMessage = {
            status: response.status,
            cardholderName: response.cardholderName,
            orderId: response.orderId,
            message: response.message,
            transactionId: response.transactionId,
            dateTime: response.dateTime
          };
        } else {
          this.errorMessage = 'Payment failed: ' + response.message;
        }
      }, (error: any) => {
        console.error('Error while submitting form:', error);
        this.errorMessage = 'An error occurred while processing the payment. Please try again later.';
      });
  }
}
