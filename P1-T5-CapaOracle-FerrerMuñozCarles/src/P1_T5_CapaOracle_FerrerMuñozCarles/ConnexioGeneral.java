
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package P1_T5_CapaOracle_FerrerMuñozCarles;

import P1_T5_Model_FerrerMuñozCarles.Punt;
import P1_T5_Model_FerrerMuñozCarles.Ruta;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Properties;
import P1_T5_Model_FerrerMuñozCarles.WikilocException;
import java.util.List;
import oracle.sql.BLOB;
import oracle.sql.DATE;
import P1_T5_InterficiePersistencia_FerrerMuñozCarles.IGestorBDWikiloc;
import P1_T5_InterficiePersistencia_FerrerMuñozCarles.IGestorBDWikilocException;
/**
 *
 * @author isard
 */
public class ConnexioGeneral implements IGestorBDWikiloc{   
    private static Connection conn;
    
    private ConnexioGeneral() throws WikilocException {
//        this("Oracle.properties");
    }
    
    private ConnexioGeneral(String nomFitxerPropietats) throws IGestorBDWikilocException {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(nomFitxerPropietats));
            String[] claus = {"url", "user", "password"};
            String[] valors = new String[3];
            for (int i = 0; i < claus.length; i++) {
                valors[i] = props.getProperty(claus[i]);
                if (valors[i] == null || valors[i].isEmpty()) {
                    throw new IGestorBDWikilocException("L'arxiu " + nomFitxerPropietats + " no troba la clau " + claus[i]);
                }
            }
            conn = DriverManager.getConnection(valors[0], valors[1], valors[2]);
            conn.setAutoCommit(false);
        } catch (IOException ex) {
            throw new IGestorBDWikilocException("Problemes en recuperar l'arxiu de configuració " + nomFitxerPropietats + "\n" + ex.getMessage());
        } catch (SQLException ex) {
            throw new IGestorBDWikilocException("No es pot establir la connexió.\n" + ex.getMessage());
        }
    }

    public static Connection getConnection() throws IGestorBDWikilocException {
        if (conn == null) {
            new ConnexioGeneral();
        }
        return conn;
    }
    
    public void close() throws IGestorBDWikilocException {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new IGestorBDWikilocException("Error en fer rollback final.\n" + ex.getMessage());
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new IGestorBDWikilocException("Error en tancar la connexió.\n" + ex.getMessage());
            }
        }
    }
    
    public void validateChanges() throws IGestorBDWikilocException {
        try {
            conn.commit();
        } catch (SQLException ex) {
            throw new IGestorBDWikilocException("Error en validar els canvis.\n" + ex.getMessage());
        }
    }
    
    public void undoChanges() throws IGestorBDWikilocException {
        try {
            conn.commit();
        } catch (SQLException ex) {
            throw new IGestorBDWikilocException("Error en desfer els canvis.\n" + ex.getMessage());
        }
    }

    @Override
    public List<Ruta> obtenirLlistaRuta(int usuari, DATE date_inici, DATE data_final, String nom) throws IGestorBDWikilocException {
        return null;
    }

    @Override
    public void actualitzarRuta(Ruta ruta) throws IGestorBDWikilocException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void afegirRuta(Ruta ruta) throws IGestorBDWikilocException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarRuta(Ruta ruta) throws IGestorBDWikilocException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void crearPunt(Punt punt) throws IGestorBDWikilocException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarPunt(Punt punt) throws IGestorBDWikilocException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualitzarPunt(Punt punt) throws IGestorBDWikilocException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Punt> obtenirPunts(Ruta ruta) throws IGestorBDWikilocException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}