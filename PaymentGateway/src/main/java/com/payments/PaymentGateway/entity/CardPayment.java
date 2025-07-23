package com.payments.PaymentGateway.entity;

//@Entity
//@Table(name = "cards")
public class CardPayment {
//     @Id
//     @GeneratedValue(strategy =  GenerationType.IDENTITY)
//     private Integer id;
//
//     @Column(name = "card_number")
//     private int cardNumber;
//
//     @Column(name = "cardholder_name")
//     private String cardholderName;
//
//     @Column(name = "cvv")
//     private Integer cvv;
	
	private int id;
	private int cvv;
	private String cardholder_name;
	private String Merchant_name;
	
	public CardPayment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardPayment( int id,int cvv, String cardholder_name, String merchant_name) {
		super();
		this.cvv = cvv;
		this.cardholder_name = cardholder_name;
		Merchant_name = merchant_name;
		this.id = id;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String getCardholder_name() {
		return cardholder_name;
	}
	public void setCardholder_name(String cardholder_name) {
		this.cardholder_name = cardholder_name;
	}
	public String getMerchant_name() {
		return Merchant_name;
	}
	public void setMerchant_name(String merchant_name) {
		Merchant_name = merchant_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "CardPayment [cvv=" + cvv + ", cardholder_name=" + cardholder_name + ", Merchant_name=" + Merchant_name
				+ ", id=" + id + "]";
	}
	
	

}
