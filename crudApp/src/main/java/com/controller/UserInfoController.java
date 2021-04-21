package com.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dao.UserInfoDao;


public class UserInfoController extends HttpServlet {
private static final long serialVersionUID = 1L;
UserInfoDao daoObj=null;
public static JSONObject requestObject(HttpServletRequest request, HttpServletResponse response) throws IOException {
String requestObj = "";
    BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
    if(br != null) {
    requestObj = br.readLine();
}
   
    System.out.println("Request Obj: "+requestObj);
   
    JSONObject jsonObj = null ;
   
    JSONArray jsonArray = new JSONArray("["+requestObj+"]");
   
    for(int i=0;i<jsonArray.length();i++) {
    jsonObj = jsonArray.getJSONObject(i);
    }
    return jsonObj;
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
daoObj=new UserInfoDao();
JSONObject dao  = daoObj.addUser(UserInfoController.requestObject(request, response));
response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
       response.getWriter().write(dao.toString());
}
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	daoObj=new UserInfoDao();
	JSONObject getUser=new JSONObject();

   getUser = daoObj.getUsersInfo();
   System.out.println(getUser);

response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
       response.getWriter().write(getUser.toString());
}
protected void doDelete(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
daoObj=new UserInfoDao();
JSONObject dao  =daoObj.deleteUserInfo(UserInfoController.requestObject(request, response));
response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
       response.getWriter().write(dao.toString());
}
protected void doPut(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
daoObj=new UserInfoDao();
JSONObject getUserById =new JSONObject();
JSONObject getResponse = UserInfoController.requestObject(request, response);
String action=getResponse.getString("action");
if(action.equalsIgnoreCase("updateUserInfo")) {
getUserById = daoObj.updateUserInfo(getResponse);
} else {
getUserById  = daoObj.getUserInfoById(getResponse);
}
response.setContentType("application/json");
      response.setCharacterEncoding("UTF-8");
       response.getWriter().write(getUserById.toString());
}
}