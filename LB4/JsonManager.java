package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class JsonManager{
    public JsonManager() {

    }

    public <T> void writeToFileJson(T obj, String pathname) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter writer = new FileWriter(pathname);
        gson.toJson(obj, writer);
        writer.close();
    }

    public <T> T readFromFileJson(String pathname, Class<T> groupClass) throws FileNotFoundException {
        return new Gson().fromJson(new FileReader(pathname), groupClass);
    }
    public <T> String toString(T obj) {
        return new Gson().toJson(obj);
    }

}