package com.westpac;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONObject;

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Hello World!" );
		String jsonString = "{\"errorDescription\":\":( :( :( Server is not happy to serve you better :) !!!!\",\"errorCode\":\"500\"}";
		HashMap<String,Object> mapValue=createHashMapFromJsonString(jsonString);
		System.out.println("Size of the Map:"+mapValue.size());
		mapValue.forEach((k,v)->System.out.println("Kay : " + k + " <===> Value : " + v.toString()));
		if(mapValue.containsKey(new String("errorCode")));
		System.out.println(mapValue.put("errorCode","10000"));
		mapValue.forEach((k,v)->System.out.println("Kay : " + k + " <===> Value : " + v.toString()));
		JSONObject obj=new JSONObject(mapValue);
		try (FileWriter file = new FileWriter("./\\src\\main\\resources\\300.JSON")) {
			file.write(obj.toJSONString());
			System.out.println("Successfully Copied JSON Object to File...");
			System.out.println("\nJSON Object: " + obj);
		}catch(IOException io) {
			io.printStackTrace();
		}
		
	}

	static JsonParser parser = new JsonParser();

	public static HashMap<String, Object> createHashMapFromJsonString(String json) {

		JsonObject object = (JsonObject) parser.parse(json);
		Set<Map.Entry<String, JsonElement>> set = object.entrySet();
		Iterator<Map.Entry<String, JsonElement>> iterator = set.iterator();
		HashMap<String, Object> map = new HashMap<String, Object>();

		while (iterator.hasNext()) {

			Map.Entry<String, JsonElement> entry = iterator.next();
			String key = entry.getKey();
			JsonElement value = entry.getValue();

			if (null != value) {
				if (!value.isJsonPrimitive()) {
					if (value.isJsonObject()) {

						map.put(key, createHashMapFromJsonString(value.toString()));
					} else if (value.isJsonArray() && value.toString().contains(":")) {

						List<HashMap<String, Object>> list = new ArrayList();
						JsonArray array = value.getAsJsonArray();
						if (null != array) {
							for (JsonElement element : array) {
								list.add(createHashMapFromJsonString(element.toString()));
							}
							map.put(key, list);
						}
					} else if (value.isJsonArray() && !value.toString().contains(":")) {
						map.put(key, value.getAsJsonArray());
					}
				} else {
					//System.out.println("Key:"+key +"<====> Value:" + value.getAsString());
					map.put(key, value.getAsString());
				}
			}
		}
		return map;
	}



}
