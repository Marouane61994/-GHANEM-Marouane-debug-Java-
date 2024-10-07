package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public interface ISymptomWriter {
    default void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            FileWriter writer = new FileWriter("Result.out");
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
