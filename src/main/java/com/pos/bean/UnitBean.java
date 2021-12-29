/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.pos.bean;


import com.pos.entity.Unit;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Tavi
 */
@Stateless
public class UnitBean {

@PersistenceContext
    private EntityManager em;

    public List<Unit> getAllUnits() {
        try {
            TypedQuery<Unit> query = em.createNamedQuery("Unit.findAll", Unit.class);
            List<Unit> result = (List<Unit>) query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public Unit findById(Integer unitId) {
        return em.find(Unit.class, unitId);
    }

    public Unit findByName(String unitName) {
        TypedQuery<Unit> query = em.createNamedQuery("Unit.findByUnit", Unit.class);
        query.setParameter("unit", unitName);
        Unit result = query.getSingleResult();

        return result;
    }

    public void createUnit(String unitName) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        Unit unit = new Unit();
        unit.setUnit(unitName);

        em.persist(unit);
    }

    public void updateUnit(Unit unit, String newUnitName) {
        if (!em.contains(unit)) {
            unit = em.merge(unit);
        }
        unit.setUnit(newUnitName);
    }

    public void deleteUnit(Unit nuit) {
        if (!em.contains(nuit)) {
            nuit = em.merge(nuit);
        }
        em.remove(nuit);
    }}
