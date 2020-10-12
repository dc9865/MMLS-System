package CSVParser;

import databases.Database;
import release.Artist;
import release.Release;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class to write to the CSV files (mostly library files)
 * @author Trey Pachucki ttp2542@rit.edu
 */
public class CSVWriter {

    /**
     * Function to save the songs in the library to a temp file
     * @param songLibrary: The library of songs (database)
     * @param filename: The filepath to the 'song library' temp file
     */
    public static void writeSongs(Database songLibrary, String filename){
        File file = new File(filename);
        try{
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter fr = new FileWriter(file);
            for(String key: songLibrary.getKeys()){
                Release song = songLibrary.getRelease(key);
                String GUID = song.getGUID();
                String artist = song.getArtist().getGUID();
                long duration = song.getDuration();
                String title = song.getTitle();
                int rating = song.getRating();
                if(title.contains(",")){
                    title = '"' + title + '"';
                }
                fr.write(GUID +  "," + artist + "," + duration + "," + title + "," + rating + '\n');
            }
            fr.close();
        }catch(IOException io){
            System.out.println(io.getMessage());
        }

    }

    /**
     * Writes the library of artists to a temporary file for storage.
     * @param artistLibrary: The library of artists
     * @param filename: The path to the storage file.
     */
    public static void writeArtists(Database artistLibrary, String filename){
        File file = new File(filename);
        try{
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter fr = new FileWriter(file);
            for(String key: artistLibrary.getKeys()){
                Release artist = artistLibrary.getRelease(key);
                Artist musician = (Artist)artist;
                String GUID = artist.getGUID();
                String name = artist.getTitle();
                String disambiguation = musician.getArtistType();
                int rating = artist.getRating();
                fr.write(GUID + "," + name + "," + disambiguation + "," + rating + '\n');
            }
            fr.close();
        }catch(IOException io){
            System.out.println(io.getMessage());
        }

    }

    /**
     * Write the album library to a temporary file
     * @param albumLibrary: The library of albums (wow)
     * @param filename: The filepath to the storage file
     */
    public static void writeAlbums(Database albumLibrary, String filename){
        File file = new File(filename);
        try{
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            file.createNewFile();
            FileWriter fr = new FileWriter(file);
            for(String key: albumLibrary.getKeys()){
                Release album = albumLibrary.getRelease(key);
                String GUID = album.getGUID() + ",";
                String artist = album.getArtist() + ",";
                String name = album.getTitle();
                if(name.contains(",")){
                    name = '"' + name + '"';
                }
                name = name + ',';
                String medium = album.getMedium() + ",";
                String releaseDate = album.getIssueDate() + ',';
                StringBuilder trackList = new StringBuilder();
                int rating = album.getRating();
                for(Release track: album.getTrackList()){
                    trackList.append(track.getTitle() + ",");
                }
                trackList.deleteCharAt(trackList.length());
                String tracks = trackList.toString();
                fr.write(GUID + artist + name + medium + releaseDate + tracks + "," + rating + '\n');
            }
            fr.close();
        }catch(IOException io){
            System.out.println(io.getMessage());
        }

    }
}
