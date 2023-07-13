package com.entity;

public class Book_Order {
   private int id;
   private String orderId;
   private String userName;
   private String email;
   private String phno;
   private String fulladd;
   private String bookName;
   private String author;
   private String price;
   private String paymentType;

   public String getBookName() {
      return this.bookName;
   }

   public void setBookName(String bookName) {
      this.bookName = bookName;
   }

   public String getAuthor() {
      return this.author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   public String getPrice() {
      return this.price;
   }

   public void setPrice(String price) {
      this.price = price;
   }

   public String getOrderId() {
      return this.orderId;
   }

   public void setOrderId(String orderId) {
      this.orderId = orderId;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhno() {
      return this.phno;
   }

   public void setPhno(String phno) {
      this.phno = phno;
   }

   public String getFulladd() {
      return this.fulladd;
   }

   public void setFulladd(String fulladd) {
      this.fulladd = fulladd;
   }

   public String getPaymentType() {
      return this.paymentType;
   }

   public void setPaymentType(String paymentType) {
      this.paymentType = paymentType;
   }

   public String toString() {
      return "Book_Order [id=" + this.id + ", userName=" + this.userName + ", email=" + this.email + ", phno=" + this.phno + ", fulladd=" + this.fulladd + ", paymentType=" + this.paymentType + "]";
   }
}
