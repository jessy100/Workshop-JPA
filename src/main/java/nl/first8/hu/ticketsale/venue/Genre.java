package nl.first8.hu.ticketsale.venue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum Genre {
    @JsonProperty("HIPHOP")
    HIPHOP,
    @JsonProperty("GRINDCORE")
    GRINDCORE,
    @JsonProperty("METALCORE")
    METALCORE,
    @JsonProperty("HOUSE")
    HOUSE;

}
