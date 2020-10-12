package Command;

import databases.MusicLibrary;

/**
 * Concrete Command that handles functionality of adding releases to library
 * @author Daniel Cho dc9865@rit.edu
 */
public class AddReleaseQuery implements Query {
    private MusicLibrary app;
    String guid;

    /**
     * Constructor query to add release to library
     * @param app: The receiver class, Music Library
     * @param guid: The GUID of release/album
     */
    public AddReleaseQuery(MusicLibrary app, String guid) {
        this.app = app;
        this.guid = guid;
    }

    /**
     * Call function from MusicLibrary class to add album to library
     */
    @Override
    public void execute() {
        app.addAlbum(guid);
    }
}
