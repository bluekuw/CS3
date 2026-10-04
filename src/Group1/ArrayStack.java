package Group1 ; 
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
		ArrayStack even = new ArrayStack(x.size()/2+2);
		ArrayStack odd = new ArrayStack(x.size()/2+2);
		
		int pos = 1 ; 
		while (!x.isEmpty()){
			int elem = x.pop();
			if (pos % 2 == 0) even.push(elem);
			else odd.push(elem);
			pos++ ; 
		}

		while (!even.isEmpty()){
			int elem = even.pop();
			x.push(elem);
		}
		
		
		ArrayStack y = new ArrayStack(odd.size()+2);

		while (!odd.isEmpty()){
			y.push(odd.pop());
		}
		

		return y ; 
	}
	
	public static void main (String [] args){
		ArrayStack x = new ArrayStack(100);
		x.push(6);
		x.push(9);
		x.push(3);
		x.push(5);
		x.push(4);
		x.push(1);
		x.push(2);
		x.push(7);
		
		ArrayStack y = decompose(x);

		
		x.printStack();
		y.printStack();
	}
	
	public static boolean check(ArrayStack x){
		ArrayStack top = new ArrayStack(x.size());
		ArrayStack bottom = new ArrayStack(x.size());
		
		int size = x.size();
		int sum1 = 0 ; 
		int sum2 = 0 ; 
		
		for (int i = 0 ; i < size / 2 ; i++){
			sum1 += x.top();
			top.push(x.pop());
		}
		if (size % 2 == 1) top.push(x.pop());
		
		for (int i = 0 ; i < size / 2 ; i++){
			sum2 += x.top();
			bottom.push(x.pop());
		}
		
		while (!bottom.isEmpty()) x.push(bottom.pop());
		while (!top.isEmpty()) x.push(top.pop());
		
		return sum1 == sum2 ; 
	}
	
	


}