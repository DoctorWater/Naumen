package ru.malkov.naumentesttask.entities;

import lombok.*;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Person {
    private String name;
    private Integer age;
}
