package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

// Class constructor
public class AnalyticsCounter {
	ISymptomReader reader;
	ISymptomWriter writer;

	// With two instances
	AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

	}

	// Retrieve symptoms from ReadSymptomDataFromFile
	public List<String> getSymptoms() {
		return this.reader.getSymptoms();

	}

	// Write symptoms
	public void writeSymptoms(Map<String, Integer> symptomsWithOrder) {
		this.writer.writeSymptoms(symptomsWithOrder);

	}

	// Generate a map with occurrences
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> counter = new HashMap<String, Integer>();
		for (String symptom: symptoms) {
			if (counter.get(symptom) == null) {
				counter.put(symptom, 1);
			} else {
				counter.put(symptom, counter.get(symptom) + 1);
			}
		}
		return counter;
	}

	// Re-order: alphabetic ('asciibetical')
	public SortedMap<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		SortedMap<String, Integer> sortedSymptoms = new TreeMap<String, Integer>();
		sortedSymptoms.putAll(symptoms);
		return sortedSymptoms;
	}

}