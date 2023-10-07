/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connexio;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;
import model.WikilocException;
/**
 *
 * @author isard
 */
public class ConnexioGeneral {   
    private static Connection conn;
    
    private ConnexioGeneral() throws WikilocException {
//        this("Oracle.properties");
    }
    
    private ConnexioGeneral(String nomFitxerPropietats) throws WikilocException {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(nomFitxerPropietats));
            String[] claus = {"url", "user", "password"};
            String[] valors = new String[3];
            for (int i = 0; i < claus.length; i++) {
                valors[i] = props.getProperty(claus[i]);
                if (valors[i] == null || valors[i].isEmpty()) {
                    throw new WikilocException("L'arxiu " + nomFitxerPropietats + " no troba la clau " + claus[i]);
                }
            }
            conn = DriverManager.getConnection(valors[0], valors[1], valors[2]);
            conn.setAutoCommit(false);
        } catch (IOException ex) {
            throw new WikilocException("Problemes en recuperar l'arxiu de configuració " + nomFitxerPropietats + "\n" + ex.getMessage());
        } catch (SQLException ex) {
            throw new WikilocException("No es pot establir la connexió.\n" + ex.getMessage());
        }
    }

    public static Connection getConnection() throws WikilocException {
        if (conn == null) {
            new ConnexioGeneral();
        }
        return conn;
    }
    
    public static void close() throws WikilocException {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new WikilocException("Error en fer rollback final.\n" + ex.getMessage());
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new WikilocException("Error en tancar la connexió.\n" + ex.getMessage());
            }
        }
    }
    
    public static void validateChanges() throws WikilocException {
        try {
            conn.commit();
        } catch (SQLException ex) {
            throw new WikilocException("Error en validar els canvis.\n" + ex.getMessage());
        }
    }
    
    public static void undoChanges() throws WikilocException {
        try {
            conn.commit();
        } catch (SQLException ex) {
            throw new WikilocException("Error en desfer els canvis.\n" + ex.getMessage());
        }
    }
}
