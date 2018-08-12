package nl.first8.hu.ticketsale.venue;

import lombok.*;
import nl.first8.hu.ticketsale.registration.Account;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    @Column(name = "location_name")
    private String name;



}
