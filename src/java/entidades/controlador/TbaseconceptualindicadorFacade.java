/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.controlador;

import entidades.Tbaseconceptualindicador;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ramiro
 */
@Stateless
public class TbaseconceptualindicadorFacade extends AbstractFacade<Tbaseconceptualindicador> {
    @PersistenceContext(unitName = "ProyectoPlanCurricularPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbaseconceptualindicadorFacade() {
        super(Tbaseconceptualindicador.class);
    }
    
}
