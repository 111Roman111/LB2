
package org.example.controller;


import org.example.model.Group;
import org.example.model.Student;
import java.util.List;

public class GroupCreator {

    public Group createGroup(String name, List<Student> students) {
        return new Group(name, students);
    }
}