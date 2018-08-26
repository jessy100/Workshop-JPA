package nl.first8.hu.ticketsale.sales;

import lombok.Data;
import nl.first8.hu.ticketsale.registration.Account;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Audittrail implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name="sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    public Audittrail(Account account, Sale sale)
    {
        this.sale = sale;
        this.account = account;
    }

}
