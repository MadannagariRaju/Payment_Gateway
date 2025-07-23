package com.payments.PaymentGateway.service;

import java.util.List;

import com.payments.PaymentGateway.entity.CardPayment;

public interface CardPaymentService {
	public List<CardPayment>getCardDetails();

	public CardPayment captureCardDetails(CardPayment cardPayment);

	public CardPayment getCardDetail(int paramId);

	public CardPayment updateCardPayment(CardPayment cardPayment);

	public void deleteCardDetail(int paramId);
	
}
