package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

  /**
   * Writes symptoms To File.
   *
  */
  void writeSymptoms(Map<String, Integer> symptoms);
  
}