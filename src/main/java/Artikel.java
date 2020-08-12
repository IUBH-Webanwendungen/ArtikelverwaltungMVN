import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.OneToMany;

@Entity
public class Artikel { 
    
    @Id
    private int artikelNr;
    private String nameArtikel;
    private int anzahl;
    private String beschreibung;
    private String artikelImage;
    private double preis;
    
    @Temporal(TemporalType.DATE)
    private Date verfuegbarAb;
    /**
     * Creates a new instance of Artikel
     */
    //Konstruktoren
    public Artikel() {

    }
    
    public Artikel(String na, int an, int a, String bes, String aI,Date datum, double pr){
        this.nameArtikel = na;
        this.artikelNr = an;
        this.anzahl = a;
        this.beschreibung = bes;
        this.artikelImage = aI;
        this.verfuegbarAb = datum;
        this.preis = pr;
    }
    
    //Getter und Setter Methoden
    public String getNameArtikel() {
        return this.nameArtikel;
    }
    
    public int getArtikelNr() {
        return this.artikelNr;
    }
    public int getAnzahl() {
        return this.anzahl;
    }
    public String getBeschreibung() {
        return this.beschreibung;
    }
    public String getArtikelImage() {
        return this.artikelImage;
    }
    public Date getVerfuegbarAb() {
        return this.verfuegbarAb;
    }
    public double getPreis() {
        return this.preis;
    }
    
    public void setNameArtikel(String name) {
        this.nameArtikel = name;
    }
    public void setArtikelNr(int nr) {
        this.artikelNr = nr;
    }
    public void setAnzahl(int anz) {
        this.anzahl = anz;
    }
    public void setBeschreibung(String bes) {
        this.beschreibung = bes;
    }
    public void setArtikelImage(String img) {
        this.artikelImage = img;
    }
    public void setVerfuegbarAb(Date date) {
        this.verfuegbarAb = date;
    }
    public void setPreis(double pr) {
        this.preis = pr;
    }

    public static int pruefeArtikelnummer(String id) {
        String hilfsstring = id;
        int hilfszahl = 0;
        for (int i = 0; i < hilfsstring.length()-1; i++) {
            hilfszahl = hilfsstring.codePointAt(i) + hilfszahl;
        }
        hilfszahl=hilfszahl%10;
        return hilfszahl;
    }    
    
}
