package com.entity;

public class User {
   private int id;
   private String name;
   private String email;
   private String password;
   private String phno;
   private String address;
   private String landmark;
   private String city;
   private String state;
   private String pincode;

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String toString() {
      return "User [id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", password=" + this.password + ", phno=" + this.phno + ", address=" + this.address + ", landmark=" + this.landmark + ", city=" + this.city + ", state=" + this.state + ", pincode=" + this.pincode + "]";
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getPhno() {
      return this.phno;
   }

   public void setPhno(String phno) {
      this.phno = phno;
   }

   public String getAddress() {
      return this.address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getLandmark() {
      return this.landmark;
   }

   public void setLandmark(String landmark) {
      this.landmark = landmark;
   }

   public String getCity() {
      return this.city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return this.state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getPincode() {
      return this.pincode;
   }

   public void setPincode(String pincode) {
      this.pincode = pincode;
   }
}
