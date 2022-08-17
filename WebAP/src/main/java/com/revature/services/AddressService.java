package com.revature.services;

import java.util.List;

import com.revature.daos.AddressDAO;
import com.revature.daos.AddressDaoImpl;
import com.revature.models.Address;
import com.revature.repo.AddressRepo;

public class AddressService {
	
	private AddressRepo addressRepo;
	
	public AddressService(AddressRepo addressRepo) {
		super();
		this.addressRepo = addressRepo;
	}
	
	public AddressService() {
		this.addressRepo = new AddressRepo();
	}
	
	public Address getAddressByCity(String City) {
		Address a = addressRepo.getAddressByCityFromDB(City);
		return a;
	}
private AddressDAO addressDao = new AddressDaoImpl();
	
	public Address getSingleAddress(int id) {		
		return addressDao.getSingleAddressByID(id);
		
	}
	public List<Address> AddressAssemble(){
		return addressDao.getAllAddress();
	}
	
	public void recruitAddress(Address address) {
		addressDao.insertAddress(address);
	}
	
}
