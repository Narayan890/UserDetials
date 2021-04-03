package com.example.user.UserDetails.repository;

import com.example.user.UserDetails.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceUnit(unitName = "techblog")
    private EntityManagerFactory entityManagerFactory;


    public void registerUser(User newUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            entityManager.persist(newUser);
            transaction.commit();
        }
        catch(Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
    public List<User> getAllUser(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.createQuery(
                "SELECT c FROM User c WHERE c.fullName LIKE :custName")
                .setParameter("custName", name)
                .getResultList();

    }

}
