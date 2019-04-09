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
public class NPC {
    private String Name, Level, ArmorClass, HitPoints, Speed, Attacks,
            strength, dexterity, constitution, intelligence, wisdom, charisma;

    public NPC(String Name, String Level, String ArmorClass, String HitPoints, String Speed, String Attacks, String strength, String dexterity, String constitution, String intelligence, String wisdom, String charisma) {
        this.Name = Name;
        this.Level = Level;
        this.ArmorClass = ArmorClass;
        this.HitPoints = HitPoints;
        this.Speed = Speed;
        this.Attacks = Attacks;
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
        this.Speed = Speed;
        this.Attacks = Attacks;
    }

    public NPC(String strength, String constitution, String constitution0, String constitution1, String constitution2, String constitution3) {
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

    public String getSpeed() {
        return Speed;
    }

    public void setSpeed(String Speed) {
        this.Speed = Speed;
    }

    public String getAttacks() {
        return Attacks;
    }

    public void setAttacks(String Attacks) {
        this.Attacks = Attacks;
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
    
    
}
