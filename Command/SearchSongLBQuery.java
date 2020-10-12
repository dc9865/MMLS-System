package Command;

import Strategy.SortByAquisitionDate;
import Strategy.SortByRating;
import Strategy.SortBySong;
import databases.MusicLibrary;
import release.Release;

import java.util.ArrayList;

/**
 * Concrete Command that handles functionality of searching songs from library
 * @author Daniel Cho dc9865@rit.edu
 */
public class SearchSongLBQuery implements Query {
    private MusicLibrary app;
    private String query;
    private String type;

    /**
     * Constructor query to search releases from library
     * @param app: The receiver class, Music Library
     * @param query: query that contains all corresponding information to search songs
     */
    public SearchSongLBQuery(MusicLibrary app, String query, String type) {
        this.app = app;
        this.query = query;
        this.type = type;
    }

    /**
     * Call functions from MusicLibrary class to search and sort songs from library
     */
    @Override
    public void execute() {

        //Make an array list of results from searching songs from library
        ArrayList<Release> searchSongResult = app.searchSongLibrary(query, type);

        //Sort songs from search result
        SortBySong sortBySong = new SortBySong();
        SortByRating sortByRating = new SortByRating();
        SortByAquisitionDate sortByAquisitionDate = new SortByAquisitionDate();
        sortBySong.doSort(searchSongResult);
        sortByRating.doSort(searchSongResult);
        sortByAquisitionDate.doSort(searchSongResult);

        //print the sorted results
        for (Release release: searchSongResult)
            System.out.println(release);

    }
}