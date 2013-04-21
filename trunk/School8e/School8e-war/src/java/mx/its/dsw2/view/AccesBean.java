/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author franciscojavier
 */
@ManagedBean
@SessionScoped
public class AccesBean {
     private String user="";
     private String password="";

    /**
     * Creates a new instance of AccesBean
     */
    public AccesBean() {
    }
    
     public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //------------Actions--------
    public String procesarAction(){
        if(user.equals("root")&&password.equals("123")){
        return "MenuPrincipal";
    }else{
            return "pagina2";
        }
    }

   
}
