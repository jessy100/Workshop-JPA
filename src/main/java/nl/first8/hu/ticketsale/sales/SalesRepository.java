package nl.first8.hu.ticketsale.sales;

import nl.first8.hu.ticketsale.registration.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class SalesRepository {

    private final EntityManager entityManager;

    @Autowired
    public SalesRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Persists the given <code>account</code> in the underlying data source.
     *
     * @param ticket the account to persist
     *
     * @throws EntityExistsException if the entity already exists
     */
    public void insert(final Ticket ticket) {
        entityManager.persist(ticket);
    }


    public List<Ticket> findByAccount(Account account) {
            return entityManager.createQuery("SELECT t FROM Ticket t,Account a WHERE a.id =:accountId", Ticket.class)
                    .setParameter("accountId", account.getId())
                    .getResultList();
    }
}
