package entidades.modelo;

import entidades.Tbaseconceptualindicador;
import entidades.modelo.util.JsfUtil;
import entidades.modelo.util.JsfUtil.PersistAction;
import entidades.controlador.TbaseconceptualindicadorFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "tbaseconceptualindicadorController")
@SessionScoped
public class TbaseconceptualindicadorController implements Serializable {

    @EJB
    private entidades.controlador.TbaseconceptualindicadorFacade ejbFacade;
    private List<Tbaseconceptualindicador> items = null;
    private Tbaseconceptualindicador selected;

    public TbaseconceptualindicadorController() {
    }

    public Tbaseconceptualindicador getSelected() {
        return selected;
    }

    public void setSelected(Tbaseconceptualindicador selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TbaseconceptualindicadorFacade getFacade() {
        return ejbFacade;
    }

    public Tbaseconceptualindicador prepareCreate() {
        selected = new Tbaseconceptualindicador();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TbaseconceptualindicadorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TbaseconceptualindicadorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TbaseconceptualindicadorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tbaseconceptualindicador> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<Tbaseconceptualindicador> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tbaseconceptualindicador> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tbaseconceptualindicador.class)
    public static class TbaseconceptualindicadorControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TbaseconceptualindicadorController controller = (TbaseconceptualindicadorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tbaseconceptualindicadorController");
            return controller.getFacade().find(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Tbaseconceptualindicador) {
                Tbaseconceptualindicador o = (Tbaseconceptualindicador) object;
                return getStringKey(o.getTbaseconceptualindicadorcodigo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tbaseconceptualindicador.class.getName()});
                return null;
            }
        }

    }

}
