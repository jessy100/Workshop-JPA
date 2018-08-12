package nl.first8.hu.ticketsale.registration;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepository {

    private final EntityManager entityManager;

    @Autowired
    public RegistrationRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Persists the given <code>account</code> in the underlying data source.
     *
     * @param account the account to persist
     *
     * @throws EntityExistsException if the entity already exists
     */
    public void insert(final Account account) {
        entityManager.persist(account);
    }

    /**
     * Updates the account with the <code>id</code> that matches the
     * <code>id</code> of the given <code>account</code>
     *
     * @param account the updates field(s) of the account
     * @return a <i>new</i> Account instances, containing the latest view of
     * this Account entity.
     *
     * @throws IllegalArgumentException if the given <code>account</code> is not
     * already an attached entity
     */
    Account update(Account account) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Optionally returns the Account identified by the given <code>id</code>
     *
     * @param id the id of the Account to find
     * @return Returns the Account identified by the given <code>id</code> or an
     * {@link Optional#empty() empty} Optional if no Account could be identified
     * with the given <code>id</code>.
     */
    public Optional<Account> findById(final Object id) { //TODO: implement the proper data type!
        return Optional.ofNullable(entityManager.find(Account.class, id));
    }

    /**
     * Optionally returns the Account identified by the given <code>id</code>
     *
     * @param emailAddress the email address of the Account to find
     * @return Returns the Account identified by the given
     * <code>emailAddress</code> or an     * {@link Optional#empty() empty} Optional if no Account could be identified
     * with the given
     * <code>emailAddress</code>.
     */
    Optional<Account> findByEmailAddress(String emailAddress) {
        try{
            Account a = entityManager.createQuery("SELEcT a from Account a where email_address = '"+ emailAddress+"'", Account.class).getSingleResult();
            return Optional.of(a);
        }catch (Exception e){
            return Optional.empty();
        }

    }

    /**
     * Returns a list of all {@link Account}s in the underlying data source
     *
     * @return a list of all known {@link Account}s or an empty list if no
     * {@link Account}s exist in the underlying data source
     */
    public List<Account> findAll() {
        return entityManager.createQuery("SELECT a FROM Account a", Account.class).getResultList();
    }



}
