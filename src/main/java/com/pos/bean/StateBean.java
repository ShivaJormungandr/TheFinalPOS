/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.pos.bean;


import com.pos.entity.State;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Tavi
 */
@Stateless
public class StateBean {

    @PersistenceContext
    private EntityManager em;

    public List<State> getAllStates() {
        try {
            TypedQuery<State> query = em.createNamedQuery("State.findAll", State.class);
            List<State> result = (List<State>) query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public State findById(Integer stateId) {
        return em.find(State.class, stateId);
    }

    public State findByName(String stateName) {
        TypedQuery<State> query = em.createNamedQuery("State.findByState", State.class);
        query.setParameter("state", stateName);
        State result = query.getSingleResult();

        return result;
    }

    public void createState(String stateName) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        State state = new State();
        state.setState(stateName);

        em.persist(state);
    }

    public void updateState(State state, String newStateName) {
        if (!em.contains(state)) {
            state = em.merge(state);
        }
        state.setState(newStateName);
    }

    public void deleteState(State state) {
        if (!em.contains(state)) {
            state = em.merge(state);
        }
        em.remove(state);
    }
}
