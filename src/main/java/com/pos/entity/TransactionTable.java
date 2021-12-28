/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Tavi
 */
@Entity
@Table(name = "TRANSACTION_TABLE", catalog = "", schema = "DBA")
@NamedQueries({
    @NamedQuery(name = "TransactionTable.findAll", query = "SELECT t FROM TransactionTable t"),
    @NamedQuery(name = "TransactionTable.findById", query = "SELECT t FROM TransactionTable t WHERE t.id = :id"),
    @NamedQuery(name = "TransactionTable.findByTransactionDate", query = "SELECT t FROM TransactionTable t WHERE t.transactionDate = :transactionDate"),
    @NamedQuery(name = "TransactionTable.findByValue", query = "SELECT t FROM TransactionTable t WHERE t.value = :value"),
    @NamedQuery(name = "TransactionTable.findByRentalReturnDate", query = "SELECT t FROM TransactionTable t WHERE t.rentalReturnDate = :rentalReturnDate")})
public class TransactionTable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 52)
    private Double value;
    @Column(name = "RENTAL_RETURN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rentalReturnDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTransaction")
    private Collection<TransactedProducts> transactedProductsCollection;
    @JoinColumn(name = "ID_TYPE", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TransactionType idType;
    @JoinColumn(name = "ID_CASHIER", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private UserTable idCashier;

    public TransactionTable() {
    }

    public TransactionTable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getRentalReturnDate() {
        return rentalReturnDate;
    }

    public void setRentalReturnDate(Date rentalReturnDate) {
        this.rentalReturnDate = rentalReturnDate;
    }

    public Collection<TransactedProducts> getTransactedProductsCollection() {
        return transactedProductsCollection;
    }

    public void setTransactedProductsCollection(Collection<TransactedProducts> transactedProductsCollection) {
        this.transactedProductsCollection = transactedProductsCollection;
    }

    public TransactionType getIdType() {
        return idType;
    }

    public void setIdType(TransactionType idType) {
        this.idType = idType;
    }

    public UserTable getIdCashier() {
        return idCashier;
    }

    public void setIdCashier(UserTable idCashier) {
        this.idCashier = idCashier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionTable)) {
            return false;
        }
        TransactionTable other = (TransactionTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.entity.TransactionTable[ id=" + id + " ]";
    }
    
}
