package ru.itexus.main.Service;

import ru.itexus.main.CustomException.IncorrectQuantityException;
import ru.itexus.main.CustomException.ValidException;
import ru.itexus.main.Models.User;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class OperationsOnUsers {
    private static final Pattern VALID_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final String VALID_PHONE_STRING = "375+\\d{9}";
    private static final String SPLIT_REGEX = ",";
    private static final String INFO_TRY_AGAIN_STRING = "Try again!";
    private static final String HEADER_CREATE_USER = """
			--------------------------------------------------------------
			Creating a user
			--------------------------------------------------------------
			""";
    private static final String HEADER_UPDATE_USER = """
			--------------------------------------------------------------
			Update user
			--------------------------------------------------------------
			""";
    private static final String FOOTER = """
			--------------------------------------------------------------
			Successfully!
			--------------------------------------------------------------
			""";


    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL.matcher(emailStr);
        return matcher.matches();
    }


    public static boolean lengthValid(String[] array){
        if(array.length > 3) {
            try {
                throw new IncorrectQuantityException();
            } catch (IncorrectQuantityException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println(INFO_TRY_AGAIN_STRING);
            return true;
        }
        return false;
    }
    public static void  showUserInformation(User user){
        System.out.println("Name: " + user.getFirstName());
        System.out.println("Last Name: "+ user.getLastName());
        System.out.println("Email: "+user.getEmail());
        System.out.println("List of roles: " + user.getListRoles().toString());
        System.out.println("List of phone numbers: "+user.getListPhones().toString());
    }

    public static User createUser(Scanner sc) {
        System.out.println(HEADER_CREATE_USER);

        User newUser = new User();
        newUser.setFirstName(inputFirstName(sc));
        newUser.setLastName(inputLastName(sc));

        newUser.setEmail(inputEmailAdders(sc));

        newUser.setListRoles(inputRoles(sc));

        newUser.setListPhones(inputPhoneNumber(sc));

        System.out.println(FOOTER);
        return newUser;
    }



    public static User editUser(Scanner sc, User user) {
        System.out.println(HEADER_UPDATE_USER);

        System.out.println("Do you want to change username?");
        System.out.println("The user's previous name: "+user.getFirstName());
        if(choosingAnOperation(sc)) {
            user.setFirstName(inputFirstName(sc));
        }

        System.out.println("Do you want to change the user's last name? ");
        System.out.println("The user's previous last Name: "+user.getLastName());
        if(choosingAnOperation(sc)) {
            user.setLastName(inputLastName(sc));
        }

        System.out.println("Do you want to change the user's email?");
        System.out.println("The user's previous email address: "+user.getEmail());
        if(choosingAnOperation(sc)) {
            user.setEmail(inputEmailAdders(sc));
        }

        System.out.println("Do you want to change user roles?");
        System.out.println("The user's previous roles: "+user.getListRoles().toString());
        if(choosingAnOperation(sc)) {
            user.setListRoles(inputRoles(sc));
        }



        System.out.println("Do you want to change the user's phone numbers?");
        System.out.println("The user's previous numbers phone: "+user.getListPhones().toString());
        if(choosingAnOperation(sc)) {
            user.setListPhones(inputPhoneNumber(sc));
        }

        System.out.println(FOOTER);
        return user;
    }



    private static boolean choosingAnOperation(Scanner sc){
        System.out.println("Do you want to change it?");
        System.out.println("1) yes");
        System.out.println("2) no");

        int idOperation = sc.nextInt();
        sc.nextLine();

        switch (idOperation) {
            case 1 -> {
                return true;
            }
            case 2 -> {
                return false;
            }
            default -> {
                try {
                    throw new ValidException("The entered value is incorrect!");
                } catch (ValidException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return false;
    }

    private static String inputFirstName(Scanner sc){
        System.out.println("Enter Name:");
        return sc.nextLine();
    }
    private static String inputLastName(Scanner sc){
        System.out.println("Enter last Name:");
        return sc.nextLine();
    }


    private static String inputEmailAdders(Scanner sc){
        System.out.println("Enter Email: ");
        while (true) {
            String inputEmail = sc.nextLine();
            if (validateEmail(inputEmail)) {
                return inputEmail;
            }
            try {
                throw new ValidException();
            } catch (ValidException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(INFO_TRY_AGAIN_STRING);
        }
    }

    private static List<String> inputRoles(Scanner sc){
        while (true) {
            System.out.println("Enter the name of the fields (separated by commas) in the number from 1 to 3: ");
            String[] arrayRole = sc.nextLine().split(SPLIT_REGEX);
            if (lengthValid(arrayRole)) {
                continue;
            }
            return Arrays.stream(arrayRole).map(String::trim).collect(Collectors.toList());
        }
    }

    private static List<String> inputPhoneNumber(Scanner sc){
        while (true) {
            System.out.println("Enter the phone numbers (separated by commas) in the number from 1 to 3");
            try {
                String[] arrayPhone = sc.nextLine().split(SPLIT_REGEX);

                if (lengthValid(arrayPhone)) {
                    continue;
                }
                if (Arrays.stream(arrayPhone).map(String::trim).allMatch(s -> s.matches(VALID_PHONE_STRING))) {
                    return Arrays.stream(arrayPhone).map(String::trim).collect(Collectors.toList());
                }

                throw new ValidException();
            } catch (ValidException | NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }



}
