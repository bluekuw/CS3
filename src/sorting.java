import java.util.Arrays;


public class sorting {
	
	public static void main (String [] args){
		
		int [] arr = {3,6,4,5,9} ; 
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void bubbleSort(int [] arr){
		for (int i = 0 ; i < arr.length - 1; i++){
			for (int j = 0 ; j < arr.length - 1 - i ; j++){
				if (arr[j] > arr[j+1]){
					int num1 = arr[j] ; 
					int num2 = arr[j+1];
					arr[j] = num2 ; 
					arr[j+1] = num1 ;
				}
			}
		}
	}
	
	public static void insertionSort(int [] arr){
		for (int i = 1 ; i < arr.length ; i++){
			int num = arr[i] ; 
			int j = i - 1 ;
			for ( ; j >= 0 && num < arr[j]; j--){
				arr[j+1] = arr[j] ; 
			}
			arr[j+1] = num ;
		}
	}
	
	public static void countSort(int [] arr){
		int max = -1 ; 
		for (int i = 0 ; i < arr.length ; i++){
			if (arr[i] > max){
				max = arr[i] ; 
			}
		}
		int[] freq = new int[max+1] ; 
		
		for (int i = 0 ; i < arr.length ; i++){
			freq[arr[i]]++ ; 
		}
		
		int index = 0 ;
		for (int i = 0 ; i < freq.length ; i++){
			while (freq[i] > 0){
				arr[index] = i ; 
				index++ ; 
				freq[i]-- ; 
			}
		}
	}
	
	public static void indexSort(int [] arr){
		
		int [] result = new int[arr.length] ; 
		
		for (int i = 0 ; i < arr.length ; i++){
			int count = 0 ; 
			for (int j = 0 ; j < arr.length ; j++){
				if (arr[i] > arr[j]){
					count++ ; 
				}
			}
			result[count] = arr[i] ; 
		}
		
	}
	
	

}
