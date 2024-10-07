package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	public AnalyticsCounter() {
	}
	public List<String> getSymptoms(String filepath) {
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		return reader.getSymptoms();
	}
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> map = new TreeMap<>();
		for (String symptom : symptoms) {
			if (symptom != null) {
				if (!map.containsKey(symptom)) {
					map.put(symptom, 1);
				} else {
					map.put(symptom, map.get(symptom) + 1);
				}
			}
		}
		return map;

	}
	public void writeSymptoms(Map<String, Integer> symptoms) {
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptoms(symptoms);
	}

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				//++;
			}
			else if (line.contains("pupils")) {
				//pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		//.write("headache: " + headacheCount + "\n");
		//writer.write("rash: " + rashCount + "\n");
		//writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
