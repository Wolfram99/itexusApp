package ru.itexus.main;

import ru.itexus.main.CustomException.ValidException;
import ru.itexus.main.Service.*;
import ru.itexus.main.Service.Interface.UserDAO;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static final String HEADER_MENU = """
				--------------------------------------------------------------
				Enter the sequence number of the operation you want to perform:
				(Enter an integer!)
				--------------------------------------------------------------
				1) Create User.
				2) Edit User.
				3) Delete User.
				4) Show User by id
				5) Show all User.
				6) Exit.
				""";



    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        UserDAO dao = new UserDAOImpl(sc);

        boolean active = true;


        while (active) {

            System.out.println(HEADER_MENU);
            UserDAOImpl.validInputInteger(sc);

            int idOperation = sc.nextInt();
            sc.nextLine();

            switch (idOperation) {
                case 1 -> dao.saveUser(OperationsOnUsers.createUser(sc));
                case 2 ->{
                    System.out.println("Enter the serial number of the user you want to update: ");
                    dao.showAll();
                    UserDAOImpl.validInputInteger(sc);
                    dao.editUser(sc.nextInt());
                }
                case 3 ->{
                    System.out.println("Enter the serial number of the user you want to delete: ");
                    dao.showAll();
                    UserDAOImpl.validInputInteger(sc);
                    dao.deleteUser(sc.nextInt());

                    sc.nextLine();
                }
                case 4 -> {
                    System.out.println("Enter the serial number of the user whose information you want to view: ");
                    dao.showAll();
                    UserDAOImpl.validInputInteger(sc);
                    dao.showUserInformation(sc.nextInt());
                }
                case 5 -> dao.showAll();
                case 6 -> {
                    System.out.println("The work is completed!");
                    active = false;
                }
                default -> {
                    try {
                        throw new ValidException("The entered value is incorrect!");
                    } catch ( ValidException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}