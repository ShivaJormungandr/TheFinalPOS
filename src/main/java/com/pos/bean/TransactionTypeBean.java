/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.pos.bean;


import com.pos.entity.TransactionType;
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
public class TransactionTypeBean {

        @PersistenceContext
    private EntityManager em;

    public List<TransactionType> getAllCategories() {
        try {
            TypedQuery<TransactionType> query = em.createNamedQuery("TransactionType.findAll", TransactionType.class);
            List<TransactionType> result = (List<TransactionType>) query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public TransactionType findById(Integer categoryId) {
        return em.find(TransactionType.class, categoryId);
    }

    public TransactionType findByName(String typeName) {
        TypedQuery<TransactionType> query = em.createNamedQuery("TransactionType.findByType", TransactionType.class);
        query.setParameter("type", typeName);
        TransactionType result = query.getSingleResult();

        return result;
    }

    public void createTransactionType(String typeName) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        TransactionType type = new TransactionType();
        type.setType(typeName);

        em.persist(type);
    }

    public void updateTransactionType(TransactionType type, String newTransactionTypeName) {
        if (!em.contains(type)) {
            type = em.merge(type);
        }
        type.setType(newTransactionTypeName);
    }

    public void deleteTransactionType(TransactionType type) {
        if (!em.contains(type)) {
            type = em.merge(type);
        }
        em.remove(type);
    }

}
