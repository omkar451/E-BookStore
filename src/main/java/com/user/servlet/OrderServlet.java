package com.user.servlet;

import com.DAO.BookOrderImpl;
import com.DAO.CartDAOImpl;
import com.DB.DBconnect;
import com.entity.Book_Order;
import com.entity.Cart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/order"})
public class OrderServlet extends HttpServlet {
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      try {
         HttpSession session = req.getSession();
         int id = Integer.parseInt(req.getParameter("id"));
         String name = req.getParameter("username");
         String email = req.getParameter("email");
         String phno = req.getParameter("phno");
         String address = req.getParameter("address");
         String landmark = req.getParameter("landmark");
         String city = req.getParameter("city");
         String state = req.getParameter("state");
         String pincode = req.getParameter("pincode");
         String paymentType = req.getParameter("payment");
         String fullAdd = address + "," + landmark + "," + city + "," + state + "," + pincode;
         CartDAOImpl dao = new CartDAOImpl(DBconnect.getConn());
         List<Cart> blist = dao.getBookByUser(id);
         if (blist.isEmpty()) {
            session.setAttribute("failedMsg", "Add Item");
            resp.sendRedirect("checkout.jsp");
         } else {
            BookOrderImpl dao2 = new BookOrderImpl(DBconnect.getConn());
            Book_Order o = null;
            ArrayList<Book_Order> orderList = new ArrayList();
            Random r = new Random();
            Iterator var22 = blist.iterator();

            while(var22.hasNext()) {
               Cart c = (Cart)var22.next();
               o = new Book_Order();
               o.setOrderId("BOOK-ORD-00" + r.nextInt(1000));
               o.setUserName(name);
               o.setEmail(email);
               o.setPhno(phno);
               o.setFulladd(fullAdd);
               o.setBookName(c.getBookName());
               o.setAuthor(c.getAuthor());
               o.setPrice("" + c.getPrice());
               o.setPaymentType(paymentType);
               orderList.add(o);
            }

            if ("noselect".equals(paymentType)) {
               session.setAttribute("failedMsg", "Choose Payment Method");
               resp.sendRedirect("checkout.jsp");
            } else {
               boolean f = dao2.saveOrder(orderList);
               if (f) {
                  resp.sendRedirect("order_success.jsp");
               } else {
                  session.setAttribute("failedMsg", "Your Order Failed");
                  resp.sendRedirect("checkout.jsp");
               }
            }
         }
      } catch (Exception var23) {
         var23.printStackTrace();
      }

   }
}
