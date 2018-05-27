package program.java.linkedlist;



public class ReverseNodesInKGroups {

	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<Integer>(1);
		ListNode<Integer> node1 = new ListNode<Integer>(2);
		ListNode<Integer> node2 = new ListNode<Integer>(3);
		ListNode<Integer> node3 = new ListNode<Integer>(4);
		ListNode<Integer> node4 = new ListNode<Integer>(5);
		ListNode<Integer> node5 = new ListNode<Integer>(6);
		ListNode<Integer> node6 = new ListNode<Integer>(7);
		ListNode<Integer> node7 = new ListNode<Integer>(8);
		ListNode<Integer> node8 = new ListNode<Integer>(9);
		ListNode<Integer> node9 = new ListNode<Integer>(10);
		ListNode<Integer> node10 = new ListNode<Integer>(11);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		
		//ListNode<Integer> node6 = new ListNode<Integer>(6);
		
		//ListNode<Integer> rev = reverse(head,node6);
		
		//ListNode<Integer> rev = splitNodes(head,head,3,1);
		ListNode<Integer> rev = reverseNodesKGroups(head,12);
		while(rev!=null){
			System.out.print("->. " +rev.value);
			rev = rev.next;
		}
		

	}
	public static ListNode<Integer> reverseNodesKGroups(ListNode<Integer> l, int k) {
			
		ListNode<Integer> start=l;
		ListNode<Integer> end=l;
		ListNode<Integer> previousend=null;
		ListNode<Integer> lastRes=null;
		
		
		while(end!=null){
			int count=1;
			while(end!=null && count<=k){
				if(count==k){
					//System.out.println("Start End "+start.value+" "+end.value);
					ListNode<Integer> res = reverseStoE(start, end,k);
					if(previousend!=null){
						//System.out.println(previousend.value+" prev nect "+res.value);
						previousend.next = res;
					}
					if(lastRes==null){
						lastRes = end;
					}
					count =1;
					while(res!=null){
						System.out.print("-> " +res.value);
						res = res.next;
					}
					//System.out.println("Start /// "+start.value);
					previousend = start;
					start = start.next;
					end = start;
					System.out.println();
				}else{
					end = end.next;
					count++;
				}
			
			}
			
		}
		return lastRes;
	}
	
	public static ListNode<Integer> splitNodes(ListNode<Integer> start,ListNode<Integer> end,int k, int index){
		return start;
	}
	
	public static ListNode<Integer> reverseStoE(ListNode<Integer> start,ListNode<Integer> end,int k){
		
		ListNode<Integer> prev = end.next;
		System.out.println("Starting point "+start.value+" ending Point : "+end.value);
		while(k>0){
			ListNode<Integer> nextNode = start.next;
			start.next = prev;
			prev = start;
			start = nextNode;
			k--;
		}
		//System.out.println("PRE "+prev.value);
		return prev;
	}
	
	public static ListNode<Integer> reverse(ListNode<Integer> head,ListNode<Integer> nextGroup){
		
		ListNode<Integer> prev = null;
		while(head!=null){
			ListNode<Integer> nextNode = head.next;
			head.next = prev;
			prev = head;
			head = nextNode;
		}
		return prev;
	}


	// Definition for singly-linked list:
	static class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}
}
