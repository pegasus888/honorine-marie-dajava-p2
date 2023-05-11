package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomReader {
  /**
  * If no data is available, return an empty List.
  * @return raw listing of all Symptoms from a data source, duplicates are possible.
  */
  List<String> getSymptoms();
}
