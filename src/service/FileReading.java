/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author tsemd
 */
public class FileReading implements ReadCSV {
    
    @Override
    public void readDataLineByLine(String file) {
        try { 

                // Create an object of filereader 
                // class with CSV file as a parameter. 
                FileReader filereader = new FileReader(file); 

                // create csvReader object passing 
                // file reader as a parameter 
                CSVReader csvReader = new CSVReader(filereader); 
                String[] nextRecord; 

                // we are going to read data line by line 
                while ((nextRecord = csvReader.readNext()) != null) { 
                        for (String cell : nextRecord) { 
                                System.out.print(cell + "\t"); 
                        } 
                        System.out.println(); 
                } 
        } 
        catch (Exception e) { 
                e.printStackTrace(); 
        } 
    
    }
    @Override
    public void readAllDataAtOnce(String file) {
        try { 
                // Create an object of file reader 
                // class with CSV file as a parameter. 
                FileReader filereader = new FileReader(file); 

                // create csvReader object and skip first Line 
                CSVReader csvReader = new CSVReaderBuilder(filereader) 
                                                                .withSkipLines(0) 
                                                                .build(); 
                List<String[]> allData = csvReader.readAll(); 

                // print Data 
                for (String[] row : allData) { 
                        for (String cell : row) { 
                                System.out.print(cell + "\t"); 
                        } 
                        System.out.println(); 
                } 
        } 
        catch (Exception e) { 
                e.printStackTrace(); 
        } 
        
    }

    @Override
    public void readDataFromCustomSeperator(String file) { 
        try { 
                // Create an object of file reader class with CSV file as a parameter. 
                FileReader filereader = new FileReader(file); 

                // create csvParser object with 
                // custom seperator semi-colon 
                CSVParser parser = new CSVParserBuilder().withSeparator(';').build(); 

                // create csvReader object with parameter 
                // filereader and parser 
                CSVReader csvReader = new CSVReaderBuilder(filereader) 
                                                                .withCSVParser(parser) 
                                                                .build(); 

                // Read all data at once 
                List<String[]> allData = csvReader.readAll(); 

                // Print Data. 
                for (String[] row : allData) { 
                        for (String cell : row) { 
                                System.out.print(cell + "\t"); 
                        } 
                        System.out.println(); 
                } 
        } 
        catch (Exception e) { 
                e.printStackTrace(); 
        } 
    } 
        
    
}
