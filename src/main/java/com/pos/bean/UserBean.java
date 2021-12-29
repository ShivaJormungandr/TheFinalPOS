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
        user.setIdState(getPendingState());
        user.setEmail(email);

        em.persist(user);
    }
    
    public void updateUser(UserTable user, String newUsername, String newPassword, String newFullName, String newRole, String newEmail) {
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
    }
    
    public void deleteUsersByIds(UserTable user) {
        if (!em.contains(user)) {
            user = em.merge(user);
        }
        em.remove(user);
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
            TypedQuery<UserTable> query = em.createNamedQuery("UserTable.findAll", UserTable.class);
            List<UserTable> users = query.getResultList();
            return users;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    public UserTable findByUsername(String username) {
        TypedQuery<UserTable> query = em.createNamedQuery("UserTable.findByUsername", UserTable.class);
        query.setParameter("username", username);
        UserTable result = query.getSingleResult();

        return result;
    }

    public String getPasswordByUsername(String username) {
        Query query = em.createQuery("SELECT u FROM UserTableEntity u WHERE u.username = :username").setParameter("username", username).setMaxResults(1);
        UserTable user = (UserTable) query.getSingleResult();

        return user.getPassword();
    }

}
