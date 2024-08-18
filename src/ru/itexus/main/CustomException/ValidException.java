package ru.itexus.main.CustomException;

public class ValidException  extends Exception{
    public ValidException(){
        super("The data was entered incorrectly!");
    }

    public ValidException(String message) {
        super(message);
    }
}
