package com.onetwo.library_management.dao.impl;

import com.onetwo.library_management.dao.UserDao;
import com.onetwo.library_management.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsers() {
        Query query = em.createQuery("select a from user_t a");
        List<User> result = query.getResultList();
        return result;
    }

    @Override
    public User getUserById(String id) {
        Query query = em.createQuery("SELECT a FROM user_t a where a.id=:id");
        query.setParameter("id", id);
        System.out.println("*****id=" + id);
        User result = (User) query.getSingleResult();
        return result;
    }
}
