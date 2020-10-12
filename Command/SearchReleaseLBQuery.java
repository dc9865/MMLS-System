package Command;

import Strategy.SortByAquisitionDate;
import Strategy.SortByRating;
import Strategy.SortByReleaseDate;
import Strategy.SortBySong;
import databases.MusicLibrary;
import release.Release;

import java.util.ArrayList;

/**
 * Concrete Command that handles functionality of searching releases from library
 * @author Daniel Cho dc9865@rit.edu
 */
public class SearchReleaseLBQuery implements Query {
    private MusicLibrary app;
    private String query;
    private String type;

    /**
     * Constructor query to search releases from library
     * @param app: The receiver class, Music Library
     * @param query: query that contains all corresponding information to search releases
     */
    public SearchReleaseLBQuery(MusicLibrary app, String query, String type) {
        this.app = app;
        this.query = query;
        this.type = type;
    }

    /**
     * Call functions from MusicLibrary class to search and sort releases from library
     */
    @Override
    public void execute() {

        //Make an array list of results from searching releases from library
        ArrayList<Release> searchReleaseResult = app.searchAlbumLibrary(query, type);

        //Sort releases from search result
        SortByReleaseDate sortByReleaseDate = new SortByReleaseDate();
        SortByAquisitionDate sortByAquisitionDate = new SortByAquisitionDate();
        SortBySong sortBySong = new SortBySong();
        SortByRating sortByRating = new SortByRating();
        sortByReleaseDate.doSort(searchReleaseResult);
        sortByAquisitionDate.doSort(searchReleaseResult);
        sortBySong.doSort(searchReleaseResult);
        sortByRating.doSort(searchReleaseResult);

        //print the sorted results
        for (Release release: searchReleaseResult)
            System.out.println(release);
    }
}