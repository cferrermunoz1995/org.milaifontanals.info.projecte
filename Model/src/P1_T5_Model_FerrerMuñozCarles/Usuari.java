/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P1_T5_Model_FerrerMuñozCarles;

import P1_T5_Model_FerrerMuñozCarles.WikilocException;
import java.sql.Blob;

/**
 *
 * @author isard
 */
public class Usuari {
    private String email;//obligatori,pk
    private String login;//obligatori
    private String contrasenya;//obligatori i unique
    private Blob foto;//opcional

    public Usuari(String email, String login, String contrasenya, Blob foto) {
        setEmail(email);
        setLogin(login);
        setContrasenya(contrasenya);
        setFoto(foto);
    }

    public Usuari(String email, String login, String contrasenya) {
        this.email = email;
        this.login = login;
        this.contrasenya = contrasenya;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            throw new WikilocException("Error en crear usuari. Email no vàlid");
        }
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login==null||login.length()<1||login.length()>60){
            throw new WikilocException("Error en crear usuari. Login incorrecte");
        }
        this.login = login;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        if (contrasenya==null||contrasenya.length()<8||contrasenya.length()>60){
            throw new WikilocException("Error en crear usuari. Contrasenya incorrecta");
        }
        this.contrasenya = contrasenya;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }
    
    
}
