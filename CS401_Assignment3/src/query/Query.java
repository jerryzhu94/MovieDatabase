/* Query is an interface that gets implemented by TerminalQuery and NonTerminalQuery.
 * It has one method, execute, that takes a Map as input and returns a HashSet
 * that contains the ids of all the movies that meet the query's criteria.
 * The composite design pattern was used to implement Query. 
 * A Query may contain other Queries. The purpose of using composite is to 
 * use the recursive nature of this pattern to dynamically create any Query structure
 * and allow for high extensibility. 
 */

package query;

import java.util.HashSet;
import java.util.Map;

import database.RedBlackTree;

public interface Query<T extends Comparable<T>> {
	public abstract HashSet<Integer> execute(Map<String, RedBlackTree<T, HashSet<Integer>>> indexTreeMap);

}
