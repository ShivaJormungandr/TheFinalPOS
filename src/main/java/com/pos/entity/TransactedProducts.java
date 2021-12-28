/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Tavi
 */
@Entity
@Table(name = "TRANSACTED_PRODUCTS", catalog = "", schema = "DBA")
@NamedQueries({
    @NamedQuery(name = "TransactedProducts.findAll", query = "SELECT t FROM TransactedProducts t"),
    @NamedQuery(name = "TransactedProducts.findById", query = "SELECT t FROM TransactedProducts t WHERE t.id = :id")})
public class TransactedProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Product idProduct;
    @JoinColumn(name = "ID_TRANSACTION", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private TransactionTable idTransaction;

    public TransactedProducts() {
    }

    public TransactedProducts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public TransactionTable getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(TransactionTable idTransaction) {
        this.idTransaction = idTransaction;
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
        if (!(object instanceof TransactedProducts)) {
            return false;
        }
        TransactedProducts other = (TransactedProducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pos.entity.TransactedProducts[ id=" + id + " ]";
    }
    
}
