package com.payments.PaymentGateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payments.PaymentGateway.entity.CardPayment;
import com.payments.PaymentGateway.service.CardPaymentService;
//import com.springrest.springrest.entities.Course;


@RestController
public class CardController {
	
//	1. Make Payment‬‭: This API needs to capture the payment‬‭details and respond with a‬
//	‭message that says if the payment worked or not. It also returns a unique code‬
//	‭(payment reference) for each payment request.
	
	@Autowired		
	private CardPaymentService cardPaymentService;
	
	
	@GetMapping("/home")
	public String home() {
		return "Hello all ";
	}
	
//	@GetMapping("/details")
//	public List<CardPayment>getCardDetails() {
//		return this.cardPaymentService.getCardDetails();
//	}
	
	@GetMapping("/details")
	public List<CardPayment>getCardDetails() {
		return this.cardPaymentService.getCardDetails();
	}
	
	@PostMapping("/makepayment")
	public CardPayment captureCardDetails(@RequestBody CardPayment cardPayment) {
		return this.cardPaymentService.captureCardDetails(cardPayment);
	}
	
	@PutMapping("/details/{paramId}")
	public CardPayment getCardDetail(@PathVariable String paramId) {
		return this.cardPaymentService.getCardDetail(Integer.parseInt(paramId));
	}
	
	@PutMapping("/update/details")
	public CardPayment updateCardPayment(@RequestBody CardPayment cardPayment) {
		return this.cardPaymentService.updateCardPayment(cardPayment);
	}
	
	@DeleteMapping("/delete/{paramsId}")
	public void deleteCardDetail(@PathVariable String paramsId) {
		this.cardPaymentService.deleteCardDetail(Integer.parseInt(paramsId));
	}
}
