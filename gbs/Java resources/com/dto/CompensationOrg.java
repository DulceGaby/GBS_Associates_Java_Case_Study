package com.dto;

public class CompensationOrg {
	
	public CompensationOrg(String month, String monthText, String year, float amount) {
		super();
		this.month = month;
		this.monthText = monthText;
		this.year = year;
		this.amount = amount;
	}
	
	private String month;	

	private String monthText;

	private String year;
	
	private float amount;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getMonthText() {
		return monthText;
	}

	public void setMonthText(String monthText) {
		this.monthText = monthText;
	}

	@Override
	public String toString() {
		return "CompensationOrg [month=" + month + ", monthText=" + monthText + ", year=" + year + ", amount=" + amount
				+ "]";
	}
	
}
