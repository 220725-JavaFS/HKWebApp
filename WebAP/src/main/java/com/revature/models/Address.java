package com.revature.models;

import java.util.Objects;

public class Address {	
		private int AddressId;
		private String Street;
		private String Apartment;
		private String City;
		private String Zip;
		public Address(int addressId, String street, String apartment, String city, String zip) {
			super();
			AddressId = addressId;
			Street = street;
			Apartment = apartment;
			City = city;
			Zip = zip;
		}
		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Address(String street, String apartment, String city, String zip) {
			super();
			Street = street;
			Apartment = apartment;
			City = city;
			Zip = zip;
		}
		public int getAddressId() {
			return AddressId;
		}
		public void setAddressId(int addressId) {
			AddressId = addressId;
		}
		public String getStreet() {
			return Street;
		}
		public void setStreet(String street) {
			Street = street;
		}
		public String getApartment() {
			return Apartment;
		}
		public void setApartment(String apartment) {
			Apartment = apartment;
		}
		public String getCity() {
			return City;
		}
		public void setCity(String city) {
			City = city;
		}
		public String getZip() {
			return Zip;
		}
		public void setZip(String zip) {
			Zip = zip;
		}
		@Override
		public int hashCode() {
			return Objects.hash(AddressId, Apartment, City, Street, Zip);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Address other = (Address) obj;
			return AddressId == other.AddressId && Objects.equals(Apartment, other.Apartment)
					&& Objects.equals(City, other.City) && Objects.equals(Street, other.Street)
					&& Objects.equals(Zip, other.Zip);
		}
		@Override
		public String toString() {
			return "Address [AddressId=" + AddressId + ", Street=" + Street + ", Apartment=" + Apartment + ", City=" + City
					+ ", Zip=" + Zip + "]";
		}
		
		
		

}
