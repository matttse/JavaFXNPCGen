/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
//Importing the packages for writing to a file and throwing an exception if it can't open a file
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 *
 * @author tsemd
 */
public class FileWriting implements Printing {
	//Declaring the method for printing to a file
	public void printing(String[] itemName, String[] itemDescription, String[] itemExperience, String[] itemValue,
                String characterName, String ArmorClass, String HitPoints, String Level, String Class, String Notes,
                String Strength, String Constitution, String Dexterity, String Intelligence, String Wisdom, String Charisma){
		
		
		//Declaring the filename to be written out
		String filename = characterName+"_character.txt";
	
		//Instantiating a PrintWriter class used for writing out to the file
		PrintWriter outputStream = null;

		//Opening the file on the computer and associating it with the outputStream, 
		//making sure that there are no issues opening the file
		try
		{
			outputStream = new PrintWriter(filename);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening file on the computer, check permissions");
			System.exit(0);
		}
		
		//Writing into the file
		outputStream.println("Name: "+characterName);
                outputStream.println("ArmorClass: "+ArmorClass);
                outputStream.println("HitPoints: "+HitPoints);
                outputStream.println("Level: "+Level);
                outputStream.println("Class: "+Class);
                outputStream.println("Notes: "+Notes);
		outputStream.println();
		outputStream.println("Items:");
		
		//Writing out items
		for(int i = 0;i < itemName.length;i++)
		{
			outputStream.println(itemName[i] +
                                ", description: "+itemDescription[i] +
                                ", experience: "+itemExperience[i] +
                                ", value: "+itemValue[i]
                        );
		}
		
		outputStream.println();
	
		outputStream.close();
		}
	}

