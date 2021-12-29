package com.pos.bean;

import com.pos.entity.Category;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CategoryBean {

    @PersistenceContext
    private EntityManager em;

    public List<Category> getAllCategories() {
        try {
            TypedQuery<Category> query = em.createNamedQuery("Category.findAll", Category.class);
            List<Category> categories = (List<Category>) query.getResultList();
            return categories;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public Category findById(Integer categoryId) {
        return em.find(Category.class, categoryId);
    }

    public Category findByName(String categoryName) {
        TypedQuery<Category> query = em.createNamedQuery("Category.findByCategory", Category.class);
        query.setParameter("category", categoryName);
        Category result = query.getSingleResult();

        return result;
    }

    public void createCategory(String categoryName) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        Category category = new Category();
        category.setCategory(categoryName);

        em.persist(category);
    }

    public void updateCategory(Category category, String newCategoryName) {
        if (!em.contains(category)) {
            category = em.merge(category);
        }
        category.setCategory(newCategoryName);
    }

    public void deleteCategoriesByIds(Category category) {
        if (!em.contains(category)) {
            category = em.merge(category);
        }
        em.remove(category);
    }
}
