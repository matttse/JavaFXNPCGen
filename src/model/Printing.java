/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tsemd
 */
public interface Printing 
{
	//Declaring the printing method
	public void printing(String[] bought, String[] notBought, String Name, Double[] boughtPrice, Double[] notBoughtPrice,
			Integer[] boughtQuantity, Integer[] notBoughtQuantity, Double budget, Double moneyInPocket, String[] items, Integer[] priorities);
	
}
