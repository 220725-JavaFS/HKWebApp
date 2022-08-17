package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Address;
import com.revature.services.AddressService;


public class AddressController extends HttpServlet{

	private AddressService addressService = new AddressService();
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		
		List<Address> list = addressService.AddressAssemble();
		
		String json = objectMapper.writeValueAsString(list);
		System.out.println(json);
		
		PrintWriter printWriter = response.getWriter();
		
		printWriter.print(json);
		
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
		Address address = objectMapper.readValue(json,  Address.class);
		addressService.recruitAddress(address);;
		
		response.setStatus(201);
		
		
	}
	
	
}
