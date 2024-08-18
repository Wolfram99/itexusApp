package ru.itexus.main.Service.Interface;

import ru.itexus.main.Models.User;

public interface UserDAO {


    /**
     * You can also divide the methods into interfaces for the DML and DDL commands
     */

    int showAll();
    void saveUser(User user);
    void deleteUser(int id);
    void editUser(int id);
}
