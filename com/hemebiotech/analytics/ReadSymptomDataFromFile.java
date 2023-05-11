package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* ISymptomReader interface implementation to read symptoms From File.
*/
public class ReadSymptomDataFromFile implements ISymptomReader {
  private String filepath;
  
  /**
  * Filepath to symptoms file.
  */
  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;

  }
  
  /**
  * Gets symptoms From File & returns a list of them.
  */
  @Override
  public List<String> getSymptoms() {
    ArrayList<String> result = new ArrayList<>();
    
    if (filepath != null) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();
        
        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
    return result;
  }

}