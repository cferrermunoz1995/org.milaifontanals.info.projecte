/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.HashMap;
import java.time.Duration;
/**
 *
 * @author isard
 */
public class Ruta {
    private int id;//obligatori
    private HashMap<Integer,Punt> punts;
    private String titol;
    private String text;
    private double distancia;
    private Duration duracio;
    private double desnivell_positiu;
    private double desnivell_negatiu;
    private int dificultat;

    public Ruta(int id, HashMap<Integer, Punt> punts, String titol, String text, double distancia, Duration duracio, double desnivell_positiu, double desnivell_negatiu, int dificultat) {
        setId(id);
        setPunts(punts);
        setTitol(titol);
        setText(text);
        setDistancia(distancia);
        setDuracio(duracio);
        setDesnivell_positiu(desnivell_positiu);
        setDesnivell_negatiu(desnivell_negatiu);
        setDificultat(dificultat);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, Punt> getPunts() {
        return punts;
    }

    public void setPunts(HashMap<Integer, Punt> punts) {
        this.punts = punts;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Duration getDuracio() {
        return duracio;
    }

    public void setDuracio(Duration duracio) {
        this.duracio = duracio;
    }

    public double getDesnivell_positiu() {
        return desnivell_positiu;
    }

    public void setDesnivell_positiu(double desnivell_positiu) {
        if (desnivell_positiu<0)
            throw new WikilocException("Error en crear la Ruta. El desnivell positiu ha de ser estrictament positiu o 0");
        this.desnivell_positiu = desnivell_positiu;
    }

    public double getDesnivell_negatiu() {
        return desnivell_negatiu;
    }

    public void setDesnivell_negatiu(double desnivell_negatiu) {
        if (desnivell_negatiu<0)
            throw new WikilocException("Error en crear la Ruta. El desnivell negatiu ha de ser estrictament positiu o 0");
        this.desnivell_negatiu = desnivell_negatiu;
    }

    public int getDificultat() {
        return dificultat;
    }

    public void setDificultat(int dificultat) {
        if (dificultat<1 || dificultat>5){
            throw new WikilocException("Error en crear la Ruta. La dificultat ha d'estar comporesa entre 1 i 5");
        }
        this.dificultat = dificultat;
    }
    
    
}
