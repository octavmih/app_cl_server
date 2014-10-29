package com.receipt;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonManagedReference;

import com.babel.core.data.PersistentEntity;


@Entity 
@Table(name="ReceiptTable")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Receipt extends PersistentEntity {

	private String customerEmail;
	private String customerName;
	private String deliveryAddress;
	private String bankAccount;
	private Date receiptDate;
	private String specialRequirements;
	/**
	 * The Order may be involved in multiple external processes. 
  	 * This field should store a collection of all process identifiers.
  	 * For the sake of simplicity, we assume only one external here.
	 */
	private String processId;
	
	@XmlElement
	@XmlElementWrapper(name="receiptLines")
	
	@OneToMany(mappedBy="receipt", cascade = CascadeType.ALL, fetch = FetchType.EAGER)  @org.hibernate.annotations.Cascade(value=org.hibernate.annotations.CascadeType.DELETE_ORPHAN) 
	@JsonManagedReference 	
	private Set<ReceiptLine> receiptLines = new HashSet<ReceiptLine>();

	public Receipt() {

	}
	
	
	public Double calculateReceiptValue(){
		double s=0;
		for (ReceiptLine l:this.receiptLines)
			s=s+l.getPrice()*l.getQuantity();
		return s;
	}
	public void finalize() throws Throwable {
		super.finalize();
	}

	

	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public Date getReceiptDate() {
		return this.receiptDate;
	}

	

	public String getSpecialRequirements() {
		return this.specialRequirements;
	}

	/**
	 * 
	 * @param customerEmail
	 */
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	/**
	 * 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * 
	 * @param deliveryAddress
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * 
	 * @param orderDate
	 */
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	/**
	 * 
	 * @param specialRequirements
	 */
	public void setSpecialRequirements(String specialRequirements) {
		this.specialRequirements = specialRequirements;
	}

	/**
	 * 
	 * @param p
	 */
	public void addReceiptLine(ReceiptLine p){
		 this.receiptLines.add(p);
		 p.setReceipt(this);
	}

	public Set<ReceiptLine> getReceiptLines(){
		return this.receiptLines;
	}



	public String getProcessId() {
		return processId;
	}



	public void setProcessId(String processId) {
		this.processId = processId;
	}



	public void setReceiptLines(Set<ReceiptLine> receiptLines) {
		this.receiptLines = receiptLines;
	}


	public String getBankAccount() {
		return bankAccount;
	}


	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	
}// end Order