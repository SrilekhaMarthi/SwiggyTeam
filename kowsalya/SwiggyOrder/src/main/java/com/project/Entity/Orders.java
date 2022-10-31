package com.project.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Orders {	
	@Id
	@GeneratedValue
	private int orderId;
	public double price;
	public double deliveryCharge;
	private int userId;
	private String userName;
	private int deliveryManId;
	private String deliveryPhoneNo;
	private String status;
	private String orderedON;
	private String updatedOn;
	private String PaymentMode;
	private String orderStatus;
	
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getPaymentMode() {
		return PaymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		PaymentMode = paymentMode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getDeliveryManId() {
		return deliveryManId;
	}
	public void setDeliveryManId(int i) {
		this.deliveryManId = i;
	}
	public String getDeliveryPhoneNo() {
		return deliveryPhoneNo;
	}
	public void setDeliveryPhoneNo(String deliveryPhoneNo) {
		this.deliveryPhoneNo = deliveryPhoneNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrderedON() {
		return orderedON;
	}
	public void setOrderedON(String orderedON) {
		this.orderedON = orderedON;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	public float getGST() {
		return GST;
	}
	public void setGST(float gST) {
		GST = gST;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price1) {
	price = price1;
	}
	public double getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(double deliveryCharge2) {
		deliveryCharge = deliveryCharge2;
	}
	public float GST=0.3f;
}		
	/*@OneToOne
	@JoinColumn(name="subTotal")
	private Cart cart;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	*/