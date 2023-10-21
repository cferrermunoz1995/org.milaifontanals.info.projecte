/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P1_T5_Model_FerrerMuñozCarles;

import java.awt.Image;

/**
 *
 * @author isard
 */
public class Punt {
    private int id; //obligatori, el crea la bd
    private Ruta ruta; //obligatori
    private String nom; //obligatori
    private String desc; //obligatori
    private Image foto; //Opcional
    private double latitude; //obligatori
    private double longitude; //obligatori
    private double altitude; //obligatori
    private Tipus tipus; //obligatori

    public Punt(int id,Ruta ruta, String nom, String desc, Image foto, double latitude, double longitude, double altitude, Tipus tipus) {
        setId(id);
        setRuta(ruta);
        setNom(nom);
        setDesc(desc);
        setFoto(foto);
        setLatitude(latitude);
        setLongitude(longitude);
        setAltitude(altitude);
        setTipus(tipus);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        if (ruta==null){
            throw new WikilocException("Error en crear Punt. Ruta inexistent");
        }
        this.ruta = ruta;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom==null || nom.length()<1 || nom.length()>60){
            throw new WikilocException("Error en crear Punt. El nom ha de tenir entre 1 i 60 caràcters");
        }
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        if (desc==null || desc.length()<1 || desc.length()>60){
            throw new WikilocException("Error en crear Punt. La descripció ha de tenir entre 1 i 60 caràcters");
        }
        this.desc = desc;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        if (latitude<-90.0 || latitude > 90.0){
            throw new WikilocException("Error en crear Punt. La latitud ha d'estar entre -90 i 90º");
        }
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        if (longitude<-180.0 || longitude > 180.0){
            throw new WikilocException("Error en crear Punt. La longitud ha d'estar entre -180 i 180º");
        }
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        //mirar possibles valors altitud
        this.altitude = altitude;
    }

    public void setTipus(Tipus tipus) {
        this.tipus = tipus;
    }
    
    public Tipus getTipus(){
        return tipus;
    }

    @Override
    public String toString() {
        return "Punt{" + "id=" + id + ", ruta=" + ruta + ", nom=" + nom + ", desc=" + desc + ", foto=" + foto + ", latitude=" + latitude + ", longitude=" + longitude + ", altitude=" + altitude + ", tipus=" + tipus + '}';
    }
    
    
    
}
