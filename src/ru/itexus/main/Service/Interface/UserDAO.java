package ru.itexus.main.Service.Interface;

import ru.itexus.main.Models.User;

import java.util.List;

public interface UserDAO {


    /**
     * You can also divide the methods into interfaces for the DML and DDL commands
     */

    List<User> showAll();
    void showUserInformation(int id);
    void saveUser(User user);
    void deleteUser(int id);
    void editUser(int id);
}
