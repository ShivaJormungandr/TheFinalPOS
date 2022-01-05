package com.pos.bean;

import com.pos.entity.*;
import com.pos.utility.Password;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class UserBean {

    @PersistenceContext
    private EntityManager em;

    public void CreateUser(String username, String password, String fullName, String role, String email) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        UserTable user = new UserTable();

        user.setUsername(username);

        String hashPassword = Password.convertToSha256(password);
        user.setPassword(hashPassword);

        user.setFullname(fullName);
        user.setIdRole(getRoleByName(role));
        if(role.equals("Cashier")){
            user.setIdState(getStateByName("Pending"));
        }
        else{
            user.setIdState(getStateByName("Accepted"));
        }
        user.setEmail(email);

        em.persist(user);
    }

    public void updateUser(UserTable user, String newUsername, String newPassword, String newFullName, String newRole, String newEmail, String newState) {
        if (!em.contains(user)) {
            user = em.merge(user);
        }
        if (newUsername != null) {
            user.setUsername(newUsername);
        }
        if (newPassword != null) {
            user.setPassword(newPassword);
        }
        if (newFullName != null) {
            user.setFullname(newFullName);
        }
        if (newRole != null) {
            user.setIdRole(getRoleByName(newRole));
        }
        if (newEmail != null) {
            user.setEmail(newEmail);
        }
        if (newState != null) {
            user.setIdState(getStateByName(newState));
        }
    }

    public void deleteUsersByIds(UserTable user) {
        if (!em.contains(user)) {
            user = em.merge(user);
        }
        em.remove(user);
    }

    private Role getRoleByName(String role) {
        Query query = em.createQuery("SELECT r FROM Role r WHERE r.role = :role").setParameter("role", role).setMaxResults(1);
        Role r = (Role) query.getSingleResult();

        return r;
    }

    private State getStateByName(String state) {
        Query query = em.createQuery("SELECT s FROM State s WHERE s.state = :state").setParameter("state", state).setMaxResults(1);
        State s = (State) query.getSingleResult();

        return s;
    }

    public List<UserTable> getAllUsers() {
        try {
            TypedQuery<UserTable> query = em.createNamedQuery("UserTable.findAll", UserTable.class);
            List<UserTable> users = query.getResultList();
            return users;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public UserTable getByUsername(String username) {
        TypedQuery<UserTable> query = em.createNamedQuery("UserTable.findByUsername", UserTable.class);
        query.setParameter("username", username);
        UserTable result = query.getSingleResult();

        return result;
    }

    public UserTable getById(int id) {
        TypedQuery<UserTable> query = em.createNamedQuery("UserTable.findById", UserTable.class);
        query.setParameter("id", id);
        UserTable result = query.getSingleResult();

        return result;
    }

    public String getPasswordByUsername(String username) {
        Query query = em.createQuery("SELECT u FROM UserTableEntity u WHERE u.username = :username").setParameter("username", username).setMaxResults(1);
        UserTable user = (UserTable) query.getSingleResult();

        return user.getPassword();
    }

}
