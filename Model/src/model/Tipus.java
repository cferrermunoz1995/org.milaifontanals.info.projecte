/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Image;

/**
 *
 * @author isard
 */
public class Tipus {
    private int id;
    private String nom;
    private Image icona;

    public Tipus(int id, String nom, Image icona) {
        setId(id);
        setNom(nom);
        setIcona(icona);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null || nom.length()<1 || nom.length()>60)
            throw new WikilocException("Error e");
        this.nom = nom;
    }

    public Image getIcona() {
        return icona;
    }

    public void setIcona(Image icona) {
        this.icona = icona;
    }
    
    
}
