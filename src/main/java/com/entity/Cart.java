package com.entity;

public class Cart {
   private int cid;
   private int bid;
   private int userid;
   private String bookName;
   private String author;
   private Double price;
   private Double totalPrice;

   public int getCid() {
      return this.cid;
   }

   public void setCid(int cid) {
      this.cid = cid;
   }

   public int getBid() {
      return this.bid;
   }

   public void setBid(int bid) {
      this.bid = bid;
   }

   public int getUserid() {
      return this.userid;
   }

   public void setUserid(int userid) {
      this.userid = userid;
   }

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

   public Double getPrice() {
      return this.price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public Double getTotalPrice() {
      return this.totalPrice;
   }

   public void setTotalPrice(Double totalPrice) {
      this.totalPrice = totalPrice;
   }
}
