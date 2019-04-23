/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Random;

/**
 *
 * @author tsemd
 */
public class Randomizer {
    private static String[] Beginning = { "Kr", "Ca", "Ra", "Mrok", "Cru",
          "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
          "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
          "Mar", "Luk" };
    private static String[] Middle = { "air", "ir", "mi", "sor", "mee", "clo",
          "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
          "marac", "zoir", "slamar", "salmar", "urak" };
    private static String[] End = { "d", "ed", "ark", "arc", "es", "er", "der",
          "tron", "med", "ure", "zur", "cred", "mur" };

    //generates random int function for reuse
    public int getRandomInt(Random random, int min, int max)
    {
      return random.nextInt(max - min + 1) + min;
    }
    //generates random name function for reuse
    public String generateName() {
        Random rand = new Random();   
          return Beginning[rand.nextInt(Beginning.length)] + 
                Middle[rand.nextInt(Middle.length)]+
                End[rand.nextInt(End.length)];      
    }
    
}