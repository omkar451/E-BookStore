package com.DAO;

import com.entity.Book_Order;
import java.util.List;

public interface BookOrderDAO {
   boolean saveOrder(List<Book_Order> var1);

   List<Book_Order> getBook(String var1);

   List<Book_Order> getAllOrder();
}
