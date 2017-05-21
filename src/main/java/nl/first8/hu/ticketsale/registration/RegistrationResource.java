package nl.first8.hu.ticketsale.registration;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@Transactional
public class RegistrationResource {

    private final RegistrationService service;

    @Autowired
    public RegistrationResource(RegistrationService service) {
        this.service = service;
    }

    @PostMapping(path = "/{emailAddress:.+}")
    public ResponseEntity<Long> post(@PathVariable("emailAddress") final String emailAddress) {
        try {
            service.insert(new Account(emailAddress));

            Optional<Account> account = service.getByEmailAddress(emailAddress);
            return account
                    .map(Account::getId)
                    .map(id -> ResponseEntity.ok(id))
                    .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());

        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PutMapping(path = "/{id}/{emailAddress:.+}")
    public ResponseEntity<Account> put(@PathVariable("id") final Long id, @PathVariable("emailAddress") final String emailAddress) {
        try {
            final Account updatedAccount = service.update(new Account(id, emailAddress));

            return ResponseEntity.ok(updatedAccount);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<Account> getById(@PathVariable("id") final Long id) {
        Optional<Account> account = service.getById(id);

        return account
                .map(acc -> ResponseEntity.ok(acc))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(path = "/email_address/{emailAddress:.+}")
    public ResponseEntity<Account> getByEmailAddress(@PathVariable("emailAddress") final String emailAddress) {
        Optional<Account> account = service.getByEmailAddress(emailAddress);

        return account
                .map(acc -> ResponseEntity.ok(acc))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping
    public List<Account> getAll() {
        return service.list();
    }
}
