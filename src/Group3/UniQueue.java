package Group3;

public class UniQueue {
	QueueObj q ; 
	
	public UniQueue(int maxSize){
		q = new QueueObj(maxSize);
	}
	
	public void enqueue(String s){
		boolean found = false ; 
		for (int i = 0 ; i < q.size(); i++){
			if (((String)q.peek()).equals(s)){
				found = true ; 
			}
			q.enqueue(q.dequeue());
		}
		if (!found) q.enqueue(s);
	}
	
	public String dequeue(){
		return (String) q.dequeue();
	}
	
	public boolean isEmpty(){
		return q.isEmpty();
	}
	
	public boolean isFull(){
		return q.isFull();
	}
	
	public int size(){
		return q.size();
	}
}
