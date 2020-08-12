/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author paull
 */
@ManagedBean
@ViewScoped
public class ArtikelController {

    private int index = 0;
    /**
     * Creates a new instance of ArtikelController
     */
    public ArtikelController() {
    }
    
    public Artikel getArtikel() {
        return Shop.getInstance().getSortiment().get(index);
    }
    
    public void vor(){
        if ((Shop.getInstance().getSortiment().size()-1)>index) {
            index++;
        }
    }
    
    public void zurueck() {
        if (index>0){
            index--;
        }
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public int getGroesse(){
        return Shop.getInstance().getSortiment().size();
    }
    
    public void validateArtikelnummer(FacesContext context, UIComponent component, Object value) throws ValidatorException{
        String id = String.valueOf(value);
        int cipher = Artikel.pruefeArtikelnummer(id);
        if(!id.endsWith(String.valueOf(cipher))){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehlerhafte GTIN Prüfziffer!", id + " ist eine falsche Artikelnummer!" +
                                                            " Die Prüfziffer lautet " + String.valueOf(cipher)));
        }
    }
}
