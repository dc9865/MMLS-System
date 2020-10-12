package Command;

import databases.MusicLibrary;

/**
 * Command to rate songs in the library
 * @author Trey Pachucki ttp2542@rit.edu
 */
public class RateQuery implements Query {
    private MusicLibrary app;
    String guid;
    private int rating;

    /**
     * Constructor query to rateSong in library
     * @param app: The receiver class, Music Library
     * @param guid: The GUID of release/album
     */
    public RateQuery(MusicLibrary app, String guid, int rating) {
        this.app = app;
        this.guid = guid;
        this.rating = rating;
    }

    /**
     * Call function from MusicLibrary class to rate a song in the library
     */
    @Override
    public void execute() {
        app.setRating(guid, rating);
    }
}
