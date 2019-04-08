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
public class ListItem {
    private String item_name;
    private String item_description;
    private String quantity;
    private String value;
    private int priority;


    public ListItem(String iName, String iDescription, String iQuant, String iValue, String iPrior) {
            this.setItem_name(iName);
            this.setItem_description(iDescription);
            this.setQuantity(iQuant);
            this.setValue(iValue);
            this.setPriority(Integer.valueOf(iPrior));
    }


    public String getItem_name() {
            return item_name;
    }

    public void setItem_name(String item_name) {
            this.item_name = item_name;
    }
    
    public String getItem_description() {
            return item_description;
    }

    public void setItem_description(String item_description) {
            this.item_description = item_description;
    }

    public String getQuantity() {
            return quantity;
    }

    public void setQuantity(String quantity) {
            this.quantity = quantity;
    }

    public String getValue() {
            return value;
    }

    public void setValue(String value) {
            this.value = value;
    }

    public int getPriority() {
            return priority;
    }

    public void setPriority(int priority) {
            this.priority = priority;
    }
    
	
}
