/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import P1_T5_CapaOracle_FerrerMuñozCarles.ConnexioGeneral;
import P1_T5_Model_FerrerMuñozCarles.WikilocException;

/**
 *
 * @author isard
 */
public class Vista {
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
    }
    
}
