package com.revature.json;

public interface Mapper {
	
	public String serialize(Object o);
    public <T> T deSerialize(String str, Class<T> clazz);

}
