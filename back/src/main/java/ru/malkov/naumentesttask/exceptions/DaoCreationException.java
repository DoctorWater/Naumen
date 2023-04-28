package ru.malkov.naumentesttask.exceptions;

public class DaoCreationException extends Exception{
    public DaoCreationException(Throwable cause) {
        super("Something went wrong during DAO creation, check the nested exception for further details", cause);
    }
}
