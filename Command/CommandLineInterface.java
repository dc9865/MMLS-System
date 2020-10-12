package Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Invoker class that invokes Interface Query to execute functions
 * @author Daniel Cho dc9865@rit.edu
 */
public class CommandLineInterface {
    private final List<Query> queries = new ArrayList<>();

    public void takeQuery(Query query) {
        queries.add(query);
    }
    public void placeQuery() {
        for (Query query: queries) {
            query.execute();
        }
    }
}
