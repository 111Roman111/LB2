package org.example.test;

import org.example.controller.JsonManager;
import org.example.model.Faculty;
import org.example.model.Group;
import org.example.model.Human;
import org.example.model.Sex;
import org.example.model.Student;
import org.example.model.University;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonManagerTest {

    @Test
    public void testWriteAndReadUniversityToJson() {
        // Створення університету з вказаними в завданні характеристиками
        University oldUniversity = createUniversity();

        // Запис університету у файл у форматі JSON
        JsonManager.writeUniversityToJson(oldUniversity);

        // Зчитування університету з файлу
        University newUniversity = JsonManager.readUniversityFromJson();

        // Порівняння двох університетів
        assertEquals(oldUniversity, newUniversity);
    }

    private University createUniversity() {
        University university = new University("Test University", new Human("John", "Doe", "Smith", Sex.MALE));

        Faculty faculty1 = new Faculty("Faculty of Science", new Human("Jane", "Doe", "Johnson", Sex.FEMALE));
        Faculty faculty2 = new Faculty("Faculty of Arts", new Human("David", "Brown", "Jones", Sex.MALE));
        university.add(faculty1);
        university.add(faculty2);

        Group group1 = new Group("Group A", new Human("Emma", "Taylor", "Wilson", Sex.FEMALE));
        Group group2 = new Group("Group B", new Human("Michael", "Clark", "White", Sex.MALE));
        faculty1.add(group1);
        faculty1.add(group2);

        Group group3 = new Group("Group C", new Human("Olivia", "Martinez", "Anderson", Sex.FEMALE));
        Group group4 = new Group("Group D", new Human("Daniel", "Hernandez", "Thompson", Sex.MALE));
        faculty2.add(group3);
        faculty2.add(group4);

        Student student1 = new Student("Sophia", "Garcia", "Harris", Sex.FEMALE);
        Student student2 = new Student("James", "Lopez", "King", Sex.MALE);
        Student student3 = new Student("Isabella", "Rodriguez", "Allen", Sex.FEMALE);
        Student student4 = new Student("Liam", "Perez", "Scott", Sex.MALE);
        group1.add(student1);
        group1.add(student2);
        group2.add(student3);
        group2.add(student4);

        Student student5 = new Student("Emily", "Lewis", "Adams", Sex.FEMALE);
        Student student6 = new Student("Alexander", "Walker", "Miller", Sex.MALE);
        Student student7 = new Student("Charlotte", "Young", "Nelson", Sex.FEMALE);
        Student student8 = new Student("Noah", "Green", "Hill", Sex.MALE);
        group3.add(student5);
        group3.add(student6);
        group4.add(student7);
        group4.add(student8);

        return university;
    }
}