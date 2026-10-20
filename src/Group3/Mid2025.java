package Group3;

import java.util.Arrays;

public class Mid2025 {
	
	
	public static void main (String [] args){
		
		Object[] arr = {3,'A', -2,'Z', 2, 'R', 5, 'A', 3, 'A'} ; 
		bubbleSortPairs(arr);
		
		System.out.println(Arrays.toString(arr));
		
		
		
		
	}
	
	public static void bubbleSortPairs(Object arr[]){
		for (int i = 0 ; i < arr.length - 2 ; i+=2){
			for (int j = 0 ; j < arr.length - 2 - i ; j+=2){
				if ((int) arr[j] > (int) arr[j+2]){
					Object temp = arr[j] ; 
					arr[j] = arr[j+2] ; 
					arr[j+2] = temp ; 
					
					temp = arr[j+1] ; 
					arr[j+1] = arr[j+3] ; 
					arr[j+3] = temp ; 
				}else if ((int) arr[j] == (int) arr[j+2]){
					if ((char)arr[j+1] > (char)arr[j+3]){
						Object temp = arr[j] ; 
						arr[j] = arr[j+2] ; 
						arr[j+2] = temp ; 
						
						temp = arr[j+1] ; 
						arr[j+1] = arr[j+3] ; 
						arr[j+3] = temp ; 
					}
				}
			}
		}
	}
	
	public static String encode(String s){
		
		StackObj st = new StackObj(s.length());
		String result = "" ; 
		
		for (int i = 0 ; i < s.length() ; i++){
			char c = s.charAt(i);
			
			if (c != ']'){
				st.push(c);
			}else {
				
				// step 1 : collect the text inside the brackets 
				String text = "" ; 
				while (!st.isEmpty() && (char)st.top() != '['){
					text = ((char) st.pop()) +  text ;
				}
				st.pop();
				
				// step 2 : collect the number (digits only) 
				String num = "" ; 
				while (!st.isEmpty() && Character.isDigit((char) st.top())){
					num = ((char) st.pop()) + num ; 
				}
				
				int n = Integer.parseInt(num);
				
				// step 3 : repeat the text n times 
				String part = "" ; 
				for (int j = 0 ; j < n ; j++){
					part += text ; 
				}
				
				// step 4 : push the correct part 
				st.push(part);
			}
		}
		
		while (!st.isEmpty()){
			result = ((char) st.pop()) + result ; 
		}
		
		return result ; 
		
	}

}
