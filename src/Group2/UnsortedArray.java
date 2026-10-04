package Group2;

public class UnsortedArray {
	
	int[] arr ; 
	int count ; 
	
	public UnsortedArray(int maxSize){
		arr = new int[maxSize] ; 
		count = 0 ;
	}
	
	public void insertLast (int key){
		if (count >= arr.length){
			System.out.println("Array is full");
			return ; 
		}
		arr[count] = key ; 
		count++ ; 
	}
	
	public void insertFirst (int key){
		if (count >= arr.length){
			System.out.println("Array is full");
			return ; 
		}
		for (int i = count - 1 ; i >= 0 ; i--){
			arr[i+1] = arr[i] ;
		}
		arr[0] = key ; 
		count++  ; 
	}
	
	public int linearSearch(int key){
		
		for (int i = 0 ; i < count ; i++){
			if (key == arr[i]) return i ; 
		}
		return -1 ; 
	}
	
	public boolean labQuestion(){
		for (int i = 0 ; i < arr.length ; i++){
			int key = -arr[i] ; 
			int low = 0 ; 
			int high = arr.length - 1 ; 
			
			while (low <= high){
				int mid = (low + high) / 2 ;
				
				if (arr[mid] == key) return true ; 
				else {
					if (key > arr[mid]) 
						low = mid + 1 ; 
					else 
						high = mid - 1 ; 
				}
			}			
		}
		return false ; 
	}
	
	public int binarySearch(int key){
		
		int low = 0 ; 
		int high = arr.length - 1 ; 
		
		while (low <= high){
			int mid = (low + high) / 2 ;
			
			if (arr[mid] == key) return mid ; 
			else {
				if (key > arr[mid]) 
					low = mid + 1 ; 
				else 
					high = mid - 1 ; 
			}
		}
		return -1 ; 
	}
	public boolean LabQuestion2(int key){
		int low = 0 ; 
		int high = arr.length - 1 ; 
		while (low < high){
			if (arr[low] + arr[high] == 0) return true ; 
			if (Math.abs(low) > Math.abs(high)){
				low++ ; 
			}else {
				high-- ; 
			}
		}
		return false ; 
	}
	
	public int LabQuestion3(){
		int count = 0 ; 
		for (int i = 0 ; i < arr.length - 2; i++){
			if (arr[i] < arr[i+1] && arr[i+1] < arr[i+2])
				count++ ; 
		}
		return count ; 
	}
	
	public int LabQuestion4(){
		
		for (int i = 0 ; i < arr.length - 1 ; i++){
			for (int j = 1 ; j < arr.length - i ; j++){
				if (arr[j-1] > arr[j]){
					int temp = arr[j-1] ; 
					arr[j-1] = arr[j] ; 
					arr[j] = temp ; 
				}
			}
		}
		
		int curr = 1 ; // 4 
		int max = -1 ; 
		
		for (int i = 0 ; i < arr.length -1 ; i++){
			if (arr[i] + 1 == arr[i+1]){
				curr++ ; 
			}else {
				if (curr > max) max = curr ; 
				curr = 1 ; 
			}
		}
		return max ; 
	}
	
	public void SelectionSort(){
		for (int i = 0 ; i < arr.length - 1 ; i++){
			int min = 999999999 ; 
			int index = -1 ; 
			for (int j = i ; j < arr.length ; j++){
				if (arr[j] < min){
					min = arr[j] ;
					index = j ; 
				}
			}
			int temp = arr[index]; 
			arr[index] = arr[i] ; 
			arr[i] = temp ; 
		}
	}
	

}
