package Group1;
class Link{
	public Object data;
	public Link next;

	public Link(Object o) {
		this.data = o;
		this.next = null;
	}

	public String toString() {
		return data.toString();
	}
}

class LinkedList {
	private Link head;

	public LinkedList() {
		head = null;
	}

	public void insertFirst(Object o) {
		Link newLink = new Link(o);
		newLink.next = head;
		head = newLink;
	}

	public Object removeFirst() {
		Object res = head.data;
		head = head.next;
		return res;
	}

	public Object getFirst() {
		return head.data;
	}

	public void insertLast(Object o) {
		Link newLink = new Link (o);
		if (head == null) {
			head = newLink;
			return;
		}
		Link current = head;
		while (current.next != null)
			current = current.next;
		current.next = newLink;
	}

	public Object removeLast() {
		if (head.next == null) {
			Object res = head.data;
			head = null;
			return res;
		}
		Link current = head;
		while (current.next.next != null)
			current = current.next;
		Object res = current.next.data;
		current.next = null;
		return res;
	}

	public Object getLast() {
		Link current = head;
		while (current.next != null)
			current = current.next;
		return current.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public String toString() {
		if (head == null)
			return "[ ]";
		String res = "[ " + head.data;
		Link current = head.next;
		while (current != null) {
			res += ", " + current.data;
			current = current.next;
		}
		res += " ]";
		return res;
	}
	
	public void addOnes(){
		Link curr = head ;
		while (curr != null){
			curr.data = (int) curr.data + 1 ; 
			curr = curr.next ; 
		}
	}
	
	
	public static void main (String [] args){
		LinkedList ls = new LinkedList();
		
		ls.insertLast(1);
		ls.insertLast(2);
		ls.insertLast(3);
		
		ls.addOnesRec(ls.head); 

	}
	
	public void addOnesRec(Link curr){ // 2 -> 2 -> 4 -> 4 -> 6 -> 
		if (curr == null) return ; 
		
		curr.data = (int) curr.data + 1; 
		addOnesRec(curr.next);
		System.out.println(curr.data);
		
	}
	
	public void insertLastRec(Object o){
		if (head == null){
			head = new Link(o);
		}else {
			inserLastRec(o,head);
		}
	}
	
	
	public void inserLastRec(Object o, Link curr){
		if (curr.next == null){
			curr.next = new Link(o);
		}else{
			inserLastRec(o,curr);
		}
	}
		
	
	public int findSumRec(Link curr, int result){
		if (curr.next != null) 
			findSumRec(curr.next, (int) curr.data + result);
		return result ; 
	}
	
	public int findSumRec(Link curr){ // 2 , 4 , 6 , null 
		if (curr == null){
			return 0 ; 
		}
		return findSumRec(curr.next) + (int) curr.data ;
	}
	
}
