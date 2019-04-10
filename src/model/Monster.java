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
public class Monster extends NPC {
    private String className;

    public Monster(String className) {
        this.className = className;
    }
    
    public Monster() {
        this.className = className;
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
}
