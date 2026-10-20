package Group3;

public class CoolMap {
	
	QueueObj q ; 
	
	public CoolMap(int maxSize){
		q = new QueueObj(maxSize);
	}
	
	public void insert(Pair p){
		for (int i = 0 ; i < q.size() ; i++){
			Pair front = (Pair) q.peek();
			
			if (front.k == p.k || front.v == p.v){
				q.dequeue();
			}else {
				q.enqueue(q.dequeue());
			}
		}
		q.enqueue(p);
	}
	
	public int lookUp (int k){
		for (int i = 0 ; i < q.size() ; i++){
			Pair front = (Pair) q.peek();
			
			if (front.k == k) return front.v ; 
		}
		return -1 ; 
	}
	
	public int rlookUp (int v){
		for (int i = 0 ; i < q.size() ; i++){
			Pair front = (Pair) q.peek();
			
			if (front.v == v) return front.k ; 
		}
		return -1 ; 
	}
	
	public void delete (int k){
		
		int size = q.size();
		
		for (int i = 0 ; i < size ; i++){
			Pair front = (Pair) q.peek();
			
			if (front.k == k){
				q.dequeue();
			}else {
				q.enqueue(q.dequeue());
			}
		}
	}
	
	

}
