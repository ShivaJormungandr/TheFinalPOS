package com.pos.bean;

import com.pos.entity.Category;
import com.pos.entity.Product;
import com.pos.entity.Unit;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class ProductBean {

    @PersistenceContext
    private EntityManager em;

    public List<Product> getAllProducts() {
        try {
            TypedQuery<Product> query = em.createNamedQuery("Product.findAll", Product.class);
            List<Product> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public List<Product> getAllProductsByCategory(Category category) {
        try {
            Query query = em.createQuery("SELECT p FROM Product p WHERE p.idCategory = :categoryId")
            .setParameter("categoryId", category);
            List<Product> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    public Product findById(Integer productId) {
        Product product = em.find(Product.class, productId);
        return product;
    }

    public Product findByName(String productName) {
        TypedQuery<Product> query = em.createNamedQuery("Product.findByProductName", Product.class);
        query.setParameter("productName", productName);
        Product result = query.getSingleResult();

        return result;
    }

    public void createProduct(String productName, Category category, Double price, Unit unit, String imgPath) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        Product product = new Product();
        product.setProductName(productName);
        product.setIdCategory(category);
        product.setPrice(price);
        product.setIdUnit(unit);
        product.setImgPath(imgPath);

        em.persist(product);
    }

    public void updateProduct(Product product, String newProductName, Category newCategory, Double newPrice, Unit newUnit, String newImgPath) {
        if (!em.contains(product)) {
            product = em.merge(product);
        }
        if (newProductName != null) {
            product.setProductName(newProductName);
        }
        if (newCategory != null) {
            product.setIdCategory(newCategory);
        }
        if (newPrice != null) {
            product.setPrice(newPrice);
        }
        if (newUnit != null) {
            product.setIdUnit(newUnit);
        }
        if (newImgPath != null) {
            product.setImgPath(newImgPath);
        }
    }

    public void deleteProductsByIds(Product product) {
        if (!em.contains(product)) {
            product = em.merge(product);
        }
        em.remove(product);
    }
}
