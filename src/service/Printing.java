/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author tsemd
 */
public interface Printing 
{
	//Declaring the printing method
	public void printing(String[] itemName, String[] itemDescription, String[] itemExperience, String[] itemValue,
                String characterName, String ArmorClass, String HitPoints, String Level, String Class, String Notes,
                String Strength, String Constitution, String Dexterity, String Intelligence, String Wisdom, String Charisma
                );
	
}
