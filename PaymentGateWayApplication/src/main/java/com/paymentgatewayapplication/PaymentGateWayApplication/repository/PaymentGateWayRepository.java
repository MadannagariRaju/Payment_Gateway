package com.paymentgatewayapplication.PaymentGateWayApplication.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.paymentgatewayapplication.PaymentGateWayApplication.entities.PaymentDetails;


public interface PaymentGateWayRepository extends JpaRepository<PaymentDetails, Integer>{
//	cardNumber
	PaymentDetails findByCardNumber(Long cardNumber);


}