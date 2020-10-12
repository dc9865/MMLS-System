package release;

import java.util.ArrayList;
import java.util.Date;

public interface Release {
    enum Medium{
        CD, VINYL, DIGITAL
    }

    public void setRating(int rating);
    public int getRating();
    public String getGUID();
    public String getTitle();
    public Release getArtist();
    public String getArtistName();
    public String getIssueDate();
    public String getMedium();
    public ArrayList<Release> getTrackList();
    public long getDuration();
    public void setArtist(Release artist);
    public void setAcquisitionDate(String date);

}