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
    private int id;//auto
    private String nom;//obligatori
    private Image icona;//obligatori

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
            throw new WikilocException("Error en crear Tipus. El nom ha de tenir entre 1 i 60 caràcters");
        this.nom = nom;
    }

    public Image getIcona() {
        return icona;
    }

    public void setIcona(Image icona) {
        if (icona == null)
            throw new WikilocException("Error en crear Tipus. L'icona no pot ser nul·la");
        this.icona = icona;
    }
    
    
}
