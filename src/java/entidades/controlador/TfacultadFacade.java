/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.controlador;

import entidades.Tfacultad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ramiro
 */
@Stateless
public class TfacultadFacade extends AbstractFacade<Tfacultad> {
    @PersistenceContext(unitName = "ProyectoPlanCurricularPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TfacultadFacade() {
        super(Tfacultad.class);
    }
    
}
