package com.dao;

import java.sql.*;
import java.util.ArrayList;

import org.json.JSONObject;

import com.model.UserInfoModel;

public class UserInfoDao
{
	
	public UserInfoDao() {
		new UserInfoDao();
	}
JSONObject s=null;
static Connection con =null;
public static void getConnection() throws ClassNotFoundException, SQLException {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://192.168.64.2:8080/crudapp","mysqlDB","123");
}
public JSONObject addUser(JSONObject o) {
try {
UserInfoDao.getConnection();
PreparedStatement psObj=con.prepareStatement("insert into userinfo(user_name,user_gender,user_dob,user_phone,user_email,user_address) values(?,?,?,?,?,?)");
psObj.setString(1, o.getString("userName"));
psObj.setString(2, o.getString("gender"));
psObj.setString(3, o.getString("dateOfBirth"));
psObj.setString(4, o.getString("phoneNumber"));
psObj.setString(5, o.getString("emailId"));
psObj.setString(6, o.getString("address"));
int i = psObj.executeUpdate();
s=new JSONObject();
s.append("status", i);
con.close();
}
catch(Exception e) {
System.out.println(e);
}
return s;
}
public JSONObject getUsersInfo() {
try
{
UserInfoDao.getConnection();
PreparedStatement ps=con.prepareStatement("select * from userinfo");  
         ResultSet rs=ps.executeQuery();  
ArrayList<UserInfoModel> userObj=new ArrayList<>();
         s=new JSONObject();
while(rs.next()){  
UserInfoModel modelObject= new UserInfoModel();
modelObject.setUserId(rs.getInt(1));
modelObject.setUserName(rs.getString(2));
modelObject.setGender(rs.getString(3));
modelObject.setUserDob(rs.getString(4));
modelObject.setPhoneNumber(rs.getString(5));
modelObject.setEmailId(rs.getString(6));
modelObject.setAddress(rs.getString(7));
userObj.add(modelObject);
        }  
s.append("data",userObj);
   con.close();
}
catch(Exception e){
System.out.println(e);
}
return s;
}
public JSONObject deleteUserInfo(JSONObject o) {
try {  
UserInfoDao.getConnection();
Integer userId= o.getInt("userId");
            PreparedStatement ps=con.prepareStatement("delete from userinfo where user_id=?");  
            ps.setInt(1, userId);
            int status=ps.executeUpdate();  
            s=new JSONObject();
s.append("status", status);
System.out.println(s);
            con.close();  
       }
catch(Exception e){
e.printStackTrace();
}
    return s;  
}
public JSONObject getUserInfoById(JSONObject o) {
UserInfoModel userObj=new UserInfoModel();
ArrayList<UserInfoModel> usersArr = new ArrayList<>();
try {  
UserInfoDao.getConnection();
Integer userId= o.getInt("userId");
            PreparedStatement ps=con.prepareStatement("select * from userinfo where user_id=?");
            ps.setInt(1,userId);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
            userObj.setUserId(rs.getInt(1));
                userObj.setUserName(rs.getString(2));  
                userObj.setGender(rs.getString(3));
                userObj.setUserDob(rs.getString(4));
                userObj.setPhoneNumber(rs.getString(5));
                userObj.setEmailId(rs.getString(6));
                userObj.setAddress(rs.getString(7));
                usersArr.add(userObj);
            }  
           
            s=new JSONObject();
s.append("status", usersArr);
System.out.println(s);
            con.close();  
       }
catch(Exception e){
e.printStackTrace();
}
    return s;  
}
public JSONObject updateUserInfo(JSONObject o) {
try {  
UserInfoDao.getConnection();
PreparedStatement ps=con.prepareStatement(  "update userinfo set user_name=?,user_gender=?,user_dob=?,user_phone=? , user_email=? , user_address=? where user_id=?");  
ps.setString(1,o.getString("userName"));  
ps.setString(2,o.getString("gender"));  
ps.setString(3,o.getString("dateOfBirth"));  
ps.setString(4,o.getString("phoneNumber"));  
ps.setString(5,o.getString("emailId"));  
ps.setString(6,o.getString("address"));  
ps.setInt(7,o.getInt("userId"));        
int status=ps.executeUpdate();
s=new JSONObject();
s.append("status", status);
System.out.println("status"+s);
con.close();  
}
catch(Exception ex) {
ex.printStackTrace();
}
return s;
}
}
