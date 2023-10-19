/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package P1_T5_InterficiePersistencia_FerrerMuñozCarles;

import java.util.List;
import P1_T5_Model_FerrerMuñozCarles.Punt;
import P1_T5_Model_FerrerMuñozCarles.Ruta;
import java.util.HashMap;
import oracle.sql.DATE;

/**
 *
 * @author isard
 */
public interface IGestorBDWikiloc {
    
    void close() throws IGestorBDWikilocException;
    
    boolean comprovarContrasenya(String login, String contrasenya);
    
    List<Ruta> obtenirLlistaRuta(String usuari, DATE date_inici, DATE data_final, String nom) throws IGestorBDWikilocException;
    
    void actualitzarRuta(Ruta ruta) throws  IGestorBDWikilocException;
    
    void afegirRuta(Ruta ruta) throws IGestorBDWikilocException;
    
    void eliminarRuta(Ruta ruta) throws IGestorBDWikilocException;
    
    void validateChanges() throws IGestorBDWikilocException;
    
    void undoChanges() throws IGestorBDWikilocException;
    
    void crearPunt(Punt punt) throws IGestorBDWikilocException;
    
    void eliminarPunt(Punt punt) throws IGestorBDWikilocException;
    
    void actualitzarPunt(Punt punt) throws IGestorBDWikilocException;
    
    HashMap<Integer,Punt> obtenirPunts(Ruta ruta) throws IGestorBDWikilocException;
    
    boolean podemEliminarRuta(Ruta ruta) throws IGestorBDWikilocException;
}
