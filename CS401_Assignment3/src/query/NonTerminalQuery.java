/* NonTerminalQuery is an abstract class for the queries that reference to
 * other queries. As of right now, this class does not contain any methods or fields
 * but may in the future as more query operations get added. And, Or, and Not queries 
 * extend this class and implement the execute method required by the Query interface.
 */

package query;

import java.util.HashSet;

public abstract class NonTerminalQuery<T extends Comparable<T>> implements Query {

}
