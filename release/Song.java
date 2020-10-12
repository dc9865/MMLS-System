package release;

import java.util.ArrayList;

public class Song implements Release{
    private String GUID;
    private String title;
    private Release artist;
    private long duration;
    private int rating;
    private String acquisitionDate;

    public Song(String GUID, String title, Release artist, long duration){
        this.GUID = GUID;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public void setAcquisitionDate(String acquisitionDate){
        this.acquisitionDate = acquisitionDate;
    }

    public String getAcquisitionDate(){
        return this.acquisitionDate;
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
        return title;
    }

    public Release getArtist() {
        return artist;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String getIssueDate() {
        return "";
    }

    @Override
    public String getMedium() {
        return "";
    }

    @Override
    public ArrayList<Release> getTrackList() {
        return null;
    }

    @Override
    public String getArtistName(){
        return this.artist.getTitle();
    }

    @Override
    public String toString(){
        double dur = (double)duration/60000;
        String s = "Title: " + title + "\nArtist: " + artist.getTitle() + "\nGUID: " +
                GUID + "\nDuration: " + dur + " minutes";
        if(acquisitionDate != null){
            s = s + "\nAcquisition Date: " + acquisitionDate;
        }else{
            s = s + "\nAcquisition Date: None";
        }
        s = s + "\nRating: " + rating + "\n";
        return s;
    }
    public void setArtist(Release artist){
        this.artist = artist;
    }
}
