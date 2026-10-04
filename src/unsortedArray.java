
public class unsortedArray {
	int [] arr ; 
	int last ; 
	
	public unsortedArray(int maxSize){
		arr = new int[maxSize] ; 
		last = 0 ; // first empty cell 
		
	}
	
	public void insertLast (int x){
		if (last == arr.length){
			System.out.println("arr is full");
			return ; 
		}
		arr[last] = x ;
		last++ ; 
	}
	
	public void inserFirst(int x){
		if (last == arr.length){
			System.out.println("arr is full");
			return ; 
		}
		for (int i = last - 1 ; i >= 0 ; i--){
			arr[i+1] = arr[i];
		}
		arr[0] = x ; 
		last++ ;
	}
	
	public int linearSearch (int x){
		for (int i = 0 ; i < last ; i++){
			if (arr[i] == x){
				return i ; 
			}
		}
		return -1 ; 
	}
	
	public void delete (int x){
		int index = linearSearch(x);
		if (index == -1){
			System.out.println("item not found");
			return ; 
		}
		
		for (int i = index + 1 ; i <= last - 1 ; i++){
			arr[i-1] = arr[i];
		}
		last-- ; 
	}
	
	public void display(){
		for (int i = 0 ; i < last ; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main (String [] args){
		unsortedArray arr = new unsortedArray(10);
//		
//		arr.insertLast(8);
//		arr.insertLast(9);
//		arr.insertLast(10);
//		
//		arr.display();
//		arr.inserFirst(5);
//		arr.display();
//		arr.delete(8);
//		arr.display();
//		
		int [] array = {9,5,7,3,2};
		selectionSort(array);
		
		for (int i = 0 ; i < array.length ; i++){
			System.out.print(array[i]+ " ");
		}

	}
	
	public static int binarySearch (int [] arr, int x){
		
		int first = 0 ; 
		int last = arr.length - 1 ; 
		
		while (first <= last){
			int mid = (first + last) / 2 ; 
			if (arr[mid] == x) return mid ; 
			else {
				if (x > arr[mid]){
					first = mid + 1 ; 
				}else {
					last = mid - 1 ; 
				}
			}
		}
		return -1 ; 
	}
	
	public static int binarySearchRec(int first, int last, int arr[], int x){
		int mid = (first + last) / 2 ; 
		if (arr[mid] == x) return mid ;
		if (first > last) return -1 ; 
		
		if (arr[mid] > x) return binarySearchRec(mid+1, last, arr, x);
		else return binarySearchRec(first, mid-1, arr, x);
	}
	
	
	public static void selectionSort(int [] arr){
		for (int i = 0 ; i < arr.length ; i++){ 
			// i select the minimum to put it in index i 
			int min = 999999999 ; 
			int index = i ; 
			for (int j = i ; j < arr.length ; j++){
				if (arr[j] < min){
					min = arr[j] ; 
					index = j ; 
				}
			}
			// swap arr[i], arr[index]
			int temp = arr[i] ; 
			arr[i] = arr[index];
			arr[index] = temp ; 
		}
	}

}
