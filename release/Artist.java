package release;

import java.util.ArrayList;
import java.util.Comparator;

public class Artist implements Release, Comparator<Release> {
    private String GUID;
    private String artistName;
    private String disambiguation;
    private int rating;

    public Artist(String GUID, String artistName, String disambiguation){
        this.GUID = GUID;
        this.artistName = artistName;
        this.disambiguation = disambiguation;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public String getGUID() {
        return GUID;
    }

    public String getTitle() {
        return artistName;
    }


    public String getArtistType() {
        return disambiguation;
    }

    @Override
    public Release getArtist(){
        return null;
    }

    @Override
    public void setArtist(Release artist) { }


    public String getIssueDate(){
        return "";
    }

    public String getMedium(){
        return "";
    }

    @Override
    public ArrayList<Release> getTrackList() {
        return null;
    }

    public long getDuration(){
        return 0;
    }

    @Override
    public void setAcquisitionDate(String date) {

    }

    @Override
    public int compare(Release artist1, Release artist2){

        return artist1.getTitle().compareTo(artist2.getTitle());
    }


    public String getArtistName(){
        return "";
    }

    @Override
    public String toString(){
        return "Name: " + artistName + "\nGUID: " + GUID +
                "\nDisambiguation: " + disambiguation + "\nRating: " + rating
                + "\n";
    }
}
