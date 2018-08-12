package nl.first8.hu.ticketsale.venue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Concert {

    @Id
    @GeneratedValue
    private Long id;
    private String artist;
    private String genre;

    @ManyToOne
    @JoinColumn(name="location_id", referencedColumnName = "id")
    private Location location;

}
