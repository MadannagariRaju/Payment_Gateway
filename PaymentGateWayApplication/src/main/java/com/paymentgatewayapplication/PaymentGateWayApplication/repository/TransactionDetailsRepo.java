package com.paymentgatewayapplication.PaymentGateWayApplication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentgatewayapplication.PaymentGateWayApplication.entities.TransactionDetails;

public interface TransactionDetailsRepo extends JpaRepository<TransactionDetails, Integer>{

	TransactionDetails findByTransactionId(String transactionId);

}
