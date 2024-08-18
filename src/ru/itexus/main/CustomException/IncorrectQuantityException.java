package ru.itexus.main.CustomException;

public class IncorrectQuantityException extends Exception {
    public IncorrectQuantityException() {
        super("Incorrect number of entries!");
    }
}
