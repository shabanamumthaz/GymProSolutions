package com.candella.entity;

import java.time.LocalDate;

public class Equipment {

		private int equipmentId;
		private String equipmentName;
		private String description;
		private LocalDate purchaseDate;
		private String equipmentCondition;
		private double equipmentPrice;
		public Equipment(int equipmentId, String equipmentName, String description, LocalDate purchaseDate,
				String equipmentCondition, double equipmentPrice) {
			super();
			this.equipmentId = equipmentId;
			this.equipmentName = equipmentName;
			this.description = description;
			this.purchaseDate = purchaseDate;
			this.equipmentCondition = equipmentCondition;
			this.equipmentPrice = equipmentPrice;
		}
		public int getEquipmentId() {
			return equipmentId;
		}
		public void setEquipmentId(int equipmentId) {
			this.equipmentId = equipmentId;
		}
		public String getEquipmentName() {
			return equipmentName;
		}
		public void setEquipmentName(String equipmentName) {
			this.equipmentName = equipmentName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public LocalDate getPurchaseDate() {
			return purchaseDate;
		}
		public void setPurchaseDate(LocalDate purchaseDate) {
			this.purchaseDate = purchaseDate;
		}
		public String getEquipmentCondition() {
			return equipmentCondition;
		}
		public void setEquipmentCondition(String equipmentCondition) {
			this.equipmentCondition = equipmentCondition;
		}
		public double getEquipmentPrice() {
			return equipmentPrice;
		}
		public void setEquipmentPrice(double equipmentPrice) {
			this.equipmentPrice = equipmentPrice;
		} 
		
		
}
