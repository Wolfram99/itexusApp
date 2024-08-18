package ru.itexus.main.Service.Interface;

import ru.itexus.main.Models.User;

import java.util.List;

public interface WriteObject {

    void write(User user, boolean append);
    void write(List<User> listUsers, boolean append);
}
