package ru.itexus.main.CustomException;

public class ValidException  extends Exception{
    public ValidException(){
        super("Некорректно введены данные!");
    }

    public ValidException(String message) {
        super(message);
    }
}
