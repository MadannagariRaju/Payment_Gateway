package com.paymentgatewayapplication.PaymentGateWayApplication.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marchant.MarchantApplication.dto.PaymentRequestDTO;
import com.marchant.MarchantApplication.dto.PaymentResponseDTO;
import com.paymentgatewayapplication.PaymentGateWayApplication.entities.PaymentDetails;
import com.paymentgatewayapplication.PaymentGateWayApplication.entities.TransactionDetails;
import com.paymentgatewayapplication.PaymentGateWayApplication.repository.PaymentGateWayRepository;
import com.paymentgatewayapplication.PaymentGateWayApplication.repository.TransactionDetailsRepo;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentGateWayRepository paymentrepo;
	
	@Autowired
	private TransactionDetailsRepo transactionDetailsRepo;
	
	public PaymentResponseDTO validatePayment(PaymentRequestDTO paymentRequestDTO) {
		PaymentResponseDTO response = new PaymentResponseDTO();
		
		TransactionDetails transactionDetails = new TransactionDetails();
		
		if(paymentRequestDTO.getCardHolderName()==null || paymentRequestDTO.getCardNumber() == 0 || paymentRequestDTO.getCvv() == 0 || paymentRequestDTO.getAmount() == 0) {
			response.setStatus("Failed");
			response.setMessage("Please Fill the Required Field");
			processPayment(response, transactionDetails, paymentRequestDTO);
			return response;
		}

		// Step 1: Validate Card Details
		PaymentDetails storedDetails = paymentrepo.findByCardNumber(paymentRequestDTO.getCardNumber());

		if (storedDetails == null) { // Check if the card does NOT exist
			transactionDetails.setStatus("Failed");
			response.setStatus("FAILED");
			response.setMessage("Invalid card details. Please check your card number.");
			processPayment(response, transactionDetails, paymentRequestDTO);
			return response;
		}
		
		
		// Step 2: Validate CVV
		if (!storedDetails.getCvv().equals(paymentRequestDTO.getCvv())) {
			transactionDetails.setStatus("Failed");
			response.setStatus("FAILED");
			response.setMessage("Invalid CVV. Please check and try again.");
			processPayment(response, transactionDetails, paymentRequestDTO);
			return response;
		}

		// Step 3: Validate Payment Amount
		if (paymentRequestDTO.getAmount() <= 0) {
			transactionDetails.setStatus("Failed");
			response.setStatus("FAILED");
			response.setMessage("Invalid payment amount.");
			processPayment(response, transactionDetails, paymentRequestDTO);
			return response;
		}

		// Step 4: Validate Balance
		Long availableBalance = storedDetails.getAmount();
		if (paymentRequestDTO.getAmount() > availableBalance) {
			transactionDetails.setStatus("Failed");
			response.setStatus("FAILED");
			response.setMessage("Insufficient balance.");
			processPayment(response, transactionDetails, paymentRequestDTO);
			return response;
		} else {
			storedDetails.setAmount(availableBalance - paymentRequestDTO.getAmount());
		}

		// Process successful payment
		try {
			paymentrepo.save(storedDetails);
			transactionDetails.setStatus("SUCCESS");
			response.setStatus("SUCCESS");
			response.setMessage("Payment processed successfully.");
			processPayment(response, transactionDetails, paymentRequestDTO);
			return response;
		} catch (Exception e) {
			// Handle any exceptions during database update
			response.setStatus("FAILED");
			response.setMessage("Error processing payment: " + e.getMessage());
			processPayment(response, transactionDetails, paymentRequestDTO);
			return response;
		}
	}

	private void processPayment(PaymentResponseDTO response, TransactionDetails transactionDetails, PaymentRequestDTO paymentRequestDTO) {
		String name = paymentRequestDTO.getCardHolderName();
		response.setCardholderName(name);
		transactionDetails.setCustomerName(name);
		String orderId = generateOrderId();
		response.setOrderId(orderId);
		transactionDetails.setOrderId(orderId);
		String transactionId = generateTransactionId();
		response.setTransactionId(transactionId);
		transactionDetails.setTransactionId(transactionId);
		String date = getDate();
		response.setDateTime(date);
		transactionDetails.setDateTime(date);
		transactionDetailsRepo.save(transactionDetails);
	}

//	private void processSuccessfulPayment(PaymentResponseDTO response, TransactionDetails transactionDetails, PaymentRequestDTO paymentRequestDTO) {
//		String name = paymentRequestDTO.getCardHolderName();
//		response.setCardholderName(name);
//		transactionDetails.setCustomerName(name);
//		String orderId = generateOrderId();
//		response.setOrderId(orderId);
//		transactionDetails.setOrderId(orderId);
//		String transactionId = generateTransactionId();
//		response.setTransactionId(transactionId);
//		transactionDetails.setTransactionId(transactionId);
//		String date = getDate();
//		response.setDateTime(date);
//		transactionDetails.setDateTime(date);
//		transactionDetailsRepo.save(transactionDetails);
//	}

	public String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	public static String generateOrderId() {
		String prefix = "ORD";
		Random random = new Random();
		int randomNumber = 10000 + random.nextInt(90000);
		return prefix + randomNumber;
	}

	public static String generateTransactionId() {
		String prefix = "TXN";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = sdf.format(new Date());
		Random random = new Random();
		int randomNumber = 1000 + random.nextInt(9000);
		return prefix + timestamp + randomNumber;
	}


}
