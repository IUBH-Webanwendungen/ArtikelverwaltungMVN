/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

/**
 *
 * @author paull
 */
@ManagedBean
@SessionScoped
public class Shop {

    private List<Artikel> sortiment = new ArrayList<Artikel>();
    private List<Benutzer> kundenstamm = new ArrayList<Benutzer>();
    private static Shop instance = new Shop();
    private static EntityManagerFactory emf;

    /**
     * Creates a new instance of Shop
     */
    public Shop() {
        try {
            System.err.println("Starting entityManager.");
            emf = Persistence.createEntityManagerFactory("onlineshop");
            System.err.println("Connection successful");
        } catch (Throwable t) {
            System.err.println("Bug");
            t.printStackTrace();
        }
                
        sortiment.add(new Artikel("Hose", 123456780,1,"Neu","Hose.jpg",new Date(),10.99d));
        sortiment.add(new Artikel("Pullover", 888888888,1,"Neu","Pullover.png",new Date(),15.99d));
        sortiment.add(new Artikel("Socken", 696969694,1,"Neu","Socken.png",new Date(), 9.99d));
        sortiment.add(new Artikel("T-Shirt", 973526141,1,"Neu","T-Shirt.png",new Date(), 4.99d));
        sortiment.add(new Artikel("Schuhe", 192837464,1,"Neu","Schuhe.png",new Date(), 29.99d));
        sortiment.add(new Artikel("Hut", 192837465,1,"Neu","Hut.jpg",new Date(), 12.99d));

        EntityTransaction t = null;
        try {
            EntityManager em = emf.createEntityManager();
            List<Artikel> alreadyThere =
                    em.createQuery("select a from Artikel a", Artikel.class).getResultList();
            if(alreadyThere ==null || alreadyThere.size()==0) {
                System.err.println("Restarting the sortiment...");
                t = em.getTransaction();
                t.begin();
                for(Artikel a: sortiment) {
                    em.persist(a);
                }
                t.commit();
                em.close();
                System.err.println("Inserted "+sortiment.size()+" Artikeln...");
            }
        } catch(Throwable thr) {
            thr.printStackTrace();
            if(t!=null && t.isActive()) t.rollback();
        }
                
       
        kundenstamm.add(new Benutzer("Paul", "L"));
        kundenstamm.add(new Benutzer("Laura", "Hoff"));
        kundenstamm.add(new Benutzer("Knut", "Panda"));
        kundenstamm.add(new Benutzer("Berthold", "L"));
        kundenstamm.add(new Benutzer("Manuela", "L")); 
        
        /* if(em.find(Benutzer.class, 123456780)==null) {
            for(Benutzer b: kundenstamm) {
                em.persist(b);
            }
        }*/
        
    }
    
    public List<Artikel> getSortiment() {
        //return sortiment;
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createQuery("select a from Artikel a");
        List<Artikel> artikel = q.getResultList();
        em.close();
        System.out.println("Got " + artikel.size() + " articles.");
        return artikel;
    }
    
    public List<Benutzer> getBenutzer() {
        return this.kundenstamm;
    }
    
    public static Shop getInstance() {
        return instance;
    }
    
}
