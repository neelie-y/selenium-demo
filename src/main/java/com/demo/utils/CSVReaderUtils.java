package com.demo.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtils {

    public static List<Object[]> getTestData(String filePath) throws IOException, CsvValidationException {
        List<Object[]> testData = new ArrayList<>();

        // Create a CSVReader object to read the CSV file
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                testData.add(line);  // Add each row to the testData list
            }
        }
        return testData;
    }
}
