package com.paymentgatewayapplication.PaymentGateWayApplication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transaction_details")
public class TransactionDetails {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(name = "transaction_id")
    private String transactionId;
    
    @Column(name = "order_id")
    private String orderId;
    
    @Column(name = "customer_name")
    private String customerName;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "date_time")
    private String dateTime;

	public TransactionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionDetails(Integer id, String transactionId, String orderId, String customerName, String status,
			String dateTime) {
		super();
		this.id = id;
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.customerName = customerName;
		this.status = status;
		this.dateTime = dateTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "TransactionDetails [id=" + id + ", transactionId=" + transactionId + ", orderId=" + orderId
				+ ", customerName=" + customerName + ", status=" + status + ", dateTime=" + dateTime + "]";
	}

    
}
