/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.ValidatorException;

@ManagedBean
@ViewScoped
public class LoginController {

    private Benutzer benutzer = new Benutzer();
    private String name;
    
    public Benutzer getBenutzer() {
        return this.benutzer;
    }
    
    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
    }
    
    public LoginController() {
    }
    
    public String login(){
       
        return "index.xhtml";
    }
    
    //Diese Methodeließt aus der UserInterface die Komponente aus und holt sich aus ihr den Wert!
    public void postValidateName(ComponentSystemEvent ev) throws AbortProcessingException {
        UIInput ui = (UIInput)ev.getComponent();
        this.name = (String)ui.getValue();
    }
    
    public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        List<Benutzer> liste = Shop.getInstance().getBenutzer();
        Benutzer temp = new Benutzer(this.name, (String)value);
        for (Benutzer b : liste) {
            if (b.equals(temp)){
                return;
            }
        }
        throw new ValidatorException(new FacesMessage("Benutzername oder Passwort falsch!"));
    } 
    
}
