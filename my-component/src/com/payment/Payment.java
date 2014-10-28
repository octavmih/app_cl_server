package com.payment;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.babel.core.data.PersistentEntity;

@Entity 
@Table(name="PaymentTable")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Payment extends PersistentEntity{
	private String OrderId;
	private String PaymentNumber;
	private double Amount;
	private String PaymentType;
	
	public Payment(){
	}
	
	public String getOrderId() {
		return this.OrderId;
	}
	public void setOrderId(String orderId) {
		this.OrderId = orderId;
	}
	public String getPaymentNumber() {
		return this.PaymentNumber;
	}
	public void setPaymentNumber(String paymentNumber) {
		this.PaymentNumber = paymentNumber;
	}
	public double getAmount() {
		return this.Amount;
	}
	public void setAmount(double amount) {
		this.Amount = amount;
	}
	public String getPaymentType() {
		return this.PaymentType;
	}
	public void setPaymentType(String paymentType) {
		this.PaymentType = paymentType;
	}
	
}
