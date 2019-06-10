package query;

import java.util.HashSet;
import java.util.Map;

import database.RedBlackTree;

public class GTE<T extends Comparable<T>> extends TerminalQuery{

	public GTE(String field, T constant) {
		super(field, constant);
	}

	@Override
	public HashSet<Integer> execute(Map indexTreeMap) {
		rbtree = (RedBlackTree<T, HashSet<Integer>>) indexTreeMap.get(field);
		HashSet<Integer> resultSet = new HashSet<Integer>();
		for(Object key : rbtree.keys()) {
			if(constant.compareTo(key) <= 0)
				resultSet.addAll((HashSet<Integer>)rbtree.get((Comparable) key));
		}
		return resultSet;
	}



}
