package com.paymentgatewayapplication.PaymentGateWayApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.marchant.MarchantApplication.dto.PaymentRequestDTO;
import com.marchant.MarchantApplication.dto.PaymentResponseDTO;
import com.paymentgatewayapplication.PaymentGateWayApplication.entities.TransactionDetails;
import com.paymentgatewayapplication.PaymentGateWayApplication.repository.TransactionDetailsRepo;
import com.paymentgatewayapplication.PaymentGateWayApplication.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	
	@Autowired
	private TransactionDetailsRepo transactionDetailsRepo;

	@PostMapping("api/payment/validate")
	public PaymentResponseDTO validatePayment(@RequestBody PaymentRequestDTO paymentRequestDTO) {
		return paymentService.validatePayment(paymentRequestDTO);
	}

	
	
    @SuppressWarnings("unused")
	@GetMapping("/api/transaction/{transactionId}")
    public ResponseEntity<TransactionDetails> getTransactionById(@PathVariable String transactionId) {

		TransactionDetails transaction = transactionDetailsRepo.findByTransactionId(transactionId);
         System.out.println(transaction.toString());
         System.out.println(transaction);
        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
