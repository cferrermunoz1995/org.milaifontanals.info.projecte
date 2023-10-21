/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package P1_T5_InterficiePersistencia_FerrerMuñozCarles;

import java.util.List;
import P1_T5_Model_FerrerMuñozCarles.Punt;
import P1_T5_Model_FerrerMuñozCarles.Ruta;
import P1_T5_Model_FerrerMuñozCarles.Tipus;
import P1_T5_Model_FerrerMuñozCarles.Usuari;
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
    
    boolean actualitzarRuta(Ruta ruta) throws  IGestorBDWikilocException;
    
    boolean afegirRuta(Ruta ruta, Usuari usuari) throws IGestorBDWikilocException;
    
    boolean eliminarRuta(Ruta ruta) throws IGestorBDWikilocException;
    
    void validateChanges() throws IGestorBDWikilocException;
    
    void undoChanges() throws IGestorBDWikilocException;
    
    boolean afegirPunt(Punt punt) throws IGestorBDWikilocException;
    
    boolean eliminarPunt(Punt punt) throws IGestorBDWikilocException;
    
    boolean actualitzarPunt(Punt punt) throws IGestorBDWikilocException;
    
    List<Punt> obtenirPunts(Ruta ruta) throws IGestorBDWikilocException;
    
    boolean podemEliminarRuta(Ruta ruta) throws IGestorBDWikilocException;
    
    List<Tipus> getListTipus() throws IGestorBDWikilocException;
}
