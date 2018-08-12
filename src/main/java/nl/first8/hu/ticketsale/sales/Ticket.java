package nl.first8.hu.ticketsale.sales;

import lombok.*;
import nl.first8.hu.ticketsale.registration.Account;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket implements Serializable {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String artist;
    @Getter
    @Setter
    private String genre;
    @Getter
    @Setter
    private String location;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @Getter
    @Setter
    private Account account;

    public Ticket(String artist, String genre, String location) {
        this.artist = artist;
        this.genre = genre;
        this.location = location;
    }
}
