/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
//Importing the packages for writing to a file and throwing an exception if it can't open a file
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;

/**
 *
 * @author tsemd
 */
public class FileWriting implements Printing {
	//Declaring the method for printing to a file
	public void printing(String[] bought, String[] notBought, String Name, Double[] boughtPrice, Double[] notBoughtPrice,
							Integer[] boughtQuantity, Integer[] notBoughtQuantity, Double budget, Double moneyInPocket,
							String[] items, Integer[] priorities){
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		//Declaring the filename to be written out
		String filename = "character.txt";
	
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
		
		//Writing into the file the user's name and their budget before purchasing
		outputStream.println(Name);
		outputStream.println("Total budget:"+df.format(budget));
		outputStream.println();
		outputStream.println("Original shopping list:");
		
		//Writing out the original shopping list
		for(int i = 0;i < items.length;i++)
		{
			outputStream.println(items[i]+", priority: "+priorities[i]);
		}
		
		outputStream.println();
		outputStream.println("Items you bought:");
	
		//Writing out the bought items, quantity and price to the file
		for(int i = 0;i < items.length;i++)
		{
			if(!bought[i].equals("hello"))
			{
				outputStream.println(bought[i]+" "+"x"+boughtQuantity[i]+" "+boughtPrice[i]);
				//spent = spent + boughtPrice[i];
			}
		}
		outputStream.println("");
		outputStream.println("Items not bought:");
	
		//Writing out the not bought items, quantity and price to the file
		for(int i = 0;i < items.length;i++)
		{
			if(!notBought[i].equals("hello"))
			{
				outputStream.println(notBought[i]+" "+"x"+notBoughtQuantity[i]+" "+notBoughtPrice[i]);
			}
		}
	
		outputStream.println();
		
		//Writing out the budget after purchasing
		outputStream.println("Budget after shopping:"+df.format(moneyInPocket));
		outputStream.close();
		}
	}

