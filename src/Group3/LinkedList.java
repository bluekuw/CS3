package Group3;
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
	
	public void addOnes (LinkedList ls){
		LinkedList temp = new LinkedList ();
		while (!ls.isEmpty()){
			temp.insertLast((int)ls.removeFirst() + 1);
		}
		while (!temp.isEmpty()){
			ls.insertLast(temp.removeFirst());
		}
	}
	
	public void addOnesHead (LinkedList ls){
		Link curr = head ; 
		ls.insertLast((int)ls.removeFirst() + 1);
		while (ls.getFirst() != curr){
			ls.insertLast((int)ls.removeFirst() + 1);
		}
	}
	
	public void addOnes (Link curr){
		if (curr == null) return ; 
		
		curr.data = (int) curr.data + 1 ;
		addOnes(curr.next);
	}
	
	public void insertLastRec(Object o){
		if (head == null){
			head = new Link(o);
		}else {
			insertLastRec(head, o);
		}
	}
	public void insertLastRec(Link curr, Object o){
		if (curr.next == null){
			curr.next = new Link(o);
		}else {
			insertLastRec(curr.next, o);
		}
	}
	
	public void Reverse (){
		LinkedList reversed = new LinkedList();
		Link curr = head ; 
		while (curr != null){
			Link newLink = new Link(curr.data);
			newLink.next = reversed.head ; 
			reversed.head = newLink ; 
			curr = curr.next ; 
		}
		head = reversed.head ; 
	}
	
	public void ReverseInPlace(){
		Link prev = null ; 
		Link curr = head ; 
		Link next = head.next ; 
		
		while (curr.next != null){
			curr.next = prev ; 
			prev = curr ; 
			curr = next ; 
			next = next.next ; 
		}
		curr.next = prev ;
		head = curr ; 
	}
	
	public boolean detectLoop(){
		Link slow = head ; 
		Link fast = head ; 
		
		while (slow != null && fast != null && fast.next != null){
			slow = slow.next ; 
			fast = fast.next.next ; 
			if (slow == fast){
				return true ; 
			}
		}
		return false ; 
	}

	
}
