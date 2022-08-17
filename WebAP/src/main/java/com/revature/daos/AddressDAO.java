package com.revature.daos;

import java.util.List;


import com.revature.models.Address;

public interface AddressDAO {
	
	public abstract Address getSingleAddressByID(int id);
	public abstract Address getAddressByCity(String City);	
	List<Address> getAllAddress();
	public abstract void insertAddress(Address address);	
	public abstract void deleteAddress(int id);
}
