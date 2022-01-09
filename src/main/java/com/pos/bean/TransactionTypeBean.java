package com.pos.bean;


import com.pos.entity.TransactionType;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class TransactionTypeBean {

        @PersistenceContext
    private EntityManager entityManager;

    public List<TransactionType> getAllCategories() {
        try {
            TypedQuery<TransactionType> query = entityManager.createNamedQuery("TransactionType.findAll", TransactionType.class);
            List<TransactionType> result = (List<TransactionType>) query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public TransactionType findById(Integer categoryId) {
        return entityManager.find(TransactionType.class, categoryId);
    }

    public TransactionType findByName(String typeName) {
        TypedQuery<TransactionType> query = entityManager.createNamedQuery("TransactionType.findByType", TransactionType.class);
        query.setParameter("type", typeName);
        TransactionType result = query.getSingleResult();

        return result;
    }

    public void createTransactionType(String typeName) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        TransactionType type = new TransactionType();
        type.setType(typeName);

        entityManager.persist(type);
    }

    public void updateTransactionType(TransactionType type, String newTransactionTypeName) {
        if (!entityManager.contains(type)) {
            type = entityManager.merge(type);
        }
        type.setType(newTransactionTypeName);
    }

    public void deleteTransactionType(TransactionType type) {
        if (!entityManager.contains(type)) {
            type = entityManager.merge(type);
        }
        entityManager.remove(type);
    }

}
