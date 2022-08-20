package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Address;
import com.revature.utils.ConnectionUtil;



public class AddressDaoImpl implements AddressDAO {
	
	
	public Address getSingleAddressByID(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM address_book WHERE address_id = " + id +";";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			if(result.next()) {//resultSets are cursor based, each time.next is called the cursor moves to the
				   //next group of values. It starts one before so you always need to call next.
				Address AccountObject = new Address(
				result.getInt("address_id"),
				result.getString("street"),
				result.getString("apartment_number"),
				result.getString("city"),			
				result.getString("zip")
				);		
				System.out.println("Single address by ID\n\n");
				return AccountObject;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
	public List<Address> getAllAddress() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM address_book";
					
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			List<Address> accountList = new ArrayList<Address>();
		
			while(result.next()) { 					
				Address AccountObject = new Address(
						result.getInt("address_id"),
						result.getString("street"),
						result.getString("apartment_number"),
						result.getString("city"),			
						result.getString("zip")
						);												
						accountList.add(AccountObject);
					}		
			System.out.println("This is all addresses");
				return accountList;			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}

	public void insertAddress(Address address) {
		try(Connection conn = ConnectionUtil.getConnection()){		
			String sql = "INSERT INTO address_book (street, apartment_number, city, zip)" 
						+ " VALUES (?,?,?,?);";		
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			
			int count = 0;
			statement.setString(++count, address.getStreet());
			statement.setString(++count, address.getApartment());
			statement.setString(++count, address.getCity());
			statement.setString(++count, address.getZip());					
					
			statement.execute();
			
		}catch(SQLException e) {
		e.printStackTrace();
		}		
		
	}

	@Override
	public Address getAddressByCity(String City) {
		try(Connection conn = ConnectionUtil.getConnection()){		
			
				String sql = "SELECT * FROM address_book WHERE city = " + City +";";
				Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(sql);
				
				if(result.next()) {//resultSets are cursor based, each time.next is called the cursor moves to the
					   //next group of values. It starts one before so you always need to call next.
					Address AccountObject = new Address(
					result.getInt("address_id"),
					result.getString("street"),
					result.getString("apartment_number"),
					result.getString("city"),			
					result.getString("zip")
					);					
					System.out.println("This is get address by city");
					return AccountObject;
			}
						
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}

	@Override
	public void deleteAddress(Address address) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM address_book WHERE address_id = " + address.getAddressId() + ";";
			PreparedStatement statement = conn.prepareStatement(sql);				
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateAddress(Address address) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE address_book SET city = " + "'" + address.getCity() + "'" + 
					", street = "+ "'" + address.getStreet()+ "'" + 
					", zip = " + "'"+ address.getZip() + "'" +
					", apartment_number = " + "'" + address.getApartment() + "'" +
					" WHERE address_id = "+ "'" + address.getAddressId()+ "'" + ";";
			PreparedStatement statement = conn.prepareStatement(sql);			
			statement.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
		
}
