/* And is a composite query that keeps a references of all the queries in it */

package query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class And<T extends Comparable<T>> extends NonTerminalQuery {

	public And(Query ...queries) {
		this.queries = new ArrayList<Query>();
		for(Query query : queries) {
			this.queries.add(query);
		}
	}
	
	@Override
	public HashSet<Integer> execute(Map indexTreeMap) {
		HashSet<Integer> resultSet = null;
		for(Query query : queries) {
			if(resultSet == null)
				resultSet = query.execute(indexTreeMap);
			else
				resultSet.retainAll(query.execute(indexTreeMap));
		}
		return resultSet;
	}
	
	protected ArrayList<Query> queries;
}
