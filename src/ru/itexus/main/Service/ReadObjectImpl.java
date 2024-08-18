package ru.itexus.main.Service;

import ru.itexus.main.Models.User;
import ru.itexus.main.Service.Interface.ReadObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadObjectImpl implements ReadObject {
    private File file;

    public ReadObjectImpl(File file) {
        this.file = file;
    }


    public List<User> readAll() {
        List<User> readList = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            while (true)
                readList.add((User) ois.readObject());
        } catch (ClassNotFoundException | IOException e) {
            // EOFException
        }

        return readList;
    }

}