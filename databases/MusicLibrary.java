package databases;

import CSVParser.CSVReader;
import CSVParser.CSVWriter;
import release.Album;
import release.Release;
import release.Song;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Class to keep track of all the databases and the libraries.
 * @author Trey Pachucki ttp2542@rit.edu
 */
public class MusicLibrary {
    //Where to get database information
    private final String songDatabaseFile = "./CSVFiles/songs.csv";
    private final String albumDatabaseFile = "./CSVFiles/releases.csv";
    private final String artistDatabaseFile = "./CSVFiles/artists.csv";

    //Where to write the library to
    private final String songLibraryFile = "./CSVFiles/songLibrary.csv";
    private final String artistLibraryFile = "./CSVFiles/artistLibrary.csv";
    private final String albumLibraryFile = "./CSVFiles/releaseLibrary.csv";

    //The release databases
    private Database artistDatabase;
    private Database albumDatabase;
    private Database songDatabase;

    //The release databases
    private Database songLibrary;
    private Database albumLibrary;
    private Database artistLibrary;

    /**
     * Constructor, makes all the libraries and databases
     */
    public MusicLibrary(){
        this.artistDatabase = new Database(CSVReader.readArtists(artistDatabaseFile, false));
        this.songDatabase = new Database(CSVReader.readSongs(songDatabaseFile, artistDatabase.getDatabase(), false));
        this.albumDatabase = new Database(CSVReader.readAlbums(albumDatabaseFile, songDatabase.getDatabase(),
                artistDatabase.getDatabase(), false));

        this.artistLibrary = new Database(CSVReader.readArtists(artistLibraryFile, true));
        this.songLibrary = new Database(CSVReader.readSongs(songLibraryFile, artistLibrary.getDatabase(), true));
        this.albumLibrary = new Database(CSVReader.readAlbums(albumLibraryFile, songLibrary.getDatabase(),
                artistLibrary.getDatabase(), true));
    }

    /**
     * Adds a song to the library
     * @param GUID: Songs GUID
     * @return Whether or not it worked
     */
    public boolean addSong(String GUID){
        Release song = this.songDatabase.getRelease(GUID);
        if(song != null) {
            this.songLibrary.addRelease(song);
            Release artist = song.getArtist();
            this.artistLibrary.addRelease(artist);
            return true;
        }
        return false;
    }

    /**
     * Adds an album to the database
     * @param GUID: Albums GUID
     * @return Whether or not it worked
     */
    public boolean addAlbum(String GUID){
        Release album = this.albumDatabase.getRelease(GUID);
        if(album != null) {
            this.albumLibrary.addRelease(album);
            Release artist = album.getArtist();
            this.artistLibrary.addRelease(artist);
            for(Release r:album.getTrackList()){
                addSong(r.getGUID());
            }
            return true;
        }
        return false;
    }

    /**
     * Adds an artist to the database
     * @param GUID: The artist GUID
     * @return Whether or not it worked.
     */
    public boolean addArtist(String GUID){
        Release artist = this.artistDatabase.getRelease(GUID);
        if(artist != null){
            this.artistLibrary.addRelease(artist);
            return true;
        }
        return false;
    }

    /**
     * Function to remove albums (and there respective songs) from the library.
     * @param GUID: THe GUID of the album
     * @return Whether or not it was successful
     */
    public boolean removeAlbum(String GUID){
        Release album = this.albumLibrary.getRelease(GUID);
        if(album != null){
            this.albumLibrary.removeRelease(GUID);
            for(Release r :album.getTrackList()){
                removeSong(r.getGUID());
            }
            return true;
        }
        return false;
    }
    /**
     * Removes a song from the songLibrary (and the artist if theres
     * no songs by that artist in the library)
     * @param GUID: The GUID of the song to be removed.
     * @return Whether or not it worked
     */
    public boolean removeSong(String GUID){
        Release song = this.songLibrary.getRelease(GUID);
        if(song != null){
            this.songLibrary.removeRelease(GUID);
            String artistGUID = song.getArtist().getGUID();
            if(!this.songLibrary.hasArtist(artistGUID)){
                artistLibrary.removeRelease(artistGUID);
            }
            return true;
        }
        return false;
    }

    /**
     * Searches the artist database for an artist
     * @param query: The name of the artist
     * @return List of possible artists
     */
    public ArrayList<Release> searchArtistDatabase(String query){
        return artistDatabase.searchName(query);
    }

    /**
     * Searches the song database for a song
     * @param query: The name of the song
     * @return List of possible songs
     */
    public ArrayList<Release> searchSongDatabase(String query, String type){
        if(type.equals("title")) {
            return songDatabase.searchName(query);
        }else if(type.equals("artist")) {
            return songDatabase.searchByArtist(query);
        }else if (type.equals("releaseTitle")) {
            return songDatabase.searchByRelease(query);
        }else if(type.equals("durationLess")){
            return songDatabase.searchDurationLess(query);
        }else if(type.equals("durationMore")){
            return songDatabase.searchDurationMore(query);
        }
        return new ArrayList<Release>();
    }

    /**
     * Searches the song database for a song
     * @param query: The name of the song
     * @return List of possible songs
     */
    public ArrayList<Release> searchAlbumDatabase(String query, String type){
        if(type.equals("releaseTitle")) {
            return albumDatabase.searchName(query);
        }else if(type.equals("artist")){
            return albumDatabase.searchByArtist(query);
        }else if(type.equals("song")){
            return albumDatabase.searchBySong(query);
        }else if(type.equals("durationLess")){
            return songDatabase.searchDurationLess(query);
        }else if(type.equals("durationMore")){
            return songDatabase.searchDurationMore(query);
        }

        return new ArrayList<Release>();
    }

    /**
     * Searches the artist library for an artist
     * @param query: The name of the artist
     * @return List of possible artists
     */
    public ArrayList<Release> searchArtistLibrary(String query, String type){
        if(type.equals("title")){
            return artistLibrary.searchName(query);
        }else if(type.equals("rating")){
            return artistLibrary.searchByRating(query);
        }

        return new ArrayList<Release>();
    }

    /**
     * Searches the song library for a song by a specific type
     * @param query: The name of the song
     * @return List of possible songs
     */
    public ArrayList<Release> searchSongLibrary(String query, String type){
        if(type.equals("title")){
            return songLibrary.searchName(query);
        }else if(type.equals("artist")){
            return songLibrary.searchByArtist(query);
        }else if(type.equals("release")){
            return albumLibrary.searchByRelease(query);
        }else if(type.equals("durationLess")){
            return songLibrary.searchDurationLess(query);
        }else if(type.equals("durationMore")){
            return songLibrary.searchDurationMore(query);
        }else if(type.equals("rating")){
            return songLibrary.searchByRating(query);
        }

        return new ArrayList<Release>();
    }

    /**
     * Searches the album library for an album
     * @param query: The name of the album
     * @return List of possible albums
     */
    public ArrayList<Release> searchAlbumLibrary(String query, String type){
        if(type.equals("title")) {
            return albumLibrary.searchName(query);
        }else if(type.equals("artist")){
            return albumLibrary.searchByArtist(query);
        }else if(type.equals("song")){
            return albumLibrary.searchBySong(query);
        }else if(type.equals("date")){
            return albumLibrary.searchByDate(query);
        }else if(type.equals("durationLess")){
            return albumLibrary.searchDurationLess(query);
        }else if(type.equals("durationMore")){
            return albumLibrary.searchDurationMore(query);
        }else if(type.equals("rating")) {
            return albumLibrary.searchByRating(query);
        }

        return new ArrayList<Release>();
    }

    /**
     * Saves the libraries before closing the application
     * @return whether or not the library was successfully closed
     */
    public boolean closeLibrary(){
        CSVWriter.writeSongs(songLibrary, songLibraryFile);
        CSVWriter.writeArtists(artistLibrary, artistLibraryFile);
        CSVWriter.writeAlbums(albumLibrary, albumLibraryFile);
        return true;
    }

    /**
     * Function to set the rating for an album, artist, or song.
     * @param GUID: The GUID of the Release
     * @param rating: The new rating for the release
     * @return Whether or not it was successful
     */
    public boolean setRating(String GUID, int rating){
        Release song = songLibrary.getRelease(GUID);
        if(song != null) {
            song.setRating(rating);
            return true;
        }

        Release album = albumLibrary.getRelease(GUID);
        if(album != null){
            album.setRating(rating);
            return true;
        }

        Release artist = artistLibrary.getRelease(GUID);
        if(artist != null){
            artist.setRating(rating);
            return true;
        }

        return false;
    }

    /**
     * Function to set the acquisition date for either song or album
     * @param GUID: The GUID of the release
     * @param date: The date acquired
     * @return whether or not this worked.
     */
    public boolean setAcquisitionDate(String GUID, String date){
        Release song = songLibrary.getRelease(GUID);
        if(song != null){
            song.setAcquisitionDate(date);
            return true;
        }

        Release album = albumLibrary.getRelease(GUID);
        if(album != null){
            album.setAcquisitionDate(date);
            return true;
        }

        return false;
    }

    /**
     * Main function. Meant to run the application (currently tests)
     * @param args: nothing
     */
    public static void main(String[] args){
        MusicLibrary musicLibrary = new MusicLibrary();
        musicLibrary.addSong("6e33056b-2a34-4ed0-b49c-f7a8ae2c5bcc");
        musicLibrary.addSong("f5132c2a-203e-454a-9518-e994e40daf3a");
        musicLibrary.closeLibrary();
    }
}
