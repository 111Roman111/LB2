
package org.example.controller;


import org.example.model.University;
import org.example.model.Faculty;
import java.util.List;

public class UniversityCreator {

    public University createUniversity(String name, List<Faculty> faculties) {
        return new University(name, faculties);
    }
}