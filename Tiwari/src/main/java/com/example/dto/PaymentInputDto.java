package com.example.dto;

import java.sql.Time;
import java.util.Date;

public class PaymentInputDto {
	private Date payDate;
	private Time payTime;
	private String payType;
	public Date getPayDate() {
		return payDate;
	}
	public Time getPayTime() {
		return payTime;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public void setPayTime(Time payTime) {
		this.payTime = payTime;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}

}
