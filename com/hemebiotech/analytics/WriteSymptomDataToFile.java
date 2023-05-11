package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
  private String fileName;

  /**
  * Writes symptoms in result.out.
  *
  */
  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    
    fileName = "result.out";

    try {
      FileWriter writer = new FileWriter(fileName);
      BufferedWriter bw = new BufferedWriter(writer);

      for (Map.Entry<String, Integer> mapEntry : symptoms.entrySet()) {
        bw.write(mapEntry.getKey() + " : " + mapEntry.getValue());
        bw.newLine();

      }
      bw.close();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}