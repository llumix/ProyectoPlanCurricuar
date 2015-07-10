package entidades.modelo;

import entidades.Tcarreracriteriosubcriterio;
import entidades.modelo.util.JsfUtil;
import entidades.modelo.util.JsfUtil.PersistAction;
import entidades.controlador.TcarreracriteriosubcriterioFacade;

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

@ManagedBean(name = "tcarreracriteriosubcriterioController")
@SessionScoped
public class TcarreracriteriosubcriterioController implements Serializable {

    @EJB
    private entidades.controlador.TcarreracriteriosubcriterioFacade ejbFacade;
    private List<Tcarreracriteriosubcriterio> items = null;
    private Tcarreracriteriosubcriterio selected;

    public TcarreracriteriosubcriterioController() {
    }

    public Tcarreracriteriosubcriterio getSelected() {
        return selected;
    }

    public void setSelected(Tcarreracriteriosubcriterio selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TcarreracriteriosubcriterioFacade getFacade() {
        return ejbFacade;
    }

    public Tcarreracriteriosubcriterio prepareCreate() {
        selected = new Tcarreracriteriosubcriterio();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TcarreracriteriosubcriterioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TcarreracriteriosubcriterioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TcarreracriteriosubcriterioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Tcarreracriteriosubcriterio> getItems() {
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

    public List<Tcarreracriteriosubcriterio> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Tcarreracriteriosubcriterio> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Tcarreracriteriosubcriterio.class)
    public static class TcarreracriteriosubcriterioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TcarreracriteriosubcriterioController controller = (TcarreracriteriosubcriterioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tcarreracriteriosubcriterioController");
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
            if (object instanceof Tcarreracriteriosubcriterio) {
                Tcarreracriteriosubcriterio o = (Tcarreracriteriosubcriterio) object;
                return getStringKey(o.getTcarreracriteriosubcriteriocodigo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Tcarreracriteriosubcriterio.class.getName()});
                return null;
            }
        }

    }

}
