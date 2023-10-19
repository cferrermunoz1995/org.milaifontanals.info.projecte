
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
import java.sql.ResultSet;
import oracle.sql.BLOB;
import oracle.sql.CLOB;
import java.sql.Savepoint;
import oracle.sql.DATE;
import P1_T5_InterficiePersistencia_FerrerMuñozCarles.IGestorBDWikiloc;
import P1_T5_InterficiePersistencia_FerrerMuñozCarles.IGestorBDWikilocException;
import java.util.HashMap;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author isard
 */
public class ConnexioGeneral implements IGestorBDWikiloc{
    /*
     * Aquest objecte és el que ha de mantenir la connexió amb el SGBD Es crea
     * en el constructor d'aquesta classe i manté la connexió fins que el
     * programador decideix tancar la connexió amb el mètode tancarCapa
     */
    private static Connection conn;
    
    /**
     * Sentències preparades que es crearan només 1 vegada i s'utilitzaran
     * tantes vegades com siguin necessàries. En aquest programa es creen la
     * primera vegada que es necessiten i encara no han estat creades. També es
     * podrien crear al principi del programa, una vegada establerta la
     * connexió.
     */
    private PreparedStatement psDelRuta;
    private PreparedStatement psInsPunt;
    private PreparedStatement psPossibleElimRuta;
    private PreparedStatement psContrasenya;
    
    private ConnexioGeneral() throws WikilocException {
//        this("Oracle.properties");
    }
    
    /**
     * Estableix la connexió amb la BD. Les dades que necessita (url, usuari i
     * contrasenya) es llegiran d'un fitxer de configuració anomenat
     * empresaJDBC.xml" que cercarà a l'arrel de l'aplicació i que ha de
     * contenir les següents claus: url, user, password
     *
     * En cas que l'aplicació s'executés en Java anterior a 1.6, caldria també
     * passar el nom de la classe JDBC que permet la connexió amb el SGBDR.
     *
     * @throws IGestorBDWikilocException
     */
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
    
    /**
     * Tanca la connexió
     *
     * @throws IGestorBDWikilocException
     */
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
    public List<Ruta> obtenirLlistaRuta(String usuari, DATE date_inici, DATE data_final, String nom) throws IGestorBDWikilocException {
        List<Ruta> rutes = new ArrayList<>();
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        String sql = "SELECT ruta.id_ruta, ruta.titol_ruta, ruta.distancia_ruta, ruta.descrip_ruta, ruta.id_usuari_ruta, count(punt.nom_punt) as count FROM ruta INNER JOIN punt";
        sql += "ON  ruta.id_ruta = punt.id_ruta_punt ";
        sql += "where \n";
        sql += "ruta.id_usuari_ruta like 'cferrer1' group by ruta.id_ruta, ruta.titol_ruta, ruta.descrip_ruta, ruta.distancia_ruta, ruta.id_usuari_ruta";
        String sql2 = "select TEXT_LONG_RUTA from ruta where id_ruta like ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuari);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //Ruta(int id, HashMap<Integer, Punt> punts, String titol, String text, double distancia, double duracio, double desnivell_positiu, 
                //double desnivell_negatiu, int dificultat, int numPunts, double nota_mitja_valoracio, String description)
                int sum_val_ruta = rs.getInt("ruta.sum_val_ruta");
                int num_com_ruta = rs.getInt("ruta.num_com_ruta");
                int id = rs.getInt("ruta.id_ruta");
                ps2 = conn.prepareStatement(sql2);
                ps2.setInt(1, id);
                ResultSet rs2 = ps.executeQuery();
                rs2.next();
                String text_long_ruta;
//                text_long_ruta = rs2.getClob("TEXT_LONG_RUTA");
                String titol_ruta = rs.getString("titol_ruta");
                double distancia_ruta = rs.getDouble("ruta.distancia_ruta");
                rutes.add(new Ruta(id, null, titol_ruta, text_long_ruta, distancia_ruta, ));
            }
        } catch (SQLException ex) {
            throw new IGestorBDWikilocException("Error en iniciar sessió");
        }
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
        if (psDelRuta == null){
            try {
                psDelRuta = conn.prepareStatement("Delete from ruta where id_ruta = ?");
            } catch (SQLException ex) {
                throw new IGestorBDWikilocException("Error en prepara sentència psDelRuta");
            }
        }
        Savepoint sp = null;
        try {
            sp = conn.setSavepoint();
            psDelRuta.setInt(1,ruta.getId());
            psDelRuta.executeUpdate();
        } catch (SQLException ex) {
            if (sp != null) {
                try {
                    conn.rollback(sp);
                } catch (SQLException ex1) {
                }
            }
            throw new IGestorBDWikilocException("Error en eliminar la ruta de codi indicat", ex);
        }
    }

    @Override
    public void crearPunt(Punt punt) throws IGestorBDWikilocException {
        if (psInsPunt == null){
            try {
                psDelRuta = conn.prepareStatement("insert into punt (num_punt, id_ruta_punt, nom_punt, desc_punt, foto_punt, lat_punt, lon_punt, tipus_punt, alt_punt) values (null,?,?,?,null,?,?,?,?)");
            } catch (SQLException ex) {
                throw new IGestorBDWikilocException("Error en preparar sentència psInsPunt");
            }
        }
        try {
            psInsPunt.setInt(1, punt.getRuta().getId());
            psInsPunt.setString(2, punt.getNom());
            psInsPunt.setString(3,punt.getDesc());
//            psInsPunt.setBlob(4, punt.getFoto()); //canviar valor al ps i valor als següents sets
            psInsPunt.setDouble(4, punt.getLatitude());
        } catch (SQLException ex) {
            throw new IGestorBDWikilocException("Error en intentar inserir punt: "+punt.getNom());
        }
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
    public HashMap<Integer,Punt> obtenirPunts(Ruta ruta) throws IGestorBDWikilocException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean comprovarContrasenya(String login, String contrasenya) {
        if (psContrasenya == null){
            try {
                psContrasenya = conn.prepareStatement("select email_usuari from usuari where login_usuari like ? and contrasenya_usuari like ?");
            } catch (SQLException ex) {
                throw new IGestorBDWikilocException("Error en iniciar sessió");
            }  
        }
        try {
            psContrasenya.setString(1, login);
            psContrasenya.setString(2, contrasenya);
            ResultSet rs = psContrasenya.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            throw new IGestorBDWikilocException("Error en iniciar sessió");
        }
    }
    
    public boolean podemEliminarRuta(Ruta ruta) throws IGestorBDWikilocException{
        if (psPossibleElimRuta == null) {
            try {
                psPossibleElimRuta = conn.prepareStatement("select + from comentari where = ?");
            } catch (SQLException ex) {
                throw new IGestorBDWikilocException("Error en prepara sentència psPossibleElimRuta");
            }
        }
        try {
            psPossibleElimRuta.setInt(1, ruta.getId());
            ResultSet rs = psPossibleElimRuta.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            throw new IGestorBDWikilocException("Error en saber si la ruta es pot eliminar");
        }
    }
    
    
}