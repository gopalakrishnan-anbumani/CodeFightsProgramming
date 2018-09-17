package tree;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
		if(t==null){
			return false;
		}
		if(t.left == null){
			if(t.value==s){
				return true;
			}
		}
		if(t.right == null){
			if(t.value==s){
				return true;
			}
		}
	    return (hasPath(t.left, s, t.value) || hasPath(t.right, s, t.value));
	}
	boolean hasPath(Tree<Integer> t, int s, int total){
		if(t==null){
			return false;
		}
		if(t.left == null){
			if(total==s){
				return true;
			}
		}
		if(t.right == null){
			if(total==s){
				return true;
			}
		}
		return (hasPath(t.left, s, total+t.value) || hasPath(t.right, s, total+t.value));
	}
}
