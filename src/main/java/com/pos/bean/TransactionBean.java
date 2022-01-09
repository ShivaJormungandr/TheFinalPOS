 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.pos.bean;

import com.pos.entity.Product;
import com.pos.entity.TransactedProducts;
import com.pos.entity.TransactionTable;
import com.pos.entity.TransactionType;
import com.pos.entity.UserTable;
import com.pos.utility.ParseDateTime;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Tavi
 */
@Stateless
public class TransactionBean {

    @PersistenceContext
    private EntityManager em;

    public List<TransactionTable> getAllTransactions() {
        try {
            TypedQuery<TransactionTable> query = em.createNamedQuery("TransactionTable.findAll", TransactionTable.class);
            List<TransactionTable> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<TransactionTable> getTransactionsBetweenDates(String dateFrom, String dateTo) {
        try {
            Query query = em.createQuery("SELECT t FROM TransactionTable t WHERE t.transactionDate BETWEEN '" + ParseDateTime.parseTimestamp(dateFrom) + "' AND '" + ParseDateTime.parseTimestamp(dateTo) + "'");
            List<TransactionTable> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<TransactionTable> getTransactionsBetweenValues(double valueFrom, double valueTo) {
        try {
            Query query = em.createQuery("SELECT t FROM TransactionTable t WHERE t.value BETWEEN " + valueFrom + " AND " + valueTo);
            List<TransactionTable> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<TransactedProducts> getProductsFromTransaction(TransactionTable transaction) {
        try {
            List<TransactedProducts> result = transaction.getTransactedProductsCollection().stream().collect(toList());
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public TransactionTable findById(Integer transactionId) {
        TransactionTable transaction = em.find(TransactionTable.class, transactionId);
        return transaction;
    }

    public TransactionTable createTransaction(java.sql.Date transactionDate, TransactionType type, UserTable user, java.sql.Date rentalReturnDate) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        TransactionTable transaction = new TransactionTable();
        transaction.setTransactionDate(transactionDate);
        if (rentalReturnDate != null) {
            transaction.setRentalReturnDate(rentalReturnDate);
        }
        
        transaction.setIdType(type);
        transaction.setIdCashier(user);

        em.persist(transaction);
        return transaction;
    }
    
    public void addProductsToTransaction(TransactionTable transaction, List<Product> products) {
        for (Product p : products) {
            addProductToTransaction(transaction, p);
        }
        
        calculateTotalValue(transaction, products);
    }

    private void addProductToTransaction(TransactionTable transaction, Product product) {
        TransactedProducts transactedProducts = new TransactedProducts();
        
        transactedProducts.setIdTransaction(transaction);
        transactedProducts.setIdProduct(product);
        
        em.persist(transactedProducts);
    }
    
    private void calculateTotalValue(TransactionTable transaction, List<Product> products){
        //TODO: This was made for testing purposes only, just a simple sum
        Double sum = products.stream().mapToDouble(x -> x.getPrice()).sum();
        
        if (!em.contains(transaction)) {
            transaction = em.merge(transaction);
        }
        
        if (transaction.getIdType().getType().equals("Return")) {
            sum = -sum;
        }
        
        transaction.setValue(sum);
    }

    public void removeProductFromTransaction(TransactionTable transaction, Product product) {
        try {
            Query query = em.createQuery("SELECT t FROM TransactedProducts t WHERE t.idProduct = :idProduct AND t.idTransaction = :idTransaction")
                    .setParameter("idTransaction", transaction)
                    .setParameter("idProduct", product);
            List<TransactedProducts> result = query.getResultList();
            for (TransactedProducts tp : result) {
                //TODO: Test it, it may here
                if (!em.contains(tp)) {
                    tp = em.merge(tp);
                }
                em.remove(tp);
            }
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void deleteTransaction(TransactionTable transaction) {
        if (!em.contains(transaction)) {
            transaction = em.merge(transaction);
        }
        em.remove(transaction);
    }
}
