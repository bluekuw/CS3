package Group4;
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
	
	public void addOnes(){ // 2 -> 3 -> 3 -> null 
		Link curr = head ; 
		while (curr != null){
			curr.data = (int) curr.data + 1 ; 
			curr = curr.next ; 
		}
	}
	
	public void addOnes (LinkedList ls){
		LinkedList temp = new LinkedList();
		while (!ls.isEmpty()){
			int num = (int) ls.removeFirst();
			num += 1 ; 
			temp.insertFirst(num);
		}
		while (!temp.isEmpty()){
			ls.insertFirst(temp.removeLast());
		}
	}
	
	public void addOnesRec(Link curr){
		if (curr == null) return ; 
		curr.data = (int) curr.data + 1 ; 
		addOnesRec(curr.next);
	}
	
	public int findSumRec (Link curr, int sum){ // 1 -> 2 -> 3 
		if (curr == null){
			return sum ; 
		}
		
		sum += (int) curr.data ;
		return findSumRec(curr.next, sum); 
		// rec(1,0) -> (2,1) -> (3,3) -> (null, 6) 
	}
	
	public void printInReverse(Link curr){
		if (curr == null){
			return ; 
		}
		printInReverse(curr.next);
		System.out.println(curr.data);
	}
	
	public void Reverse(){
		
		Link reversedHead = null ; 
		Link curr = head ; 
		while (curr != null){
			Link newLink = new Link(curr.data);
			newLink.next = reversedHead ; 
			reversedHead = newLink ; 
			curr = curr.next ; 
		}
		head = reversedHead ; 
		
	}
	
	public void ReverseInPlace (){
		Link prev = null ; 
		Link curr = head ; 
		Link next = head.next ; 
		
		while (curr.next != null){
			curr.next = prev ; 
			prev = curr ; 
			curr = next ; 
			next = curr.next ; // next.next also valid 
		}
		curr.next = prev ; 
		head = curr ; 
	}
	
	

	
}
