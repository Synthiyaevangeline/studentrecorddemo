package com.student.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Address {
	
		   @Id
		   @GeneratedValue
		   private Long id;
		   public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getZipCode() {
			return ZipCode;
		}
		public void setZipCode(String zipCode) {
			ZipCode = zipCode;
		}
		private String street;
		   private String city;
		   private String ZipCode;

}
