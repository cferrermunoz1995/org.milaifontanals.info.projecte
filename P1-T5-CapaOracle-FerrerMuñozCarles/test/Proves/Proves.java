/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proves;

import P1_T5_CapaOracle_FerrerMuñozCarles.ConnexioGeneral;
import P1_T5_Model_FerrerMuñozCarles.Ruta;
import P1_T5_Model_FerrerMuñozCarles.Tipus;
import P1_T5_Model_FerrerMuñozCarles.Usuari;
import P1_T5_Model_FerrerMuñozCarles.WikilocException;
import java.util.List;

/**
 *
 * @author isard
 */
public class Proves {
    private static ConnexioGeneral gBD;
    
    public static void main(String[] args) {
        Ruta r1 = new Ruta(1,null,"Títol","Text", 10, 10,10,10,1,5,4,"Descripció");
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
        mostrarRutes(new Usuari("cferrer1","cferrer1","cferrer1"));
        mostratTipus();
        System.out.println("");
        //Prova afegir ruta
        //Prova afegir Punt
        //Prova Eliminar Punt
    }

    private static void mostrarRutes(Usuari usuari) {
        try {
            System.out.println("Recuperació de Rutes");
            List<Ruta> rutes = gBD.obtenirLlistaRuta(usuari.getLogin(), null, null, "");
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

    private static void mostratTipus() {
        try {
            System.out.println("Recuperació de Rutes");
            List<Tipus> tipus = gBD.getListTipus();
            if (tipus.isEmpty()){
                System.out.println("No hi ha tipus");
            } else {
                System.out.println("Liista de tipus:");
                for (Tipus t : tipus){
                    System.out.println(t);
                }
            }
        } catch (WikilocException ex){
            System.out.println("\tError: "+ex.getMessage());
        }
    }
}
