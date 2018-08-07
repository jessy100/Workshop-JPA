package nl.first8.hu.ticketsale.registration;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data                   //Generates getters and setters
@NoArgsConstructor      //Generates an empty constructor
@AllArgsConstructor     //Generates a constructor containing all fields
public class Account {

    /*
     * TODO: implement Account entity.
     *
     * (hint: look at the Flyway SQL file in /resources/db/migration)
     */


    @Getter
    @Setter
    @Id
    public String EmailAddress;



}
