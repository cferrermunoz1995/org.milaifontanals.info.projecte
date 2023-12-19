/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P1_T5_InterficiePersistencia_FerrerMuñozCarles;

/**
 *
 * @author isard
 */
public class IGestorBDWikilocException extends RuntimeException{
    public IGestorBDWikilocException(String message){
        super(message);
    }

    public IGestorBDWikilocException(String message, Throwable cause) {
        super(message, cause);
    }
}
