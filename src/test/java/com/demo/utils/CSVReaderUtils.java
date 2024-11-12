package com.demo.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReaderUtils {

    public List<String[]> getTestData(String filePath) {
        List<String[]> allData = new ArrayList<>();
        try {

            // Create an object of filereader class
            // with CSV file as a parameter.
            FileReader filereader = new FileReader(filePath);

            // create csvReader object
            // and skip first Line
            CSVReader csvReader = new CSVReader(filereader);
            csvReader.readNext();
            allData = csvReader.readAll();

            // print Data
            for (String[] row : allData) {
                for (String cell : row) {
                    System.out.print(cell + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allData;

    }
}
