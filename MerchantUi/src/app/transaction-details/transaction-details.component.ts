import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-transaction-details',
  standalone: false,
  templateUrl: './transaction-details.component.html',
  styleUrls: ['./transaction-details.component.css'] // Fixed typo from 'styleUrl' to 'styleUrls'
})
export class TransactionDetailsComponent {
  transactionId: string = '';
  transaction: any = null;
  error: string = '';

  constructor(private http: HttpClient) {}

  fetchTransactionDetails() {
    console.log("Fetching transaction details...");

    if (!this.transactionId) {
      this.error = 'Transaction ID is required!';
      this.transaction = null;
      return;
    }

    // Correct GET request without a body
    this.http.get(`http://localhost:8080/transaction/${this.transactionId}`).subscribe(
      (response: any) => {
        console.log('Transaction fetched successfully:', response);
        this.transaction = response;
        this.error = '';
      },
      (err: any) => {
        console.error('Error fetching transaction:', err);
        this.transaction = null;
        this.error = 'Transaction not found!';
      }
    );
  }
}
