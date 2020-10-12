package Command;

import databases.MusicLibrary;

import java.util.Scanner;

public class User {

    /** the help command */
    public final static String HELP = "help";

    /** the add artist command */
    public final static String ADD_ARTIST = "add_artist";

    /** the add song command */
    public final static String ADD_SONG = "add_song";

    /** the add release command */
    public final static String ADD_RELEASE = "add_release";

    /** the remove song command */
    public final static String REMOVE_SONG = "remove_song";

    /** the remove release command */
    public final static String REMOVE_RELEASE = "remove_release";

    /** the search artist from database command */
    public final static String SEARCH_ARTIST_DATABASE = "search_artist_db";

    /** the search song by song title from database command */
    public final static String SEARCH_SONG_DATABASE_BY_SONG_TITLE = "search_song_db_song_title";

    /** the search song by artist from database command */
    public final static String SEARCH_SONG_DATABASE_BY_ARTIST = "search_song_db_artist";

    /** the search song by release from database command */
    public final static String SEARCH_SONG_DATABASE_BY_RELEASE_TITLE = "search_song_db_release_title";

    /** the search song by minimum duration from database command */
    public final static String SEARCH_SONG_DATABASE_BY_MIN_DURATION = "search_song_db_min_duration";

    /** the search song by maximum duration from database command */
    public final static String SEARCH_SONG_DATABASE_BY_MAX_DURATION = "search_song_db_max_duration";

    /** the search release by release title from database command */
    public final static String SEARCH_RELEASE_DATABASE_BY_RELEASE_TITLE = "search_release_db_release_title";

    /** the search release by artist title from database command */
    public final static String SEARCH_RELEASE_DATABASE_BY_ARTIST = "search_release_db_song_artist";

    /** the search release by song title from database command */
    public final static String SEARCH_RELEASE_DATABASE_BY_SONG_TITLE = "search_release_db_song_title";

    /** the search release by minimum duration from database command */
    public final static String SEARCH_RELEASE_DATABASE_BY_MIN_DURATION = "search_release_db_min_duration";

    /** the search release by maximum duration from database command */
    public final static String SEARCH_RELEASE_DATABASE_BY_MAX_DURATION = "search_release_db_max_duration";

    /** the search artist by artist name from library command */
    public final static String SEARCH_ARTIST_LIBRARY_BY_NAME = "search_artist_lb_name";

    /** the search artist by ratings from library command */
    public final static String SEARCH_ARTIST_LIBRARY_BY_RATING = "search_artist_lb_rating";

    /** the search song by song title from library command */
    public final static String SEARCH_SONG_LIBRARY_BY_SONG_TITLE = "search_song_lb_song_title";

    /** the search song by artist name/guid from library command */
    public final static String SEARCH_SONG_LIBRARY_BY_ARTIST = "search_song_lb_artist";

    /** the search song by release title/guid from library command */
    public final static String SEARCH_SONG_LIBRARY_BY_RELEASE = "search_song_lb_release";

    /** the search song by minimum duration from library command */
    public final static String SEARCH_SONG_LIBRARY_BY_MIN_DURATION = "search_song_lb_min_duration";

    /** the search song by maximum duration from library command */
    public final static String SEARCH_SONG_LIBRARY_BY_MAX_DURATION = "search_song_lb_max_duration";

    /** the search song by rating from library command */
    public final static String SEARCH_SONG_LIBRARY_BY_RATING = "search_song_lb_rating";

    /** the search release by release title from library command */
    public final static String SEARCH_RELEASE_LIBRARY_BY_RELEASE_TITLE = "search_release_lb_release_title";

    /** the search release by artist name/guid from library command */
    public final static String SEARCH_RELEASE_LIBRARY_BY_ARTIST = "search_release_lb_artist";

    /** the search release by song name/guid from library command */
    public final static String SEARCH_RELEASE_LIBRARY_BY_SONG = "search_release_lb_song";

    /** the search release by date from library command */
    public final static String SEARCH_RELEASE_LIBRARY_BY_DATE = "search_release_lb_date";

    /** the search release by minimum duration from library command */
    public final static String SEARCH_RELEASE_LIBRARY_BY_MIN_DURATION = "search_release_lb_min_duration";

    /** the search release by maximum duration from library command */
    public final static String SEARCH_RELEASE_LIBRARY_BY_MAX_DURATION = "search_release_lb_max_duration";

    /** the search release by rating from library command */
    public final static String SEARCH_RELEASE_LIBRARY_BY_RATING = "search_release_lb_release_rating";

    /** the query rate a song from the library*/
    public final static String RATE_FROM_LIBRARY = "rate";


    /** the quit command */
    public final static String QUIT = "quit";

    public static void main(String[] args)  {

        // create a scanner that is tied to either standard input or an input file
        Scanner in;
        boolean stdin = true;

        if (stdin) {
            System.out.println("Type 'help' for the list of commands.");
        }
        System.out.print("> ");
        // continue looping until the user enters "quit" or there is no more input
        boolean done = false;
        in = new Scanner(System.in);
        MusicLibrary musicLibrary = new MusicLibrary();
        while (!done && in.hasNext ()) {
            // read the next command and then call the appropriate method to process it
            String line = in.nextLine();
            String fields[] = line.split("\\s+");

            CommandLineInterface command = new CommandLineInterface();
            String query;
            String type;
            SearchSongDBQuery searchSongDatabase;
            SearchReleaseDBQuery searchReleaseDatabase;
            SearchArtistLBQuery searchArtistLibrary;
            SearchSongLBQuery searchSongLibrary;
            SearchReleaseLBQuery searchReleaseLibrary;
            RateQuery rateQuery;

            //switch statement to handle each case
            switch (fields[0]) {
                case HELP:
                    System.out.println("add_song {song GUID}: Add a song to library");
                    System.out.println("add_release {release GUID}: Add a release to library");
                    System.out.println("remove_song {song GUID}: Remove a song from library");
                    System.out.println("remove_release {release GUID}: Remove a release from library");

                    System.out.println("search_artist_db {name}: Search artists by artist name from database.");

                    System.out.println("search_song_db_song_title {title}: Search songs by song title from database");
                    System.out.println("search_song_db_artist {artist}: Search songs by artist from database");
                    System.out.println("search_song_db_release_title {release title}: Search songs by release title from database");
                    System.out.println("search_song_db_min_duration {minimum duration}: Search songs by minimum duration from database");
                    System.out.println("search_song_db_max_duration {maximum duration}: Search songs by maximum duration from database");

                    System.out.println("search_release_db_release_title {release title}: Search releases by release title from database.");
                    System.out.println("search_release_db_song_artist {artist}: Search releases by artist title from database.");
                    System.out.println("search_release_db_song_title {song title}: Search releases by song title from database.");
                    System.out.println("search_release_db_min_duration {minimum duration}: Search releases by minimum duration of songs from database.");
                    System.out.println("search_release_db_max_duration {maximum duration}: Search releases by maximum duration of songs from database.");

                    System.out.println("search_artist_lb_name {artist name}: Search artists by artist name from library.");
                    System.out.println("search_artist_lb_rating {rating}: Search artists by rating from library.");

                    System.out.println("search_song_lb_song_title {song title}: Search songs by song title from library.");
                    System.out.println("search_song_lb_artist {artist name}: Search songs by artist name/guid from library.");
                    System.out.println("search_song_lb_release {release title}: Search songs by release title/guid from library.");
                    System.out.println("search_song_lb_min_duration {minimum duration}: Search songs by minimum duration from library.");
                    System.out.println("search_song_lb_max_duration {maximum duration}: Search songs by maximum duration from library.");

                    System.out.println("search_release_lb_release_title {release title}: Search releases by release title from library.");
                    System.out.println("search_release_lb_artist {artist name/guid}: Search releases by artist name/guid from library.");
                    System.out.println("search_release_lb_song {song name/guid}: Search releases by song name/guid from library.");
                    System.out.println("search_release_lb_date {date}: Search releases by date from library.");
                    System.out.println("search_release_lb_min_duration {minimum duration}: Search releases by minimum duration from library.");
                    System.out.println("search_release_lb_max_duration {maximum duration}: Search releases by maximum duration from library.");
                    System.out.println("search_release_lb_release_rating {rating}: Search releases by rating from library.");

                    System.out.println("rate {GUID, rating number}: Rates whatever you pass into it (Album, song, or artist)");
                    System.out.println("quit: exit out of prompt");
                    break;

                case ADD_ARTIST:
                    String artistGuid = fields[1];
                    AddArtistQuery addArtist = new AddArtistQuery(musicLibrary, artistGuid);
                    command.takeQuery(addArtist);
                    command.placeQuery();
                    break;

                case ADD_SONG:
                    String songGuid = fields[1];
                    AddSongQuery addSong = new AddSongQuery(musicLibrary, songGuid);
                    command.takeQuery(addSong);
                    command.placeQuery();
                    break;

                case ADD_RELEASE:
                    String releaseGuid = fields[1];
                    AddReleaseQuery addRelease = new AddReleaseQuery(musicLibrary, releaseGuid);
                    command.takeQuery(addRelease);
                    command.placeQuery();
                    break;

                case REMOVE_SONG:
                    String removeSongGuid = fields[1];
                    RemoveSongQuery removeSongQuery = new RemoveSongQuery(musicLibrary, removeSongGuid);
                    command.takeQuery(removeSongQuery);
                    command.placeQuery();
                    break;

                case REMOVE_RELEASE:
                    String removeReleaseGuid = fields[1];
                    RemoveReleaseQuery removeReleaseQuery = new RemoveReleaseQuery(musicLibrary, removeReleaseGuid);
                    command.takeQuery(removeReleaseQuery);
                    command.placeQuery();
                    break;

                case SEARCH_ARTIST_DATABASE:
                    String artistName = fields[1];
                    query = artistName;
                    SearchArtistDBQuery searchArtistDatabase = new SearchArtistDBQuery(musicLibrary, query);
                    command.takeQuery(searchArtistDatabase);
                    command.placeQuery();
                    break;

                case SEARCH_SONG_DATABASE_BY_SONG_TITLE:
                    query = fields[1];
                    type = "title";
                    searchSongDatabase = new SearchSongDBQuery(musicLibrary, query, type);
                    command.takeQuery(searchSongDatabase);
                    command.placeQuery();
                    break;

                case SEARCH_SONG_DATABASE_BY_ARTIST:
                    query = fields[1];
                    type = "artist";
                    searchSongDatabase = new SearchSongDBQuery(musicLibrary, query, type);
                    command.takeQuery(searchSongDatabase);
                    command.placeQuery();
                    break;

                case SEARCH_SONG_DATABASE_BY_RELEASE_TITLE:
                    query = fields[1];
                    type = "releaseTitle";
                    searchSongDatabase = new SearchSongDBQuery(musicLibrary, query, type);
                    command.takeQuery(searchSongDatabase);
                    command.placeQuery();
                    break;

                case SEARCH_SONG_DATABASE_BY_MIN_DURATION:
                    query = fields[1];
                    type = "durationLess";
                    searchSongDatabase = new SearchSongDBQuery(musicLibrary, query, type);
                    command.takeQuery(searchSongDatabase);
                    command.placeQuery();
                    break;

                case SEARCH_SONG_DATABASE_BY_MAX_DURATION:
                    query = fields[1];
                    type = "durationMore";
                    searchSongDatabase = new SearchSongDBQuery(musicLibrary, query, type);
                    command.takeQuery(searchSongDatabase);
                    command.placeQuery();
                    break;

                case SEARCH_RELEASE_DATABASE_BY_RELEASE_TITLE:
                    query = fields[1];
                    type = "releaseTitle";
                    searchReleaseDatabase = new SearchReleaseDBQuery(musicLibrary, query, type);
                    command.takeQuery(searchReleaseDatabase);
                    command.placeQuery();
                    break;

                case SEARCH_RELEASE_DATABASE_BY_ARTIST:
                    query = fields[1];
                    type = "artist";
                    searchReleaseDatabase = new SearchReleaseDBQuery(musicLibrary, query, type);
                    command.takeQuery(searchReleaseDatabase);
                    command.placeQuery();
                    break;

                case SEARCH_RELEASE_DATABASE_BY_SONG_TITLE:
                    query = fields[1];
                    type = "song";
                    searchReleaseDatabase = new SearchReleaseDBQuery(musicLibrary, query, type);
                    command.takeQuery(searchReleaseDatabase);
                    command.placeQuery();
                    break;

                case SEARCH_RELEASE_DATABASE_BY_MIN_DURATION:
                    query = fields[1];
                    type = "durationLess";
                    searchReleaseDatabase = new SearchReleaseDBQuery(musicLibrary, query, type);
                    command.takeQuery(searchReleaseDatabase);
                    command.placeQuery();
                    break;

                case SEARCH_RELEASE_DATABASE_BY_MAX_DURATION:
                    query = fields[1];
                    type = "durationMore";
                    searchReleaseDatabase = new SearchReleaseDBQuery(musicLibrary, query, type);
                    command.takeQuery(searchReleaseDatabase);
                    command.placeQuery();
                    break;

                case SEARCH_ARTIST_LIBRARY_BY_NAME:
                    query = fields[1];
                    type = "title";
                    searchArtistLibrary = new SearchArtistLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchArtistLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_ARTIST_LIBRARY_BY_RATING:
                    query = fields[1];
                    type = "rating";
                    searchArtistLibrary = new SearchArtistLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchArtistLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_SONG_LIBRARY_BY_SONG_TITLE:
                    query = fields[1];
                    type = "title";
                    searchSongLibrary = new SearchSongLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchSongLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_SONG_LIBRARY_BY_ARTIST:
                    query = fields[1];
                    type = "artist";
                    searchSongLibrary = new SearchSongLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchSongLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_SONG_LIBRARY_BY_RELEASE:
                    query = fields[1];
                    type = "release";
                    searchSongLibrary = new SearchSongLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchSongLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_SONG_LIBRARY_BY_MIN_DURATION:
                    query = fields[1];
                    type = "durationLess";
                    searchSongLibrary = new SearchSongLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchSongLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_SONG_LIBRARY_BY_MAX_DURATION:
                    query = fields[1];
                    type = "durationMore";
                    searchSongLibrary = new SearchSongLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchSongLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_SONG_LIBRARY_BY_RATING:
                    query = fields[1];
                    type = "rating";
                    searchSongLibrary = new SearchSongLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchSongLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_RELEASE_LIBRARY_BY_RELEASE_TITLE:
                    query = fields[1];
                    type = "title";
                    searchReleaseLibrary = new SearchReleaseLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchReleaseLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_RELEASE_LIBRARY_BY_ARTIST:
                    query = fields[1];
                    type = "artist";
                    searchReleaseLibrary = new SearchReleaseLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchReleaseLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_RELEASE_LIBRARY_BY_SONG:
                    query = fields[1];
                    type = "song";
                    searchReleaseLibrary = new SearchReleaseLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchReleaseLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_RELEASE_LIBRARY_BY_DATE:
                    query = fields[1];
                    type = "date";
                    searchReleaseLibrary = new SearchReleaseLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchReleaseLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_RELEASE_LIBRARY_BY_MIN_DURATION:
                    query = fields[1];
                    type = "durationLess";
                    searchReleaseLibrary = new SearchReleaseLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchReleaseLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_RELEASE_LIBRARY_BY_MAX_DURATION:
                    query = fields[1];
                    type = "durationMore";
                    searchReleaseLibrary = new SearchReleaseLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchReleaseLibrary);
                    command.placeQuery();
                    break;

                case SEARCH_RELEASE_LIBRARY_BY_RATING:
                    query = fields[1];
                    type = "rating";
                    searchReleaseLibrary = new SearchReleaseLBQuery(musicLibrary, query, type);
                    command.takeQuery(searchReleaseLibrary);
                    command.placeQuery();
                    break;

                case RATE_FROM_LIBRARY:
                    if(fields.length < 3){
                        System.out.println("Rating requires {GUID, ratingNum}, try again");
                        break;
                    }
                    query = fields[1];
                    int rating = Integer.parseInt(fields[2]);
                    rateQuery = new RateQuery(musicLibrary, query, rating);
                    command.takeQuery(rateQuery);
                    command.placeQuery();
                    break;

                case QUIT:
                    done = true;
                    musicLibrary.closeLibrary();
                    break;

                default:
                    System.out.println("Unrecognized command " + fields[0]);
            }

            // reprompt
            System.out.print("> ");
        }


        // close the scanner
        in.close();
    }
}
