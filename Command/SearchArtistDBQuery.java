package Command;

import Strategy.SortByArtist;
import databases.MusicLibrary;
import release.Release;

import java.util.ArrayList;

/**
 * Concrete Command that handles functionality of searching artists from database
 * @author Daniel Cho dc9865@rit.edu
 */
public class SearchArtistDBQuery implements Query {
    private MusicLibrary app;
    private String query;

    /**
     * Constructor query to search artist from database
     * @param app: The receiver class, Music Library
     * @param query: query that contains all corresponding information to search artist
     */
    public SearchArtistDBQuery(MusicLibrary app, String query) {
        this.app = app;
        this.query = query;
    }

    /**
     * Call functions from MusicLibrary class to search and sort artists from database
     */
    @Override
    public void execute() {

        //Make an array list of results from searching artists from database
        ArrayList<Release> searchArtistResult = app.searchArtistDatabase(query);

        //Sort artists from search result
        SortByArtist sortByArtist = new SortByArtist();
        sortByArtist.doSort(searchArtistResult);

        //print the sorted results
        for (Release release: searchArtistResult)
            System.out.println(release);
    }
}