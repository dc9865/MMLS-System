package Command;

import databases.MusicLibrary;

/**
 * Concrete Command that handles functionality of removing songs from library
 * @author Daniel Cho dc9865@rit.edu
 */
public class RemoveSongQuery implements Query {
    private MusicLibrary app;
    private String guid;

    /**
     * Constructor query to remove song from library
     * @param app: The receiver class, Music Library
     * @param guid: The GUID of song query that contains all corresponding information to remove song
     */
    public RemoveSongQuery(MusicLibrary app, String guid) {
        this.app = app;
        this.guid = guid;
    }

    /**
     * Call function from MusicLibrary class to remove song from library
     */
    @Override
    public void execute() {
        app.removeSong(guid);
    }
}