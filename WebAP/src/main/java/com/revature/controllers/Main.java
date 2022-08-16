package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the address book.");
		System.out.println("Please type a number to select from the following menu.");
		System.out.println("1. Print all addresses in the book");
		System.out.println("2. Search for an address by zip code");
		System.out.println("3. Add an address to the book.");
		System.out.println("4. Delete an address from the book");
		System.out.println("5. Shutdown program");		
		String answer = scan.nextLine();
		int answerNum = Integer.parseInt(answer);
		
		switch(answerNum) {
			
			case 1:
				//select all records
				
			case 2:
				//Select all record where zipcode = input
				
			case 3: 
				//collect data, insert into database
				
			case 4:
				//select by id, delete from database
				
			case 5:
				System.out.println("Thank you, have a nice day!");
				System.exit(0);
			
		}	
		//Stream a list
//		public static List<Address> AddressZipLookUp(List<Book> stock, String firstName, String lastName){
//			List<Book> result = stock.stream()
//					.filter((book)->{return
//						(book.getAuthorFirstName().equals(firstName)&& book.getAuthorLastName().equals(lastName));})
//					.map((book)->{
//						book.setPrice(book.getPrice()* 0.8);
//						return book;
//					})
//					.toList();
//			
//			return result;
//			
//		}
		
		
		
	}
}
