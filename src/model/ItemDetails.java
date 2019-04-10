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
public class ItemDetails extends Equipment {
    private String Description;
    private String ItemValue;
    
    public ItemDetails(String item_name, String item_description, String quantity, String value, int priority, String name) {
        super(name);        
        this.Description = item_description;        
        this.ItemValue = value;        
    }
    
    public String getDescription() {
            return Description;
    }

    public void setDescription(String Description) {
            this.Description = Description;
    }

    public String getItemValue() {
            return ItemValue;
    }

    public void setItemValue(String ItemValue) {
            this.ItemValue = ItemValue;
    }
	
}
