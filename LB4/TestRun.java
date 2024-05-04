package org.example;

import edu.ntudp.lab4.JsonManager;
import edu.ntudp.lab3.Run;
import edu.ntudp.lab3.model.University;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class TestRun {

    @Test
    void createTypicalUniversity() {
        University university = new Run().createTypicalUniversity();
        JsonManager jsonManager = new JsonManager();
        try {
            jsonManager.writeToFileJson(university, "university.json");
        } catch (IOException e) {
            fail(e.getMessage());
            throw new RuntimeException(e);
        }
        University university2;
        try {
            university2 = jsonManager.readFromFileJson("university.json", University.class);
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
            throw new RuntimeException(e);
        }

        assertEquals(university, university2);

    }
}