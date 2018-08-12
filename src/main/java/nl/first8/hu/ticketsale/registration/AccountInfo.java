package nl.first8.hu.ticketsale.registration;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class AccountInfo {


    @Id
    @GeneratedValue
    private Long id;

    private String street;

    private String telephoneNumber;

    public AccountInfo(Long id, String street, String telephoneNumber) {
        this.id = id;
        this.street = street;
        this.telephoneNumber = telephoneNumber;
    }

    public AccountInfo(String street, String telephoneNumber) {
        this.street = street;
        this.telephoneNumber = telephoneNumber;
    }

}
