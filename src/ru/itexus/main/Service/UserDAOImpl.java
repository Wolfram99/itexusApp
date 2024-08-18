package ru.itexus.main.Service;


import ru.itexus.main.CustomException.ValidException;
import ru.itexus.main.Models.User;
import ru.itexus.main.Service.Interface.ReadObject;
import ru.itexus.main.Service.Interface.UserDAO;
import ru.itexus.main.Service.Interface.WriteObject;


import java.io.*;
import java.util.List;
import java.util.Scanner;

public class UserDAOImpl implements UserDAO {
    private static final String PATH_TO_FILE = "User.txt";
    private File file = new File(PATH_TO_FILE);
    private Scanner sc;
    private ReadObject readObject = new ReadObjectImpl(file);
    private WriteObject writeObject = new WriteObjectImpl(file);


    public UserDAOImpl(Scanner sc) {
        this.sc = sc;
      }


    public void saveUser(User user){
        boolean append = file.exists();
        writeObject.write(user, append);
    }



    public List<User> showAll(){
        System.out.printf("%s | %s%n", "id", "User Information");
        int serialNumber = 0;
        List<User> listUsers = readObject.readAll();
        for (User user : listUsers) {
            System.out.printf("%d | %s%n", ++serialNumber, user.toString());
        }
        return listUsers;
    }

    public void deleteUser(int id){

        List<User> tempList = readObject.readAll();
        if(validInputNumber(id, tempList.size())) {
            tempList.remove(id - 1);
            writeObject.write(tempList, false);
        }
    }

    public User findUserById(int id){
        return readObject.readAll().get(id-1);
    }

    public void showUserInformation(int id){
        List<User> tempList = readObject.readAll();
        if(validInputNumber(id, tempList.size())) {
                OperationsOnUsers.showUserInformation(findUserById(id));
        }

    }
    

    public void editUser(int id){

        List<User> tempList = readObject.readAll();
        if(validInputNumber(id, tempList.size())) {

            User editUser = OperationsOnUsers.editUser(sc, tempList.get(id - 1));
            tempList.remove(id - 1);

            tempList.add(id - 1, editUser);
            writeObject.write(tempList, false);
        }
    }



    public static void validInputInteger(Scanner sc){
        while (!sc.hasNextInt()) {
            System.out.println("You have entered a text value, you must enter an integer value!");
            sc.nextLine();
        }
    }

    private static boolean validInputNumber(int inputNumber, int numberOfEntries){
        if(inputNumber - 1 >= 0 && inputNumber - 1 <= numberOfEntries - 1){
            return true;
        }

        try {
            throw new ValidException("The entered value is incorrect!");

        } catch ( ValidException e) {

            System.out.println(e.getMessage());
            return false;
        }

    }

}
