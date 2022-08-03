package com.sonali.springboot.demo.myapp.rest.dao;

import com.sonali.springboot.demo.myapp.rest.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImplementation implements UserDAO{

    private EntityManager entityManager;

    @Autowired
    public UserDAOImplementation(EntityManager theEntityManager)
    {
        entityManager = theEntityManager;
    }
    @Override
    public List<User> getAllUser() {

        Session cs=entityManager.unwrap(Session.class);
        Query<User> theQuery= cs.createQuery("from User", User.class);
        List<User>  users= theQuery.getResultList();
        return users;
    }

    @Override
    public User findById(int id) {
        Session cs= entityManager.unwrap(Session.class);
        User theUser= cs.get(User.class, id);
        return theUser;
    }

    @Override
    public void save(User user) {
        Session cs=entityManager.unwrap(Session.class);
                cs.saveOrUpdate(user);
    }

    @Override
    public void deleteById(int id) {
        Session cs=entityManager.unwrap(Session.class);
        Query theQuery= cs.createQuery("delete from User where id=:userID");
        theQuery.setParameter("userID", id);
        theQuery.executeUpdate();
    }
}
