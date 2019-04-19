/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author tsemd
 */
public interface ReadCSV {
    
    
    // Java code to illustrate reading a 
    // all data at once 
    public List<String[]> readScanner(String file) throws IOException;

}
