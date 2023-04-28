package ru.malkov.naumentesttask.dao;

import ru.malkov.naumentesttask.entities.Person;
import ru.malkov.naumentesttask.exceptions.DaoCreationException;
import ru.malkov.naumentesttask.exceptions.NoSuchNameWasFoundException;
import ru.malkov.naumentesttask.interfaces.DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FileDao implements DAO {
    private final String filename;
    private final List<Person> people;

    public FileDao(String filename) throws DaoCreationException {
        this.filename = filename;
        this.people = initiateDataList();
    }

    /**
     * Returns the list of all people that were read from the file.
     *
     * @return list of people
     */
    public List<Person> getAllPeople() {
        return people;
    }

    /**
     * Returns person with the name equal to the specified string.
     * @param name The name of the required person
     * @return Found person
     * @throws NoSuchNameWasFoundException if there is no person with the specified name
     */
    @Override
    public Person getPersonByName(String name) throws NoSuchNameWasFoundException {
        Optional<Person> result = people.stream().filter(x -> x.getName().equals(name)).findFirst();
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new NoSuchNameWasFoundException();
        }
    }

    private List<Person> initiateDataList() throws DaoCreationException {
        try {
            Scanner scanner = new Scanner(new File(filename));
            List<Person> result = new ArrayList<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String name = line.split("_")[0];
                Integer age = Integer.parseInt(line.split("_")[1]);
                result.add(new Person(name, age));
            }
            return result;
        } catch (FileNotFoundException | NumberFormatException e) {
            throw new DaoCreationException(e);
        }
    }
}
