package ru.itexus.main.CustomException;

public class IncorrectQuantityException extends Exception {
    public IncorrectQuantityException() {
        super("Некорректное количство записей!");
    }
}
