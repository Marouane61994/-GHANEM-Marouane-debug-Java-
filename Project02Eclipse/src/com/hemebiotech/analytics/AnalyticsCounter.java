package com.hemebiotech.analytics;
import java.util.*;


public class AnalyticsCounter {
	/**
	 * Main class of feature Analytics counter
	 */
	public AnalyticsCounter() {
	}

	/**
	 * Reads and adds all symptom from file on a list
	 *
	 * @return a symptom's list
	 */

	public List<String> getSymptoms(String filepath) {
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		return reader.getSymptoms();
	}

	/**
	 * Sorts alphabetically the list of symptoms and CountSymptoms counts the occurrences of each existing symptom
	 *
	 * @param symptoms list of all symptoms to sort
	 * @return map of sorted symptoms
	 */

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

	/**
	 * Writes all treated data on a file
	 *
	 * @param symptoms the map of sorted data
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptoms(symptoms);
	}

	/**
	 * Main method
	 *
	 * @param args no param
	 */
	public static void main(String[] args) {

		AnalyticsCounter counter = new AnalyticsCounter();
		List<String> symptoms = counter.getSymptoms("symptoms.txt");
		Map<String, Integer> map = counter.countSymptoms(symptoms);
		counter.writeSymptoms(map);

	}
}