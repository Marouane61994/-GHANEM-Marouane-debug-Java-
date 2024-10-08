package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Creates a class for save and export data on a file .txt
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
    private final String filepath;

    /**
     * Constructs an object for store symptom's data
     *
     * @param filepath the filepath for create a output file
     */
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {

            FileWriter writer = new FileWriter(filepath);
            symptoms.forEach((String symptom, Integer quantity) -> {
                try {
                    writer.write(symptom + " : " + quantity + "\n");
                } catch (IOException ignored) {
                }
            });
            writer.close();
        } catch (IOException ignored) {

        }


    }

}