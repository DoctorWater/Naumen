package ru.malkov.naumentesttask.interfaces;

import ru.malkov.naumentesttask.entities.Person;
import ru.malkov.naumentesttask.exceptions.NoSuchNameWasFoundException;

import java.util.List;

public interface DAO {
    Person getPersonByName(String name) throws NoSuchNameWasFoundException;
    List<Person> getAllPeople();
}
