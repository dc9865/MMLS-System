package Strategy;
import release.Release;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByReleaseDate implements ResultsSorter {
    @Override
    public void doSort(ArrayList<Release> searchResults) {
        Collections.sort(searchResults, Comparator.comparing(Release::getIssueDate));
    }
}
