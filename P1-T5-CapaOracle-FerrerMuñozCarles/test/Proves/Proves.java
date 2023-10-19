/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proves;

import P1_T5_CapaOracle_FerrerMuñozCarles.ConnexioGeneral;
import P1_T5_Model_FerrerMuñozCarles.Ruta;

/**
 *
 * @author isard
 */
public class Proves {
    private static ConnexioGeneral gBD;
    
    public static void main(String[] args) {
        Ruta r1 = new Ruta(1,null,"Títol","Text", 10, 10,10,10,1,5,4,"Descripció");
        System.out.println(r1.toString());
    }
}
