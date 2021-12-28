package com.pos.bean;

import com.pos.entity.*;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserBean {

    @PersistenceContext
    private EntityManager em;

    public void CreateUser(String username, String password, String role, String email) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        UserTable user = new UserTable();

        user.setUsername(username);
        user.setPassword(password);
        System.out.println(role);
        user.setIdRole(getRoleByName(role));
        user.setIdState(getPendingState());
        user.setEmail(email);

        em.persist(user);
    }

    private State getPendingState() {
        Query query = em.createQuery("SELECT s FROM State s WHERE s.state = :state").setParameter("state", "Pending").setMaxResults(1);
        State state = (State) query.getSingleResult();

        return state;
    }

    private Role getRoleByName(String role) {
        Query query = em.createQuery("SELECT r FROM Role r WHERE r.role = :role").setParameter("role", role).setMaxResults(1);
        Role r = (Role) query.getSingleResult();

        return r;
    }

    public List<UserTable> getAllUsers() {
        try {
            Query query = em.createQuery("SELECT u FROM UserTable u");
            List<UserTable> users = (List<UserTable>) query.getResultList();
            return users;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public void getAllRoles() {
        try {
            Query query = em.createQuery("SELECT u FROM Role u");
            List<Role> roles = (List<Role>) query.getResultList();
            System.out.println(roles);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public String getPasswordByUsername(String username) {
        Query query = em.createQuery("SELECT u FROM UserTableEntity u WHERE u.username = :username").setParameter("username", username).setMaxResults(1);
        UserTable user = (UserTable) query.getSingleResult();

        return user.getPassword();
    }

}
