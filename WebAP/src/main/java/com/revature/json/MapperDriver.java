package com.revature.json;

import com.revature.models.Address;

public class MapperDriver {
	
	public static void main(String[] args) {
		Address address = new Address("433 Will", "20C", "WonkaLand", "54567");
		
		Mapper m = new JsonMapper();
		String json = m.serialize(address);
		System.out.println(json);
		
		Address addressobj = m.deSerialize("{ \"street\" : \"433 Will\", \"apartment_number\" : \"20C\", \"city\" : \"WonkaLand\", \"zip\" : \"54567\" }", Address.class);
		System.out.println(addressobj);
		
	}

}
