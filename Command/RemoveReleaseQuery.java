package Command;

import databases.MusicLibrary;

/**
 * Concrete Command that handles functionality of removing releases from library
 * @author Daniel Cho dc9865@rit.edu
 */
public class RemoveReleaseQuery implements Query {
    private MusicLibrary app;
    String guid;

    /**
     * Constructor query to remove release from library
     * @param app: The receiver class, Music Library
     * @param guid: The GUID of release/album
     */
    public RemoveReleaseQuery(MusicLibrary app, String guid) {
        this.app = app;
        this.guid = guid;
    }

    /**
     * Call function from MusicLibrary class to remove release from library
     */
    @Override
    public void execute() {
        app.removeAlbum(guid);
    }
}