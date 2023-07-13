package com.entity;

public class BookDtls {
   private int bookId;
   private String bookName;
   private String author;
   private String price;
   private String bookCategory;
   private String status;
   private String photoName;
   private String email;

   public BookDtls() {
   }

   public BookDtls(String bookName, String author, String price, String bookCategory, String status, String photoName, String email) {
      this.bookName = bookName;
      this.author = author;
      this.price = price;
      this.bookCategory = bookCategory;
      this.status = status;
      this.photoName = photoName;
      this.email = email;
   }

   public int getBookId() {
      return this.bookId;
   }

   public void setBookId(int bookId) {
      this.bookId = bookId;
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

   public String getPrice() {
      return this.price;
   }

   public void setPrice(String price) {
      this.price = price;
   }

   public String getBookCategory() {
      return this.bookCategory;
   }

   public void setBookCategory(String bookCategory) {
      this.bookCategory = bookCategory;
   }

   public String getStatus() {
      return this.status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getPhotoName() {
      return this.photoName;
   }

   public void setPhotoName(String photoName) {
      this.photoName = photoName;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String toString() {
      return "BookDtls [bookId=" + this.bookId + ", bookName=" + this.bookName + ", author=" + this.author + ", price=" + this.price + ", bookCategory=" + this.bookCategory + ", status=" + this.status + ", photoName=" + this.photoName + ", email=" + this.email + "]";
   }
}
