/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package connexio;

import java.util.List;
import model.Punt;
import model.Ruta;
import model.WikilocException;
import oracle.sql.DATE;

/**
 *
 * @author isard
 */
public interface IGestorWikiloc {
    
    void close() throws WikilocException;
    
    List<Ruta> obtenirLlistaRuta(int usuari, DATE date_inici, DATE data_final, String nom) throws WikilocException;
    
    void actualitzarRuta(Ruta ruta) throws WikilocException;
    
    void afegirRuta(Ruta ruta) throws WikilocException;
    
    void eliminarRuta(Ruta ruta) throws WikilocException;
    
    void validateChanges() throws WikilocException;
    
    void undoChanges() throws WikilocException;
    
    void crearPunt(Punt punt) throws WikilocException;
    
    void eliminarPunt(Punt punt) throws WikilocException;
    
    void actualitzarPunt(Punt punt) throws WikilocException;
    
    List<Punt> obtenirPunts(Ruta ruta) throws WikilocException;
}
