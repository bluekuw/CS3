public class CoolArray {
	
	int [] arr ; 
	int count ; 
	
	public CoolArray (int size) {
		this.arr = new int[size] ;
		count = 0 ; 
	}
	
	public void insertLast(int key){
		if (count >= arr.length){
			System.out.println("Array is full");
		}else {
			arr[count] = key ; 
			count++ ; 
		}
	}
	
	public void insertFirst (int key){
		if (count >= arr.length){
			System.out.println("Array is full");
		}else {
			for (int i = count ; i > 0 ; i--){
				arr[count] = arr[count-1] ; 
			}
			arr[0] = key ; 
			count++ ; 
		}
	}
	
	public int linearSearch(int key){
		for (int i = 0 ; i < arr.length ; i++){
			if (arr[i] == key) return i ; 
		}
		return -1 ; 
	}
	
	public void delete (int key){
		int index = linearSearch(key);
		if (index == -1){
			System.out.println("item not found");
			return ;
		}
		
		for (int i = index ; i < count ; i++){
			arr[i] = arr[i+1] ; 
		}
		count-- ; 
	}
	
	public boolean binarySearch (){
		for (int i = 0 ; i < arr.length ; i++){
			int key = arr[i] * -1 ; 
			int lower = 0 ; 
			int upper = arr.length - 1 ; 
			while (lower <= upper){
				int mid = (lower + upper) / 2 ;
				if (key == arr[mid] && mid != i) return true ; 
				if (key > arr[mid]){
					lower = mid + 1 ; 
				}else {
					upper = mid - 1 ; 
				}
			}
		}
		return false ; 
	}
	
	public boolean hasTwoSumZero(){
		
		int low = 0 ; 
		int high = arr.length - 1 ; 
		
		while (low < high){
			if (arr[high] + arr[low] == 0) return true ; 
			if (arr[high] > -arr[low]){
				high-- ; 
			}else {
				low++ ; 
			}
		}
		return false ; 
	}
	
	public int countStairs (){
		for (int i = 0 ; i < arr.length - 2 ; i++){
			if (arr[i] < arr[i+1] && arr[i+1] < arr[i+2]) 
				count++ ; 
		}
		return count ; 
	}
	
	public static void main (String [] args){
		
	}
	
	public int longestSeq(){
		for (int i = 0 ; i < arr.length - 1 ; i++){
			for (int j = 0 ; j < arr.length - 1 - i ; j++){
				if (arr[j] > arr[j+1]){
					int temp = arr[j] ; 
					arr[j] = arr[j+1] ; 
					arr[j+1] = temp ; 
				}
			}
		}
		int max = -1 ; 
		int curr = 1 ;
		for (int i = 0 ; i < arr.length - 1 ; i++){
			if (arr[i] + 1 == arr[i+1]){
				curr++ ;
			}else {
				if (curr > max) max = curr ; 
				curr = 1 ; 
			}
		}
		return max ; 
	}
	
}