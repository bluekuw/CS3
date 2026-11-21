package Group3 ; 
class Link {
	public Object data;
	public Link next;
	public Link previous;

	public Link(Object o) {
		data = o;
	}

	public String toString() {
		return data.toString();
	}
}

class DoublyLinkedList {
	private Link first; // reference to first Link on list
	private Link last; // reference to first Link on list

	public DoublyLinkedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(Object d) {
		Link newLink = new Link(d);
		if (isEmpty()) {
			last = newLink;
		} else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink;
	}

	public void insertLast(Object d) {
		Link newLink = new Link(d);
		if (isEmpty())
			first = newLink;
		else {
			last.next = newLink;
			newLink.previous = last;
		}
		last = newLink;
	}

	public Object removeFirst() {
		Object temp = first.data;
		if (first.next == null)
			last = null;
		else
			first.next.previous = null;
		first = first.next;
		return temp;
	}

	public Object removeLast() {
		Object temp = last.data;
		if (first.next == null)
			first = null;
		else
			last.previous.next = null;
		last = last.previous;
		return temp;
	}

	public Object getFirst() {
		return first.data;
	}

	public Object getLast() {
		return last.data;
	}

	public void displayForward() {
		System.out.print("[ ");
		Link current = first;
		while (current != null) {
			System.out.print(current + " ");
			current = current.next;
		}
		System.out.println("]");
	}

	public void displayBackward() {
		System.out.print("[ ");
		Link current = last;
		while (current != null) {
			System.out.print(current + " ");
			current = current.previous;
		}
		System.out.println("]");
	}
	
	public static void main (String [] args){
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertLast(1);
		dll.insertLast(2);
		dll.insertLast(4);
		dll.insertLast(5);
		dll.insertLast(6);
		dll.insertLast(8);
		dll.insertLast(9);
		
		dll.findTargetSum(7);
		
		nodeToList(new Link(147)).displayForward();
		
	}
	
	
	
	
	public void findTargetSum (int x){
		Link head = first ; 
		Link tail = last ; 
		while (head != tail && tail.next != head){
			if ((int)head.data + (int)tail.data == x){
				System.out.println(head.data + " , " + tail.data);
				head = head.next ; 
				tail = tail.previous ; 
			}else {
				if ((int)head.data + (int)tail.data > x){
					tail = tail.previous ; 
				}else {
					head = head.next ; 
				}
			}
		}
	}
	
	public static DoublyLinkedList nodeToList(Link node){
		int num = (int) node.data ; 
		DoublyLinkedList dll = new DoublyLinkedList();
		
		while (num > 0){
			int digit = num % 10 ; 
			dll.insertFirst(digit);
			num = num / 10 ; 
		}
		
		return dll ; 
	}
	
	public void printCount(){
		System.out.println(countRec(first));

	}
	
	public int countRec (Link curr){ // 1 -> 2 -> 3 -> 4 -> null 
		if (curr == null){
			return 0 ; 
		}
		return 1 + countRec(curr.next);
	}
	
	public void InsertInOrder(Object data){
		Link newLink = new Link(data);
		// inserting at the start of the linkedList 
		if ((int)data < (int)first.data ){
			newLink.next = first ; 
			first.previous = newLink ; 
			first = newLink ; 
			return ; 
		}
		// find the correct place to insert in the middle 
		Link curr = first ; 
		while (curr.next != null && (int) curr.next.data < (int) data){
			curr = curr.next ; 
		}
		// inserting in the middle of the linkedList 
		newLink.previous = curr ; 
		newLink.next = curr.next ; 
		
		if (curr.next != null) curr.next.previous = newLink ; 
		else last = newLink ; // in case i'm the last element in the linkedList 
		
		curr.next = newLink ; 
	}
	
	public Link reverseK(Link head, int k){ 
		// 2 -> 1  -> 3 -> 4 -> null 
		if (head == null){
			return null ; 
		}
		Link nextGroupStart = head ; 
		int count = 0 ; 
		while (nextGroupStart != null && count < k){
			nextGroupStart = nextGroupStart.next ; 
			count++ ; 
		}
		Link newHead = reverseGroup(head, k);
		head.next = reverseK(nextGroupStart, k);
		return newHead ; 
	}

} 