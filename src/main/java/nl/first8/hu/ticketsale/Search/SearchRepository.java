package nl.first8.hu.ticketsale.Search;
import nl.first8.hu.ticketsale.venue.Concert;
import nl.first8.hu.ticketsale.venue.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class SearchRepository {

    private final EntityManager entityManager;

    @Autowired
    public SearchRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Concert> findConcertByLocation(String Location)
    {
            TypedQuery<Concert> query = entityManager.createQuery("SELECT concert FROM Concert concert WHERE concert.location.name = :location ", Concert.class);
            query.setParameter("location", Location);
            return query.getResultList();
    }

    public List<Concert> findConcertByDate(Date date)
    {
        TypedQuery<Concert> query = entityManager.createQuery("SELECT concert FROM Concert concert WHERE concert.date = :date ", Concert.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    public List<Concert> findConcertByGenre(Genre genre)
    {
        TypedQuery<Concert> query = entityManager.createQuery("SELECT concert FROM Concert concert WHERE concert.artist.genre = :genre ", Concert.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    public List<Concert> findConcertByArtist(String artistName){
        TypedQuery<Concert> query = entityManager.createQuery("SELECT concert FROM Concert concert WHERE concert.artist.name = :artist_name ", Concert.class);
        query.setParameter("artist_name", artistName);
        return query.getResultList();
    }
}
