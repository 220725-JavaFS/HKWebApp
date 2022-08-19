package com.revature.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import com.revature.models.Address;



public class ReflectionDriver {
	
	public static void main(String[] args) {
		// { "authorFirstName" : "Eion", "authorLastName" : "Colfer", "title" : "Artimis Fowl", "price" : 25.00 }
		Address a = new Address("433 Will", "20C", "WonkaLand", "54567");
		Class<?> c1 = a.getClass();
		Class<Address> c2 = Address.class;
	
		
		Field[] fields = c1.getDeclaredFields();
		for(Field f: fields) {
			System.out.println(f.getName());
		}
		
		System.out.println("-------");
		
		Method[] methods = c1.getDeclaredMethods();
		for(Method m: methods) {
			System.out.println(m);
		}
		
		System.out.println("-------");

		System.out.println("We're working with class: "+c1.getName()+", it's superclass is: "+c1.getSuperclass());
		Class<?>[] implementingInterfaces = c1.getInterfaces();
		System.out.println(Arrays.toString(implementingInterfaces));
		for(Class<?> interf: implementingInterfaces) {
			System.out.println(interf);
		}
		
		
		printMediaType(a);
		
		
	}
	
	public static void printMediaType(Object o) {
		if(o.getClass() == Address.class) {
			System.out.println("You have picked a movie");
		} else if (o.getClass() == Address.class) {
			System.out.println("You have picked a book");
		} else {
			System.out.println("Unsupported media type");
		}
	}
	

}
