package PreImplemented ; 
public class ArrayStack {
	private int[] theStack;
	private int maxSize;
	private int top;

	public ArrayStack(int s) {
		maxSize = s;
		theStack = new int[maxSize];
		top = -1;
	}

	public void push(int elem) {
		top++;
		theStack[top] = elem;
	}

	public int pop() {
		int result = theStack[top];
		top--;
		return result;
	}

	public int top() {
		return theStack[top];
	}

	public boolean isFull() {
		return (top == (maxSize - 1));
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		return (top + 1);
	}

	public void printStack() {
		if (top == -1)
			System.out.println("Stack is empty!!\n");
		else {
			System.out.println(theStack[top] + " <- top");
			for (int i = top - 1; i >= 0; i--)
				System.out.println(theStack[i]);
			System.out.println();
		}
	}
	
	
	public static ArrayStack decompose(ArrayStack x){
		ArrayStack even = new ArrayStack(x.size());
		ArrayStack odd  = new ArrayStack(x.size());
		
		int pos = 1 ; 
		
		while (!x.isEmpty()){
			if (pos % 2 == 0) even.push(x.pop());
			else odd.push(x.pop());
			pos++ ; 
		}
		while (!odd.isEmpty()){
			x.push(odd.pop());
		}
		ArrayStack y = new ArrayStack(x.size());
		while (!even.isEmpty()){
			y.push(even.pop());
		}
		return y ; 
	}
	
	public static boolean check (ArrayStack x){
		ArrayStack top = new ArrayStack(x.size() / 2 + 1);
		ArrayStack bottom = new ArrayStack(x.size() / 2 + 1);
		int size = x.size();
		int sum1 = 0 ; 
		int sum2 = 0 ;
		for (int i = 0 ; i < size/2 ; i++){
			sum1 += x.top() ; 
			top.push(x.pop());
		}
		if (x.size() % 2 == 1) top.push(x.pop());
		while (!x.isEmpty()){
			int elem = x.pop() ; 
			sum2 += elem ; 
			bottom.push(elem);
		}
		while (!bottom.isEmpty()) x.push(bottom.pop());
		while (!top.isEmpty()) x.push(top.pop());
		
		return sum1 == sum2 ; 
	}


}