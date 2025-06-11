package com.genspark.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LogProcessor {


	private Map<String, Integer> errorFrequencyMap = new HashMap<>();
	
	 public  Map<String, Integer> processLogFile(String filePath) throws IOException {
		// BUG: Resources not managed
	        BufferedReader reader = new BufferedReader(new FileReader(filePath));
	        String line;
	        
	        while ((line = reader.readLine()) != null) {
	            if (line.contains("ERROR")) {
	                String errorCode = extractErrorCode(line);
	                errorFrequencyMap.put(errorCode, errorFrequencyMap.getOrDefault(errorCode, 0) + 1);
	            }
	        }
	       
	        return errorFrequencyMap;
	    }

    private String extractErrorCode(String logLine) {
        int start = logLine.indexOf("[CODE:") + 6;
        int end = logLine.indexOf("]", start);
        return (start > 5 && end > start) ? logLine.substring(start, end) : "UNKNOWN";
    }
}
