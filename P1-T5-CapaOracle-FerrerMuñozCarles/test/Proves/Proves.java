/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proves;

import P1_T5_CapaOracle_FerrerMuñozCarles.ConnexioGeneral;
import P1_T5_Model_FerrerMuñozCarles.Punt;
import P1_T5_Model_FerrerMuñozCarles.Ruta;
import P1_T5_Model_FerrerMuñozCarles.Tipus;
import P1_T5_Model_FerrerMuñozCarles.Usuari;
import P1_T5_Model_FerrerMuñozCarles.WikilocException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author isard
 */
public class Proves {
    private static ConnexioGeneral gBD;
    
    public static void main(String[] args) {
        try {
            System.out.println("Intent de creació de la capa");
            gBD = new ConnexioGeneral("WikilocJDBC.xml");
        } catch (WikilocException ex){
            ex.printStackTrace();
            System.out.println("Problema en crear capa de persistència:");
            System.out.println(ex.getMessage());
            System.out.println("Avortem programa");
            return;
        }
        List<Tipus> tipus = gBD.getListTipus();
        Usuari user = new Usuari("cferrer1","cferrer1","cferrer1");
        Ruta r1 = new Ruta(4,null,"Títol prova","Text prova", 10, 10,10,10,1,0,4,"Descripció", "cferrer1", new Timestamp(System.currentTimeMillis()));
        
        Punt p1 = new Punt(15,r1,"punt prova", "descripció prova", null, 45,45,45,tipus.get(0));
        
        mostrarTipus(tipus);
        if (gBD.comprovarContrasenya("cferrer1", "cferrer1")){
            System.out.println("He entrat");
        } else {
            System.out.println("xd");
        }
        //Prova afegir ruta
        System.out.println("Prova afegir ruta");
        if (gBD.afegirRuta(r1, user)){
            System.out.println("Ruta afegida: "+r1);
        } else {
            System.out.println("Ruta no afegida");
        }
        gBD.validateChanges();
        //Prova update ruta canviem el text
        r1.setText("Prova update ruta");
        r1.setTitol("Títol update");
        if (gBD.actualitzarRuta(r1)){
            System.out.println("Ruta update: "+r1);
        } else {
            System.out.println("Punt no afegit");
        }
        gBD.validateChanges();
        //Prova afegir Punt
        if (gBD.afegirPunt(p1)){
            System.out.println("Punt afegit");
        } else {
            System.out.println("Punt no afegit");
        }
        gBD.validateChanges();
        //Prova actualitzar Punt
        p1.setDesc("Punt update desc");
        p1.setNom("Nom update punt");
        if (gBD.actualitzarPunt(p1)){
            System.out.println("Punt actualitzat");
        } else {
            System.out.println("Punt no actualitzat");
        }
        System.out.println(p1);
        gBD.validateChanges();
        System.out.println("Punts");
        List<Punt> punts = gBD.obtenirPunts(r1);
        for (int i=0; i<punts.size();i++){
            System.out.println(punts.get(i));
        }
        //Prova Eliminar Punt
        if (gBD.eliminarPunt(p1)){
            System.out.println("Punt eliminat");
        } else {
            System.out.println("Punt no eliminat");
        }
        gBD.validateChanges();
        //Prova podem eliminar ruta, útil en el cas de que estiguem mirant si la ruta té comentaris
        System.out.println("Prova podemEliminarRuta");
        if (gBD.podemEliminarRuta(r1)){
            System.out.println("Ruta no possible eliminar");
        } else {
            System.out.println("Ruta possible eliminar");
        }
        gBD.validateChanges();
        //Prova eliminar Ruta
        if (gBD.eliminarRuta(r1)){
            System.out.println("Ruta eliminada");
        } else {
            System.out.println("Ruta no eliminada");
        }
        gBD.validateChanges();
        
        mostrarRutes(user);
    }

    private static void mostrarRutes(Usuari usuari) {
        try {
            System.out.println("Recuperació de Rutes");
            List<Ruta> rutes = gBD.obtenirLlistaRuta(usuari.getLogin(), null, null, null);
            if (rutes.isEmpty()){
                System.out.println("No hi ha rutes");
            } else {
                System.out.println("Liista de Rutes:");
                for (Ruta r : rutes){
                    System.out.println(r);
                }
            }
        } catch (WikilocException ex){
            System.out.println("\tError: "+ex.getMessage());
        }
    }

    private static void mostrarTipus(List<Tipus> tipus) {
        try {
            System.out.println("Recuperació de Rutes");
            if (tipus.isEmpty()){
                System.out.println("No hi ha tipus");
            } else {
                System.out.println("Llista de tipus:");
                for (Tipus t : tipus){
                    System.out.println(t);
                }
            }
        } catch (WikilocException ex){
            System.out.println("\tError: "+ex.getMessage());
        }
    }
}
