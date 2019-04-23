/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tsemd
 */
public class FileReading implements ReadCSV {
    protected List<String[]> returnList = new ArrayList<>();
    
    public FileReading() {
        this.returnList = returnList;
    }
    public FileReading(ArrayList returnList) {
        this.returnList = returnList;
    }

    public List<String[]> getReturnList() {
        return returnList;
    }

    public void setReturnList(List<String[]> returnList) {
        this.returnList = returnList;
    }

    public List<String[]> readScanner(String filename) throws IOException { 
        int count = 0;
        List<String[]> content = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line.split(","));
            }
        } catch (FileNotFoundException e) {
        //Some error logging
        }
        return content;
    } 
    
    
}
