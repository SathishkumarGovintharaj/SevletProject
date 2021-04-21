package com.model;

public class UserInfoModel
{
private int userId;
private String userName , gender, userDob, phoneNumber, emailId, address;
public int getUserId() {
return userId;
}
public void setUserId(int userId) {
this.userId = userId;
}
public String getUserName() {
return userName;
}
public void setUserName(String userName) {
this.userName = userName;
}
public String getGender() {
return gender;
}
public void setGender(String gender) {
this.gender = gender;
}
public String getUserDob() {
return userDob;
}
public void setUserDob(String userDob) {
this.userDob = userDob;
}
public String getPhoneNumber() {
return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}
public String getEmailId() {
return emailId;
}
public void setEmailId(String emailId) {
this.emailId = emailId;
}
public String getAddress() {
return address;
}
public void setAddress(String address) {
this.address = address;
}
@Override
public String toString() {
return "{ userId:" + userId + ", userName:" + userName + ", gender:" + gender + ", userDob:"
+ userDob + ", phoneNumber:" + phoneNumber + ", emailId:" + emailId + ", address:" + address + "}";
}
}