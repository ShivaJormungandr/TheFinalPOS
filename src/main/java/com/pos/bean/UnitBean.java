package com.pos.bean;


import com.pos.entity.Unit;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class UnitBean {

@PersistenceContext
    private EntityManager entityManager;

    public List<Unit> getAllUnits() {
        try {
            TypedQuery<Unit> query = entityManager.createNamedQuery("Unit.findAll", Unit.class);
            List<Unit> result = (List<Unit>) query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public Unit findById(Integer unitId) {
        return entityManager.find(Unit.class, unitId);
    }

    public Unit findByName(String unitName) {
        TypedQuery<Unit> query = entityManager.createNamedQuery("Unit.findByUnit", Unit.class);
        query.setParameter("unit", unitName);
        Unit result = query.getSingleResult();

        return result;
    }

    public void createUnit(String unitName) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        Unit unit = new Unit();
        unit.setUnit(unitName);

        entityManager.persist(unit);
    }

    public void updateUnit(Unit unit, String newUnitName) {
        if (!entityManager.contains(unit)) {
            unit = entityManager.merge(unit);
        }
        unit.setUnit(newUnitName);
    }

    public void deleteUnit(Unit nuit) {
        if (!entityManager.contains(nuit)) {
            nuit = entityManager.merge(nuit);
        }
        entityManager.remove(nuit);
    }}
