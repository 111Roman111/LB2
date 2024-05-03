package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

public class JsonManager {
    private Gson gson;

    public JsonManager() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void writeUniversityToJson(University university, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(university, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public University readUniversityFromJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, University.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

    public void writeFile(Object object, String fileName) throws IOException{
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(this.gson.toJson(object));
        fileWriter.close();
    }
}

    // Зчитування університету з файлу у форматі JSON
    public University readUniversityFromJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, University.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}