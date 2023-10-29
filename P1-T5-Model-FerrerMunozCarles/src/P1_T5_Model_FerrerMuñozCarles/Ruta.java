/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P1_T5_Model_FerrerMuñozCarles;


import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;
import java.util.Objects;
/**
 *
 * @author isard
 */
public class Ruta {
    private int id;//obligatori
    private List<Punt> punts;
    private String titol;
    private String description;
    private String text;
    private double distancia;
    private double duracio;
    private double desnivell_positiu;
    private double desnivell_negatiu;
    private double nota_mitja_valoracio;
    private int dificultat;
    private int numPunts;
    private String usuari;
    private Timestamp data_creacio;

    

    public Ruta(int id, List<Punt> punts, String titol, String text, double distancia, double duracio, double desnivell_positiu, double desnivell_negatiu, int dificultat, int numPunts, double nota_mitja_valoracio, String description, String usuari, Timestamp data_creacio) {
        setId(id);
        setPunts(punts);
        setTitol(titol);
        setText(text);
        setDistancia(distancia);
        setDuracio(duracio);
        setDesnivell_positiu(desnivell_positiu);
        setDesnivell_negatiu(desnivell_negatiu);
        setDificultat(dificultat);
        setNumPunts(numPunts);
        setNota_mitja_valoracio(nota_mitja_valoracio);
        setDescription(description);
        setUsuari(usuari);
        setData_creacio(data_creacio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Punt> getPunts() {
        return punts;
    }

    public void setPunts(List<Punt> punts) {
        this.punts = punts;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        if (titol == null || titol.length()== 0 || titol.length()>60){
            throw new WikilocException("Error en crear Ruta. Títol no vàlid");
        }
        this.titol = titol;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text == null || text.length() == 0){
            throw new WikilocException("Error en crear Ruta. Text no vàlid");
        }
        this.text = text;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getDuracio() {
        return duracio;
    }

    public void setDuracio(double duracio) {
        if (duracio < 0){
            throw new WikilocException("Error en crear la Ruta. La duració ha de ser estrictament positiva");
        }
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
            throw new WikilocException("Error en crear la Ruta. La dificultat ha d'estar compresa entre 1 i 5");
        }
        this.dificultat = dificultat;
    }
    
    public int getNumPunts() {
        return numPunts;
    }

    public void setNumPunts(int numPunts) {
        this.numPunts = numPunts;
    }

    public double getNota_mitja_valoracio() {
        return nota_mitja_valoracio;
    }

    public void setNota_mitja_valoracio(double nota_mitja_valoracio) {
        this.nota_mitja_valoracio = nota_mitja_valoracio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length()== 0 || description.length()>60){
            throw new WikilocException("Error en crear Ruta. Text no vàlid");
        }
        this.description = description;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public Timestamp getData_creacio() {
        return data_creacio;
    }

    public void setData_creacio(Timestamp data_creacio) {
        this.data_creacio = data_creacio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ruta other = (Ruta) obj;
        return Objects.equals(this.id, other.id);
    }
    
    

    @Override
    public String toString() {
        return "Ruta{" + "id=" + id + ", punts=" + punts + ", titol=" + titol + ", description=" + description + ", text=" + text + ", distancia=" + distancia + ", duracio=" + duracio + ", desnivell_positiu=" + desnivell_positiu + ", desnivell_negatiu=" + desnivell_negatiu + ", nota_mitja_valoracio=" + nota_mitja_valoracio + ", dificultat=" + dificultat + ", numPunts=" + numPunts + '}';
    }
    
    
    
    
}
