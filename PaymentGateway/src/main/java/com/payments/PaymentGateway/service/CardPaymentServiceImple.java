package com.payments.PaymentGateway.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.payments.PaymentGateway.entity.CardPayment;
//import com.springrest.springrest.entities.Course;

@Service
public class CardPaymentServiceImple implements CardPaymentService{

	List<CardPayment> list;
//	public CardPaymentServiceImple() {
//		list = new ArrayList<>();
//		list.add(new CardPayment(1,22,"raju","nandu"));
//		list.add(new CardPayment(2,33,"raju","nandu"));
//	}
	
//List<CardPayment>al;
	
	public CardPaymentServiceImple() {
		list = new ArrayList<>();
		list.add(new CardPayment(1,22,"raju","nandu"));
		list.add(new CardPayment(2,33,"raju","nandu"));
	}
	@Override
	public List<CardPayment> getCardDetails() {
		// TODO Auto-generated method stub
		return list;
	}
	
	public CardPayment captureCardDetails(CardPayment cardPayment) {
		list.add(cardPayment);
		return cardPayment;
	}

	public CardPayment getCardDetail(int paramId) {
		CardPayment cp=null;
		for(CardPayment c: list) {
			if(c.getId() == paramId) {
				cp = c;
			}
		}
		return cp;
	}
	@Override
	public CardPayment updateCardPayment(CardPayment cardPayment) {
		// TODO Auto-generated method stub
		
		for(CardPayment c : list) {
			if(c.getId() == cardPayment.getId()) {
				c.setCardholder_name(cardPayment.getCardholder_name());
				c.setCvv(cardPayment.getCvv());
				c.setMerchant_name(cardPayment.getMerchant_name());
			}
		}
		return cardPayment;
	}
	@Override
	public void deleteCardDetail(int paramId) {
		List<CardPayment>res = list.stream()
	    .filter(cardPayment -> cardPayment.getId()!=paramId)
	    .collect(Collectors.toList());
		System.out.println(res);
	}
	
}
