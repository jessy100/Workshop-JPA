package nl.first8.hu.ticketsale.sales;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

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

}
