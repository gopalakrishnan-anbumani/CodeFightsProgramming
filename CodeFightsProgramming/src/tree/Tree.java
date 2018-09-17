package tree;

public class Tree<T> {
	T value;
	public Tree(T t) {
		this.value = t;
	}
	Tree<T> left;
	Tree<T> right;
}
