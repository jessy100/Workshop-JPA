package nl.first8.hu.ticketsale.venue;

public class GenreFactory {

    public static Genre ConvertStringToGenre(String genreValue)
    {
        switch (genreValue.toUpperCase())
        {
            case "HIPOP":
                return Genre.HIPHOP;
            case "GRINDCORE":
                return Genre.GRINDCORE;
            case "METALCORE":
                return Genre.METALCORE;
            case "HOUSE":
                return Genre.HOUSE;
            default:
                return Genre.GRINDCORE;
        }
    }
}
