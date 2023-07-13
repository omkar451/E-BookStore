package com.DAO;

import com.entity.User;

public interface UserDAO {
   boolean userRegister(User var1);

   User login(String var1, String var2);

   boolean checkPassword(int var1, String var2);

   boolean updateProfile(User var1);

   boolean checkUser(String var1);
}
