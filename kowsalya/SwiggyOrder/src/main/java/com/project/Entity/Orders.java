package com.project.Entity;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Orders extends Auditable{	
	@Id
	@GeneratedValue
	private long orderId;
	public double price;
	public double deliveryCharge;
	private String userId;
	private String userName;
	private int deliveryManId;
	private String deliveryPhoneNo;
	public enum status{
		PREPEARING,ONTHEWAYTODELIVERY,DELIVERED;
	}
	private enum paymentMode{
		COD;
	}
	private enum orderStatus{
		ACTIVE,CANCELED;
	}
	@Enumerated(EnumType.STRING)
	private status status;
	@Enumerated(EnumType.STRING)
	private paymentMode paymentMode;
	@Enumerated(EnumType.STRING)
	private orderStatus orderStatus;
	
	static String getAlphaNumericString(int n)
	{
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(10);
		for (int i = 0; i < n; i++) 
		{
		   int index= (int)(AlphaNumericString.length()* Math.random());
		   sb.append(AlphaNumericString.charAt(index));
		}	 
		return sb.toString(); 
	}
	public orderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(orderStatus orderStatus) {
		this.orderStatus = orderStatus.ACTIVE;
	}
	public paymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(paymentMode paymentMode) {
		this.paymentMode = paymentMode.COD;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
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
	public status getStatus() {
		return status;
	}
	public void setStatus(status status) {
		this.status = status.PREPEARING;
	}
	public float getGST() {
		return GST;
	}
	public void setGST(float gST) {
		GST = gST;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long string) {
		this.orderId = string;
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