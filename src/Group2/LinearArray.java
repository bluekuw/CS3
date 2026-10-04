package Group2 ; 

public class LinearArray {
	// a counter that keeps track of the number of elements in the array
		int itemCount;
		int[] array;

		// constructor
		public LinearArray(int maxSize) {
			itemCount = 0;
			array = new int[maxSize];
		}

		// method to insert elements at the end of an unordered array
		// Time complexity: O(1)
		public void insertLast(int x) {
			if (itemCount < array.length)
				array[itemCount++] = x;
			else
				System.out.print("Array is Full");
		}


		public void displayArray() {
			// print the array
			System.out.print("Array: ");
			for (int i = 0; i < itemCount; i++)
				System.out.print(array[i] + " ");
			System.out.println();
		}
		
		
		public int CountUpDown(){
			
			boolean up = false ; // [3,2,5]
			if (array[0] < array[1]) up = true ;
			else up = false ; 
			int count = 0 ; // up = true -> tale3 
			
			for (int i = 0 ; i < array.length - 1; i++){
				if (array[i] < array[i+1] && up == false){
					count++ ; 
					up = true ; 
				}
				if (array[i] > array[i+1] && up == true){
					count++ ; 
					up = false ; 
				}
			}
			return count ; 
		}
		public int CountUpDown2(){
			int count = 0 ; 
			
			for (int i = 1 ; i < array.length - 1 ; i++){
				if (array[i-1] < array[i] 
				&& array[i] > array[i+1]) count++ ;
				
				if (array[i-1] > array[i] 
				&& array[i] < array[i+1]) count++ ;
			}
			return count ;
			
		}
		
		public int compareArrays(LinearArray arr){
			int count = 0 ; 
			for (int i = 0 ; i < array.length ; i++){
				if (array[i] == arr.array[i]) count++ ; 
			}
			return count ; 
		}
}
