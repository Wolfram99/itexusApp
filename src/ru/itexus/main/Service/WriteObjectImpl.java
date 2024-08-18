package ru.itexus.main.Service;

import ru.itexus.main.Models.User;
import ru.itexus.main.Service.Interface.WriteObject;

import java.io.*;
import java.util.List;

public class WriteObjectImpl implements WriteObject {
    private File file;


    public WriteObjectImpl(File file) {
        this.file = file;

    }

    public void write(User user, boolean append) {
        try (
                FileOutputStream fos = new FileOutputStream(file, append);
                ObjectOutputStream moos = new MyObjectOutputStream(fos, append);
        ) {
            moos.writeObject(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void write(List<User> listUsers, boolean append) {
        try (
                FileOutputStream fos = new FileOutputStream(file, append);
                ObjectOutputStream moos = new MyObjectOutputStream(fos, append);
        ) {
            for (User user : listUsers) {
                moos.writeObject(user);
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}