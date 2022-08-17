package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Address;

public class AddressRepo {
	private List<Address> address;
	
	public AddressRepo() {
		Address address1 = new Address("123 Main", "Unit 80", "Raleigh", "27707");
		Address address2 = new Address("456 Smith", null, "Raleigh", "27707");
		Address address3 = new Address("789 Frank", null, "Raleigh", "27123");
		Address address4 = new Address("987 Thomas", "7A", "Chesterton", "27707");
		Address address5 = new Address("654 Washington", null, "Smithville", "12345");
		
		address = new ArrayList<>();
		
		address.add(address1);
		address.add(address2);
		address.add(address3);
		address.add(address4);
		address.add(address5);
		
	}
	
	public Address getAddressByCityFromDB(String City) {
		for (Address a:address) {
			if(City.equals(a.getCity())) {
				return a;
			}
		}
		return null;
	}
	

}
