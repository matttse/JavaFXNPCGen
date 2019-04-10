/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.opencsv.*;
import java.io.FileReader;
import java.util.List;

/**
 *
 * @author tsemd
 */
public interface ReadCSV {
    
    
    // Java code to illustrate reading a 
    // all data at once 
    public void readAllDataAtOnce(String file);
    
    // Java code to illustrate 
    // Reading CSV File with different separator 
    public void readDataFromCustomSeperator(String file);
    // Java code to illustrate reading a 
    // CSV file line by line 
    public void readDataLineByLine(String file);

}
