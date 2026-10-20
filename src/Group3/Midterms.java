package Group3;

import java.util.Arrays;

public class Midterms {
	
	public static void main (String [] args){
		int [] a = {8,4,6,2,3};
		nextSmallerElement(a);
		System.out.println(Arrays.toString(a));
	}
	
	
	public static void nextSmallerElement (int [] arr){
		
		StackObj st = new StackObj(arr.length);
		
		for (int i = 0 ; i < arr.length ; i++){
			
			while (!st.isEmpty() && arr[i] < arr[(int)st.top()]){
				arr[(int)st.top()] = arr[i] ; 
				st.pop();
			}
			st.push(i);
		}
		
	}

}