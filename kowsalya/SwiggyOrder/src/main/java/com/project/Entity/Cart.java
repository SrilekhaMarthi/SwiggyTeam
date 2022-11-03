package com.project.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue
	private int userId;
	private int subTotal;	
	private String finalLocation;
	public String getFinalLocation() {
		return finalLocation;
	}
	public void setFinalLocation(String finalLocation) {
		this.finalLocation = finalLocation;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public  int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}
}