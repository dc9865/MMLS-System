package Command;

import databases.MusicLibrary;

/**
 * Concrete Command that handles functionality of adding songs to library
 * @author Daniel Cho dc9865@rit.edu
 */
public class AddSongQuery implements Query {
    private MusicLibrary app;
    String guid;

    /**
     * Constructor query to add song to library
     * @param app: The receiver class, Music Library
     * @param guid: The GUID of song
     */
    public AddSongQuery(MusicLibrary app, String guid) {
        this.app = app;
        this.guid = guid;
    }

    /**
     * Call function from MusicLibrary class to add song to library
     */
    @Override
    public void execute() {
        app.addSong(guid);
    }
}