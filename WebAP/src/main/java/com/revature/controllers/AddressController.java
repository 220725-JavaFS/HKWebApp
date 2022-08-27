package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.json.JsonMapper;
import com.revature.models.Address;
import com.revature.services.AddressService;



public class AddressController extends HttpServlet{

	private AddressService addressService = new AddressService();
	private ObjectMapper objectMapper = new ObjectMapper();
	private JsonMapper mapper = new JsonMapper();
	private static Logger log = LoggerFactory.getLogger(Address.class);
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		
		List<Address> list = addressService.AddressAssemble();			
		PrintWriter printWriter = response.getWriter();
		for(Object o:list) {
			String mapped = mapper.serialize(o);
			printWriter.print(mapped);
			log.info(mapped);
		}
		//CALL ORM HERE ^^^^^	
		
		response.setStatus(200);		
		response.setContentType("application/json");
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		
		while(line!=null) {
			sb.append(line);
			line=reader.readLine();
		}
		
		String json = new String(sb);
		System.out.println(json);
		Address address = objectMapper.readValue(json, Address.class);
		PrintWriter printWriter = response.getWriter();
		//CALL ORM HERE
		addressService.recruitAddress(address);;
		String mapped = mapper.serialize(address);
		
		// Using Stream builder()
        Stream.Builder<String> builder = Stream.builder();
  
        // Adding elements in the stream of Strings
        Stream<String> stream = builder.add(mapped).build();
  
        // Displaying the elements in the stream
        System.out.println("This is what you added.");
        stream.forEach(System.out::println);
		
		printWriter.print("You have created " + mapped);
		response.setStatus(200);
		
		
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		
		while(line!=null) {
			sb.append(line);
			line=reader.readLine();
		}
		
		String json = new String(sb);
		
		Address address = objectMapper.readValue(json,  Address.class);
		PrintWriter printWriter = response.getWriter();
		//CALL ORM HERE
		addressService.DeleteAddress(address);;
		String mapped = mapper.serialize(address);
		log.info("This is what you updated" +mapped);
		printWriter.print("You have deleted " + mapped);
		response.setStatus(200);
		
		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		
		while(line!=null) {
			sb.append(line);
			line=reader.readLine();
		}
		
		String json = new String(sb);
		System.out.println("Updated " + json);
		Address address = objectMapper.readValue(json,  Address.class);
		PrintWriter printWriter = response.getWriter();
		//CALL ORM HERE
		addressService.updateAddress(address);;
		String mapped = mapper.serialize(address);
		
		log.info("This is what you updated" +mapped);
		printWriter.print("You have updated " + mapped);
		response.setStatus(200);
	}
	
	protected void doGet2(HttpServletRequest request, HttpServletResponse response ) throws ServletException,IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		
		while(line!=null) {
			sb.append(line);
			line=reader.readLine();
		}
		
		String json = new String(sb);
		Address address = objectMapper.readValue(json,  Address.class);
		String mapped = mapper.serialize(address);
		addressService.doGet2(mapped, address);
	}
	
}
