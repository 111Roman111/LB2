package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

public class JsonManager {
    private Gson gson;

    public JsonManager() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void writeToFileJson(Object object, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(object, writer);
        }
    }

    public <T> T readFromFileJson(String filePath, Class<T> clazz) throws FileNotFoundException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, clazz);
        }
    }
}