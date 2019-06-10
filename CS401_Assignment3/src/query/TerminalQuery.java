/* TerminalQuery is an abstract class for the queries that do not reference to
 * other queries. They all share take in two parameters: field(String) and
 * constant(Comparable Generics). GTE, LTE, Equal, and NotEqual extend this class 
 * and implement the execute method required by the Query interface.
 */

package query;

import java.util.HashSet;

import database.RedBlackTree;

public abstract class TerminalQuery<T extends Comparable<T>> implements Query{
	
	public TerminalQuery(String field, T constant) {
		this.field = field;
		this.constant = constant;
	}
	
	protected String field;
	protected T constant;
	protected RedBlackTree<T, HashSet<Integer>> rbtree;
}
