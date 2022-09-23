package com.example.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Payment {

	private int payId;
	private Date payDate;
	private Time payTime;
	private String payType;
	
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int payId, Date payDate, Time payTime, String payType) {
		super();
		this.payId = payId;
		this.payDate = payDate;
		this.payTime = payTime;
		this.payType = payType;
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public Time getPayTime() {
		return payTime;
	}
	public void setPayTime(Time payTime) {
		this.payTime = payTime;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	
	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", payDate=" + payDate + ", payTime=" + payTime + ", payType=" + payType
				+ "]";
	}
	
}
