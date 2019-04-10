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
public abstract class NPC {

    private String Name, Level, ArmorClass, HitPoints,
            strength, dexterity, constitution, intelligence, wisdom, charisma, notes;

    public NPC(String Name, String Level, String ArmorClass, String HitPoints, String strength, String dexterity, String constitution, String intelligence, String wisdom, String charisma, String notes) {
        this.Name = Name;
        this.Level = Level;
        this.ArmorClass = ArmorClass;
        this.HitPoints = HitPoints;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.notes = notes;
    }
    public NPC(String Name, String Level, String ArmorClass, String HitPoints) {
        this.Name = Name;
        this.Level = Level;
        this.ArmorClass = ArmorClass;
        this.HitPoints = HitPoints;
    }

    public NPC(String strength, String dexterity, String constitution, String intelligence, String wisdom, String charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public NPC() {
        this.Name = Name;
        this.Level = Level;
        this.ArmorClass = ArmorClass;
        this.HitPoints = HitPoints;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public String getArmorClass() {
        return ArmorClass;
    }

    public void setArmorClass(String ArmorClass) {
        this.ArmorClass = ArmorClass;
    }

    public String getHitPoints() {
        return HitPoints;
    }

    public void setHitPoints(String HitPoints) {
        this.HitPoints = HitPoints;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getDexterity() {
        return dexterity;
    }

    public void setDexterity(String dexterity) {
        this.dexterity = dexterity;
    }

    public String getConstitution() {
        return constitution;
    }

    public void setConstitution(String constitution) {
        this.constitution = constitution;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getWisdom() {
        return wisdom;
    }

    public void setWisdom(String wisdom) {
        this.wisdom = wisdom;
    }

    public String getCharisma() {
        return charisma;
    }

    public void setCharisma(String charisma) {
        this.charisma = charisma;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
    
}
