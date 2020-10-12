package Command;

import Strategy.SortByArtist;
import databases.MusicLibrary;
import release.Release;

import java.util.ArrayList;

/**
 * Concrete Command that handles functionality of searching artists from library
 * @author Daniel Cho dc9865@rit.edu
 */
public class SearchArtistLBQuery implements Query {
    private MusicLibrary app;
    private String query;
    private String type;

    /**
     * Constructor query to search artist from library
     * @param app: The receiver class, Music Library
     * @param query: query that contains all corresponding information to search artist
     */
    public SearchArtistLBQuery(MusicLibrary app, String query, String type) {
        this.app = app;
        this.query = query;
        this.type = type;
    }

    /**
     * Call functions from MusicLibrary class to search and sort artists from library
     */
    @Override
    public void execute() {

        //Make an array list of results from searching artists from library
        ArrayList<Release> searchArtistResult = app.searchArtistLibrary(query, type);

        //Sort artists from search result
        SortByArtist sortByArtist = new SortByArtist();
        sortByArtist.doSort(searchArtistResult);

        //print the sorted results
        for (Release release: searchArtistResult)
            System.out.println(release);

    }
}