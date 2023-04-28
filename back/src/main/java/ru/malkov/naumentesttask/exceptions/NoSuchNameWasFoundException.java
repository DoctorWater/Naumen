package ru.malkov.naumentesttask.exceptions;

public class NoSuchNameWasFoundException extends Exception {
    public NoSuchNameWasFoundException() {
        super("No person was found for the given name.");
    }
}
