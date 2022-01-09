package com.pos.bean;


import com.pos.entity.State;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class StateBean {

    @PersistenceContext
    private EntityManager entityManager;

    public List<State> getAllStates() {
        try {
            TypedQuery<State> query = entityManager.createNamedQuery("State.findAll", State.class);
            List<State> result = (List<State>) query.getResultList();
            return result;
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    public State findById(Integer stateId) {
        return entityManager.find(State.class, stateId);
    }

    public State findByName(String stateName) {
        TypedQuery<State> query = entityManager.createNamedQuery("State.findByState", State.class);
        query.setParameter("state", stateName);
        State result = query.getSingleResult();

        return result;
    }

    public void createState(String stateName) {
        System.getProperties().setProperty("derby.language.sequence.preallocator", String.valueOf(1));

        State state = new State();
        state.setState(stateName);

        entityManager.persist(state);
    }

    public void updateState(State state, String newStateName) {
        if (!entityManager.contains(state)) {
            state = entityManager.merge(state);
        }
        state.setState(newStateName);
    }

    public void deleteState(State state) {
        if (!entityManager.contains(state)) {
            state = entityManager.merge(state);
        }
        entityManager.remove(state);
    }
}
