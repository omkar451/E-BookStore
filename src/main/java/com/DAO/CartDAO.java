package com.DAO;

import com.entity.Cart;
import java.util.List;

public interface CartDAO {
   boolean addCart(Cart var1);

   List<Cart> getBookByUser(int var1);

   boolean deleteBook(int var1, int var2, int var3);
}
