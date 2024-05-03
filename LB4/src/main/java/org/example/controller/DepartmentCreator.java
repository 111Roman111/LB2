
package org.example.controller;


import org.example.model.Department;
import org.example.model.Group;
import java.util.List;

public class DepartmentCreator {

    public Department createDepartment(String name, List<Group> groups) {
        return new Department(name, groups);
    }
}