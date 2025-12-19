package com.example.demo.Repository;

import com.example.demo.Entity.UserAccount;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Save a user
    public UserAccount save(UserAccount userAccount) {
        if (userAccount.getId() == null) {
            entityManager.persist(userAccount); // Insert if no ID exists
        } else {
            entityManager.merge(userAccount); // Update if ID exists
        }
        return userAccount;
    }

    // Find a user by ID
    public Optional<UserAccount> findById(Long id) {
        UserAccount userAccount = entityManager.find(UserAccount.class, id);
        return Optional.ofNullable(userAccount);
    }

    // Get all users
    public List<UserAccount> findAll() {
        return entityManager.createQuery("SELECT u FROM UserAccount u", UserAccount.class)
                .getResultList();
    }

    // Delete user by ID
    public void deleteById(Long id) {
        UserAccount userAccount = entityManager.find(UserAccount.class, id);
        if (userAccount != null) {
            entityManager.remove(userAccount);
        }
    }
}
