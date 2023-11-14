/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package encriptar_pass;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author isard
 */
public class Encriptar_pass {

    
    public static void main(String[] args) {
        // TODO code application logic here
        String[] passs = {"cferrer1", "cferrer2", "cferrer3", "cferrer4"};
        MessageDigest digest = null;
        for (String s : passs){
            try {
                digest = MessageDigest.getInstance("SHA-256");
                byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));
                StringBuffer hexString = new StringBuffer();

                for (int i=0; i<hash.length; i++){
                    String hex = Integer.toHexString(0xff & hash[i]);
                    if (hex.length()==1)hexString.append('0');
                    hexString.append(hex);
                }

                System.out.println("Password: "+s+", hash: "+hexString);
            } catch (NoSuchAlgorithmException ex) {
                    System.out.println("Error en encriptar "+s);
            }
        }
    }
    
}
