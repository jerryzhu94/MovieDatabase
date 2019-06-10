/* Not is a composite query that keeps a references of the queries in it. 
 * Unlike And and Or query, it contains only one reference to a query.
 */


package query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import database.RedBlackTree;

public class Not<T extends Comparable<T>> extends NonTerminalQuery {

	public Not(Query query) {
		this.query = query;
	}
	
	@Override
	public HashSet<Integer> execute(Map indexTreeMap) {
		
		RedBlackTree rbtree = ((RedBlackTree) indexTreeMap.get("id"));
		HashSet<Integer> resultSet1 = new HashSet<Integer>();
		for(Object key : rbtree.keys())
			resultSet1.add((Integer) key);
		
		HashSet<Integer> resultSet2 = query.execute(indexTreeMap);
		resultSet1.removeAll(resultSet2);
		return resultSet1;
	}
	
	protected Query query;
}
