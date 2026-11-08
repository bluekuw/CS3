package Group3;

import java.util.Arrays;

public class Midterm23 {
	
	public static void main (String [] args){
		
		System.out.println("hello world");
		
		int[] arr = {1, 10, 3, 5} ;
		System.out.println(Arrays.toString(movingAverage(arr,3)));;
		
	}
	
	
	public static double [] movingAverage (int [] arr, int k){
		
		if (arr.length == 0 || k < 0) return null ; 
		
		QueueObj q = new QueueObj(arr.length);
		double sum = 0 ; 
		double [] result = new double[arr.length]; 
		
		for (int i = 0 ; i < arr.length ; i++){
			
			if (q.size() < k){
				sum += arr[i] ; 
				q.enqueue(arr[i]);
			}else {
				int elem = (int) q.dequeue();
				sum -= elem ; 
				sum += arr[i] ; 
				q.enqueue(arr[i]);
			}
			
			result[i] = sum / q.size();
		}
		return result ; 
		
	}

}
