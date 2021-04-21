package com.controller;

import org.json.JSONObject;

public class ControllerAssistant {

	
	public static void getResponse() throws InstantiationException, IllegalAccessException {
		
		
		//String id =o.getString("daoclass");
		//String methodName = o.getString("method");
		
		//String daoClassName = RoutingReader.getRouterFile("id");
		
		 try
	        {
	            Class cls = Class.forName("UserInfoDao");
	            Object o = cls.getConstructors();
	            
	            
	            
	            System.out.println(o);
	        }
	        catch (ClassNotFoundException e)
	        {
	            e.printStackTrace();
	        }
		//return o;
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		ControllerAssistant.getResponse();
		
	}
	
}
