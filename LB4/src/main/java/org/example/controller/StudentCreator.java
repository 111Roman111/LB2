
package org.example.controller;


import org.example.model.Student;
import org.example.model.Group;
import org.example.model.Human;
import org.example.model.Sex;

public class StudentCreator {

    public Student createStudent(String firstName, String lastName, String patronymic, Sex sex, Group group) {
        return new Student(firstName, lastName, patronymic, sex, group);
    }
}