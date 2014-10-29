package com.receipt;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonBackReference;

import com.babel.core.data.PersistentEntity;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiptLine extends PersistentEntity {

	private String item;
	 @ManyToOne 
	 @JsonBackReference//("orderLines")
	 @XmlTransient //avoid JAXB parser cycles
	private Receipt receipt;
	private double price;
	private double quantity;

	public ReceiptLine(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public String getItem(){
		return this.item;
	}

	public Receipt getReceipt(){
		return this.receipt;
	}

	public double getPrice(){
		return this.price;
	}

	public double getQuantity(){
		return this.quantity;
	}

	/**
	 * 
	 * @param item
	 */
	public void setItem(String item){
		this.item=item;
	}

	/**
	 * 
	 * @param p
	 */
	public void setReceipt(Receipt p){
		 this.receipt=p;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price){
		this.price=price;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(double quantity){
		this.quantity=quantity;
	}
}