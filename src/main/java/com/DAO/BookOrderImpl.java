package com.DAO;

import com.entity.Book_Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookOrderImpl implements BookOrderDAO {
   private Connection conn;

   public BookOrderImpl(Connection conn) {
      this.conn = conn;
   }

   public boolean saveOrder(List<Book_Order> blist) {
      boolean f = false;

      try {
         String sql = "insert into book_order(order_id, user_name, email,address,phno,book_name,author,price,payment)values(?,?,?,?,?,?,?,?,?)";
         this.conn.setAutoCommit(false);
         PreparedStatement ps = this.conn.prepareStatement(sql);
         Iterator var6 = blist.iterator();

         while(var6.hasNext()) {
            Book_Order b = (Book_Order)var6.next();
            ps.setString(1, b.getOrderId());
            ps.setString(2, b.getUserName());
            ps.setString(3, b.getEmail());
            ps.setString(4, b.getFulladd());
            ps.setString(5, b.getPhno());
            ps.setString(6, b.getBookName());
            ps.setString(7, b.getAuthor());
            ps.setString(8, b.getPrice());
            ps.setString(9, b.getPaymentType());
            ps.addBatch();
         }

         int[] count = ps.executeBatch();
         this.conn.commit();
         f = true;
         this.conn.setAutoCommit(true);
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      return f;
   }

   public List<Book_Order> getBook(String email) {
      List<Book_Order> list = new ArrayList();
      Book_Order o = null;

      try {
         String sql = "select * from book_order where email =?";
         PreparedStatement ps = this.conn.prepareStatement(sql);
         ps.setString(1, email);
         ResultSet rs = ps.executeQuery();

         while(rs.next()) {
            o = new Book_Order();
            o.setId(rs.getInt(1));
            o.setOrderId(rs.getString(2));
            o.setUserName(rs.getString(3));
            o.setEmail(rs.getString(4));
            o.setFulladd(rs.getString(5));
            o.setPhno(rs.getString(6));
            o.setBookName(rs.getString(7));
            o.setAuthor(rs.getString(8));
            o.setPrice(rs.getString(9));
            o.setPaymentType(rs.getString(10));
            list.add(o);
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      return list;
   }

   public List<Book_Order> getAllOrder() {
      List<Book_Order> list = new ArrayList();
      Book_Order o = null;

      try {
         String sql = "select * from book_order ";
         PreparedStatement ps = this.conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();

         while(rs.next()) {
            o = new Book_Order();
            o.setId(rs.getInt(1));
            o.setOrderId(rs.getString(2));
            o.setUserName(rs.getString(3));
            o.setEmail(rs.getString(4));
            o.setFulladd(rs.getString(5));
            o.setPhno(rs.getString(6));
            o.setBookName(rs.getString(7));
            o.setAuthor(rs.getString(8));
            o.setPrice(rs.getString(9));
            o.setPaymentType(rs.getString(10));
            list.add(o);
         }
      } catch (Exception var6) {
         var6.printStackTrace();
      }

      return list;
   }
}
