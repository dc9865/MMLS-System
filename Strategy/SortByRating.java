package Strategy;
import release.Release;
import release.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByRating implements ResultsSorter {
    @Override
    public void doSort(ArrayList<Release> searchResults) {
        Collections.sort(searchResults, Comparator.comparing(Release::getRating));
    }
}
