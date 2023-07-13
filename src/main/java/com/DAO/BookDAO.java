package com.DAO;

import com.entity.BookDtls;
import java.util.List;

public interface BookDAO {
   boolean addBooks(BookDtls var1);

   List<BookDtls> getAllBooks();

   BookDtls getBookById(int var1);

   boolean updateEditBooks(BookDtls var1);

   boolean deleteBooks(int var1);

   List<BookDtls> getNewBook();

   List<BookDtls> getRecentBook();

   List<BookDtls> getOldBook();

   List<BookDtls> getAllRecentBook();

   List<BookDtls> getAllNewBook();

   List<BookDtls> getAllOldBook();

   List<BookDtls> getBookByOld(String var1, String var2);

   boolean OldBookDelete(String var1, String var2, int var3);

   List<BookDtls> getBookBySearch(String var1);
}
