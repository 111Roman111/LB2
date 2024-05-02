package org.example.controller;

import com.google.gson.Gson;
import org.example.model.University;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {
    private static final String FILENAME = "university.json";

    public static void writeUniversityToJson(University university) {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            Gson gson = new Gson();
            gson.toJson(university, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static University readUniversityFromJson() {
        try (FileReader reader = new FileReader(FILENAME)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, University.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
