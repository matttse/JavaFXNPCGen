/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author tsemd
 */
public class ItemDetails extends Equipment {
    private SimpleStringProperty name, description, value, experience;

    public ItemDetails(String name, String description, String value, String experience) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.value = new SimpleStringProperty(value);
        this.experience = new SimpleStringProperty(experience);
    }

    public String getName() {
        return name.get();
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public String getValue() {
        return value.get();
    }

    public void setValue(SimpleStringProperty value) {
        this.value = value;
    }

    public String getExperience() {
        return experience.get();
    }

    public void setExperience(SimpleStringProperty experience) {
        this.experience = experience;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(SimpleStringProperty description) {
        this.description = description;
    }
    
    
    
}
