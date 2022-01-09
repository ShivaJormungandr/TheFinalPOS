package com.pos.bean;

import com.pos.entity.Role;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class RoleBean {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Role> getAllRoles() {
        try {
            TypedQuery<Role> query = entityManager.createNamedQuery("Role.findAll", Role.class);
            List<Role> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public Role findById(Integer id) {
        Role result = entityManager.find(Role.class, id);

        return result;
    }

    public Role findByName(String role) {
        TypedQuery<Role> query = entityManager.createNamedQuery("Role.findByRole", Role.class);
        query.setParameter("role", role);
        Role result = query.getSingleResult();

        return result;
    }

    public void createRole(String roleName) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        Role role = new Role();
        role.setRole(roleName);

        entityManager.persist(role);

    }

    public void updateRole(Role role, String newRoleName) {
        if (!entityManager.contains(role)) {
            role = entityManager.merge(role);
        }
        role.setRole(newRoleName);
    }

    public void deleteRole(Role role) {
        if (!entityManager.contains(role)) {
            role = entityManager.merge(role);
        }
        entityManager.remove(role);
    }

}
