package Group3;

public class Uni implements Comparable {
	
	String name ; 
	int rank ; 
	
	public Uni (String name, int rank){
		this.name = name ; 
		this.rank = rank ; 
	}
	
	public int compareTo(Object other){
		Uni u = (Uni) other ;  // step 1 : type cast 
		if (this.rank < u.rank){
			return -1 ; 
		}else if (this.rank > u.rank){
			return 1 ; 
		}else {
			return this.name.compareTo(u.name);
		}
	}
	
	public static boolean Question1 (int [] a, int [] b){
		// 7al mariam always correct 
		if (a[0] <= b[0]) {
			for (int i = 0 ; i < a.length ; i++){
				if (b[i] < a[i]) return false ; 
			}
		}else {
			for (int i = 0 ; i < a.length ; i++){
				if (a[i] < b[i]) return false ; 
			}
		}
		return true ; 
	}

	public static void main (String [] args){
		
		PriorityQueue pq = new PriorityQueue(5);
		
		Uni u = new Uni("guc",2);
		
		pq.insert(u);
		
	}
}
