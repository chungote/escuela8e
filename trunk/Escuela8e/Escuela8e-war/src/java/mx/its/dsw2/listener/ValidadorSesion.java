/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.its.dsw2.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
import org.jboss.weld.context.http.Http;

/**
 *
 * @author franciscojavier
 */
public class ValidadorSesion implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext fc = event.getFacesContext();
        UIViewRoot viewRoot = fc.getViewRoot();
        if (viewRoot !=null && !viewRoot.getViewId().equalsIgnoreCase("/Login.xhtml")){
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            if (session == null || session.getAttribute("USUARIO_LOGUEADO") == null){
            NavigationHandler nh = fc.getApplication().getNavigationHandler();
            nh.handleNavigation(fc, null, "Login");
            fc.renderResponse();
        }
        } 

    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
