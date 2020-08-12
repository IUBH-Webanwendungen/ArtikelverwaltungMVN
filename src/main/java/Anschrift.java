/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author paull
 */
@ManagedBean
@ApplicationScoped
public class Anschrift {

    private String firmenname = "B!Ware Rockband";
    private String strasse = "Am Arsch der Welt";
    private String hausnummer = "13";
    private String plz = "99999";
    private String ort = "Rockbandhausen";
    /**
     * Creates a new instance of Anschrift
     */
    public Anschrift() {
    }
    
    public String getFirmenname() {
        return this.firmenname;
    }
    
    public String getStrasse() {
        return this.strasse;
    }
    
    public String getHausnummer() {
        return this.hausnummer;
    }

    public String getPlz() {
        return this.plz;
    }

    public String getOrt() {
        return this.ort;
    }    
    
}
