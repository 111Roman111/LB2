
package org.example.controller;

import org.example.model.Department;
import org.example.model.Faculty;
import org.example.model.Human;
import java.util.List;

public class FacultyCreator {

    public Faculty createFaculty(String name, Human head, List<Department> departments) {
        return new Faculty(name, head, departments);
    }
}