package com.project.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="delivery_man_details")
	public class DeliveryMan {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int deliveryManId;
		private String deliveryManPhoneNo;
		private String deliveryManName;
		private String deliveryManLocation;

		public int getDeliveryManId() {
			return deliveryManId;
		}
		public void setDeliveryManId(int deliveryManId) {
			this.deliveryManId = deliveryManId;
		}
		public String getDeliveryManPhoneNo() {
			return deliveryManPhoneNo;
		}
		public void setDeliveryManPhoneNo(String deliveryManPhoneNo) {
			this.deliveryManPhoneNo = deliveryManPhoneNo;
		}
		public String getDeliveryManName() {
			return deliveryManName;
		}
		public void setDeliveryManName(String deliveryManName) {
			this.deliveryManName = deliveryManName;
		}
		public String getDeliveryManLocation() {
			return deliveryManLocation;
		}
		public void setDeliveryManLocation(String deliveryManLocation) {
			this.deliveryManLocation = deliveryManLocation;
		}	
}