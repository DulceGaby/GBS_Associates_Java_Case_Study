package com.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compensation")
public class Compensation {
	
	@Override
	public String toString() {
		return "Compensation [id=" + id + ", type=" + type + ", description=" + description + ", date=" + date
				+ ", idEmployee=" + idEmployee + ", amount=" + amount + "]";
	}
	
	@Id
	private int id;
	private String type;
	private String description;
	private String date;
	private int idEmployee;
	private float amount;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

}
