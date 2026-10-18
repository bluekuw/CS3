package Group3;

public class Main {
	
	
	public static void main (String [] args){
		System.out.println("hello");
		RevRec(new QueueObj(5));
		System.out.println("world");

	}
	
	public static void RevRec (QueueObj q){ // O(1) 
		if (q.isEmpty()) return ; 
		
		Object elem = q.dequeue(); // 1 
		RevRec(q);
		q.enqueue(elem);
	}
	
	public static void ReverseIter (QueueObj q){
		
		int size = q.size();
		
		for (int i = 0 ; i < size ; i++){
			
			Object curr = q.dequeue();
			
			for (int j = 0 ; j < size - 1 - i ; j++ ){
				q.enqueue(q.dequeue());
			}
			q.enqueue(curr);
			for (int j = 0 ; j < i ; j++){
				q.enqueue(q.dequeue());
			}
		}
	}
	
	public static QueueObj Every3rdElem(QueueObj q){ // 1 2 3 4 
		
		StackObj rev = new StackObj(q.size());
		while (!q.isEmpty()){
			rev.push(q.dequeue());
		}
		QueueObj result = new QueueObj(rev.size() / 3 + 1);
		while (!rev.isEmpty()){
			
			result.enqueue(rev.pop());
			
			if (!rev.isEmpty()) rev.pop();
			if (!rev.isEmpty()) rev.pop();
			
		}
		return result ; 
	}
	
	
	public static boolean anagram (String a, String b){
		
		if (a.length() != b.length()) return false ; 
		
		QueueObj q1 = new QueueObj(a.length());
		QueueObj q2 = new QueueObj(b.length());
		
		for (int i = 0 ; i < a.length() ; i++) 
			q1.enqueue(a.charAt(i));
		
		for (int i = 0 ; i < b.length() ; i++) 
			q2.enqueue(b.charAt(i));
		
		int size = a.length() ; 
		
		for (int i = 0 ; i < size ; i++){ //  a, x , c 
			Object elem = q1.peek();//  , a , b , c , 
			
			for (int j = 0 ; j < size ; j++){
				if (elem.equals(q2.peek())) {
					q1.dequeue();
					q2.dequeue();
					break ; 
				}
				if (j == size - 1 && !elem.equals(q2.peek())) 
					return false ; 
				q2.enqueue(q2.dequeue());
			}
		}
		
		return q1.size() == q2.size();
		
	}
	
	

}