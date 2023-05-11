package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
* Symptoms Analytics with two instances.
* ISymptomReader to read the symptoms.
* ISymptomWriter to write them.
*/
public class AnalyticsCounter {
  ISymptomReader reader;
  ISymptomWriter writer;
  
  /**
  * Constructor.
  * @param reader reads data From File.
  * @param writer writes data To File.
  */
  AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
    
  }
  
  /**
  * Get symptoms from ISymptomReader.
  *
  * @return symptoms list From File.
  */
  public List<String> getSymptoms() {
    return this.reader.getSymptoms();
    
  }

  /**
  * Writes symptoms to ISymptomWriter.
  *
  */
  public void writeSymptoms(Map<String, Integer> symptomsWithOrder) {
    this.writer.writeSymptoms(symptomsWithOrder); 

  }
  
  /**
  * Counts symptoms occurrences.
  * 
  * @param symptoms symptoms list from getSymptoms method.
  * @return symptoms occurrences map.
  */
  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> counter = new HashMap<>();
    for (String symptom: symptoms) {
      if (counter.get(symptom) == null) {
        counter.put(symptom, 1);        
      } else {
        counter.put(symptom, counter.get(symptom) + 1); 
      }
    }
    return counter;
  }

  /**
  * Symptoms list in alphabetical order.
  * 
  * @param symptoms symptoms map from countSymptoms method.
  * @return an ordered map.
  */
  public SortedMap<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    SortedMap<String, Integer> sortedSymptoms = new TreeMap<>();
    sortedSymptoms.putAll(symptoms);
    return sortedSymptoms;
  }
  
}