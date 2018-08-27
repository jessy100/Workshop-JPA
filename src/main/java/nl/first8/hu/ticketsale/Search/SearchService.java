package nl.first8.hu.ticketsale.Search;

import nl.first8.hu.ticketsale.venue.Concert;
import nl.first8.hu.ticketsale.venue.Genre;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class SearchService {

    private final SearchRepository searchRepository;

    @Autowired
    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }


    public List<Concert> findConcertByLocation(String Location)
    {
        return searchRepository.findConcertByLocation(Location);
    }

    public List<Concert> findConcertByDate(Date date)
    {
        return searchRepository.findConcertByDate(date);
    }

    public List<Concert> findConcertByGenre(Genre genre)
    {
        return searchRepository.findConcertByGenre(genre);
    }

    public List<Concert> findConcertByArtist(String artistName)
    {
        return searchRepository.findConcertByArtist(artistName);
    }
}
