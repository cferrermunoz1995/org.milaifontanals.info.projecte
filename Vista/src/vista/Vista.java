/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import P1_T5_CapaOracle_FerrerMuñozCarles.ConnexioGeneral;
import P1_T5_InterficiePersistencia_FerrerMuñozCarles.IGestorBDWikiloc;
import P1_T5_Model_FerrerMuñozCarles.WikilocException;
import java.awt.TextArea;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author isard
 */
public class Vista extends JFrame{
    private IGestorBDWikiloc gBD = null;
    private static String nomClassePersistencia = null;
    private TextArea txtInfo;
    private JTextField codi;
    private JTextField desc;
    
    public static void main(String[] args) {
        if (args.length == 0){
            System.out.println("Cal passar el nom de la classe que dona la persistència com a primer argument");
            System.exit(0);
        }
        nomClassePersistencia = args[0];
        System.out.println(nomClassePersistencia);
        Vista vista = new Vista();
        vista.go();
    }

    private void go() {
        try {
            gBD = (IGestorBDWikiloc) Class.forName(nomClassePersistencia).newInstance();
            JFrame frame = new Login();
            frame.setVisible(true);
            
            
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error en connectar-se a la base de dades", "Error", 1);
            System.exit(WIDTH);
        }
    }
    
    private String infoError(Throwable ex) {
        String aux;
        String info = ex.getMessage();
        if (info != null) {
            info += "\n";
        }
        while (ex.getCause() != null) {
            aux = ex.getCause().getMessage();
            if (aux != null) {
                aux += "\n";
            }
            info = info + aux;
            ex = ex.getCause();
        }
        return info;
    }
    
    
}
