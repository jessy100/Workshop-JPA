package nl.first8.hu.ticketsale.registration;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {


    @Id
    @GeneratedValue
    @Getter
    @Setter
    private long Id;

    @Getter
    @Setter
    private String emailAddress;

    public Account(String mail)
    {
        this.emailAddress = mail;
    }


}
