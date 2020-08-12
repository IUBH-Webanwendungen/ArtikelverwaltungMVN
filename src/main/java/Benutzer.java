/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paull
 */
public class Benutzer {
    private String name;
    private String passwort;
    
    public Benutzer(){};
    
    public Benutzer(String name, String passwort) {
        this.name = name;
        this.passwort = passwort;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getPasswort() {
        return this.passwort;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Benutzer) {
            Benutzer b = (Benutzer) obj;
            if (b.getName().equals( this . name ) &&
            b.getPasswort().equals( this . passwort ))
                return true ;
        }
        return false ;
        }
}

