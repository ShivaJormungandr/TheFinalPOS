/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.pos.bean;

import com.pos.entity.Role;
import java.util.Collection;
import java.util.List;
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
public class RoleBean {

    @PersistenceContext
    private EntityManager em;

    public List<Role> getAllRoles() {
        try {
            TypedQuery<Role> query = em.createNamedQuery("Role.findAll", Role.class);
            List<Role> result = query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public Role findById(Integer id) {
        Role result = em.find(Role.class, id);

        return result;
    }

    public Role findByName(String role) {
        TypedQuery<Role> query = em.createNamedQuery("Role.findByRole", Role.class);
        query.setParameter("role", role);
        Role result = query.getSingleResult();

        return result;
    }

    public void createRole(String roleName) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        Role role = new Role();

        role.setRole(roleName);

        em.persist(role);

    }

    public void updateRole(Role role, String newRoleName) {
        if (!em.contains(role)) {
            role = em.merge(role);
        }
        role.setRole(newRoleName);
    }

    public void deleteRole(Role role) {
        if (!em.contains(role)) {
            role = em.merge(role);
        }
        em.remove(role);
    }
    
    //THIS IS FOR EXAMPLE PURPOSES ONLY
    public List<Role> exampleForQuerry(String exampleP, String exampleP2) {
        Query query = em.createQuery("SELECT x FROM Role x WHERE x.exampleP = :exampleP AND x.exampleP = :exampleP")
                .setParameter("exampleP", exampleP)
                .setParameter("exampleP2", exampleP2)
                .setMaxResults(1);
        List<Role> results = (List<Role>) query.getResultList();
        return results;
    }
}
