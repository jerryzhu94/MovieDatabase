package database;
import edu.princeton.cs.algs4.Queue;


public class RedBlackTree<Key extends Comparable<Key>, Value> {

	//Inserts the key-value entry into the tree
	public void insert(Key key, Value value) {
		//Validate parameters
		if(key == null)
			throw new IllegalArgumentException();
		if(value == null)
			return;
		//Update root
		root = insert(root, key, value);
		root.color = BLACK;
	}
	
	//Returns the value of the node with key
	public Value get(Key key) {
		if(key==null) 
			throw new IllegalArgumentException();
		return get(root, key);
	}
	
	//Prints all keys in order
	public Iterable<Key> keys(){
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue);
		return queue;
	}
	
	//Helper method for the public insert method
	private Node insert(Node currentNode, Key key, Value value) {
		//Base case
		if(currentNode == null)
			return new Node(key, value, RED);
		//Compare key
		int compare = key.compareTo(currentNode.key);
		//Recurse
		if(compare < 0)
			currentNode.left = insert(currentNode.left, key, value);
		else if(compare > 0)
			currentNode.right = insert(currentNode.right, key, value);
		else
			currentNode.value = value;
		return fixTree(currentNode);
	}
	
	//Helper method for the public get method
	private Value get(Node currentNode, Key key) {
		//Base case
		if(currentNode == null)
			return null;
		//Compare key
		int compare = key.compareTo(currentNode.key);
		//Recurse
		if(compare < 0)
			return get(currentNode.left, key);
		else if(compare > 0)
			return get(currentNode.right, key);
		else
			return currentNode.value;
	}
	
	//Helper method for public keys method
	private void keys(Node currentNode, Queue<Key> queue) {
		//Base case
		if(currentNode == null)
			return;
		//Recurse
		keys(currentNode.left, queue);
		queue.enqueue(currentNode.key);
		keys(currentNode.right, queue);
	}
	
	//Fix tree to ensure all criteria are met
	private Node fixTree(Node currentNode) {
		Node left = currentNode.left;
		Node right = currentNode.right;
		//Violation #1: black left and red right
		if(!isRed(left) && isRed(right))
			currentNode = rotateLeft(currentNode);
		//Violation #2: two red nodes adjacent
		if(isRed(left) && isRed(left.left))
			currentNode = rotateRight(currentNode);
		//Violation #3: red left and red right
		if(isRed(left) && isRed(right))
			flipColor(currentNode);
		return currentNode;
	}
	
	private Node rotateLeft(Node currentNode) {
		Node temp = currentNode.right;
		currentNode.right = temp.left;
		temp.left = currentNode;
		temp.color = currentNode.color;
		currentNode.color = RED;
		return temp;
	}
	
	private Node rotateRight(Node currentNode) {
		Node temp = currentNode.left;
		currentNode.left = temp.right;
		temp.right = currentNode;
		temp.color = currentNode.color;
		currentNode.color = RED;
		return temp;
	}
	
	private void flipColor(Node currentNode) {
		currentNode.left.color = BLACK;
		currentNode.right.color = BLACK;
		currentNode.color = RED;
	}
	
	private boolean isRed(Node currentNode) {
		if(currentNode == null)
			return false;
		return currentNode.color;
	}
	
	private Node root;
	
	//Color definitions
	private static boolean RED = true;
	private static boolean BLACK = false;
	
	//Node class
	private class Node {
		Node(Key key, Value value, boolean color){
			this.key = key;
			this.value = value;
			this.color = color;
		}
		
		Key key;
		Value value;
		Node left, right;
		boolean color;
	}
}
