package com.paymentgatewayapplication.PaymentGateWayApplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "payment_details")
public class PaymentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(name = "card_holder_name", length = 255)  
    private String cardHolderName;
    
    @Column(name = "card_number", length = 16) 
    private Long cardNumber;
    
    @Column(name = "cvv", length = 3) 
    private Integer cvv;
    
    @Column(name = "amount")
    private Long Amount;

    public Long getAmount() {
		return Amount;
	}

	public void setAmount(Long amount) {
		Amount = amount;
	}

	// Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }
}
