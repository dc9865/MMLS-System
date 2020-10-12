package Strategy;

import release.Release;
import release.Song;

import java.util.ArrayList;

public interface ResultsSorter {
    public void doSort(ArrayList<Release> searchResults);
}
