package Group3 ; 
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
	
	
	public static ArrayStack decompose (ArrayStack x){
		ArrayStack even = new ArrayStack(x.size()/2);
		ArrayStack odd = new ArrayStack(x.size()/2+1);
		
		int pos = 1 ; 
		while (!x.isEmpty()){
			if (pos % 2 == 0) even.push(x.pop());
			else odd.push(x.pop());
			pos++ ; 
		}
		ArrayStack y = new ArrayStack(x.size());
		
		while (!odd.isEmpty()) x.push(odd.pop());
		while (!even.isEmpty()) y.push(even.pop());
		
		return y ; 
	}
	
	public static boolean check (ArrayStack x){
		ArrayStack upper = new ArrayStack(x.size()/2+1);
		ArrayStack lower = new ArrayStack(x.size()/2+1);
		int size = x.size();
		int sum1 = 0 ; 
		int sum2 = 0 ; 
		for (int i = 0 ; i < size / 2 ; i++){
			sum1 += x.top();
			upper.push(x.pop());
		}
		if (size % 2 == 1) upper.push(x.pop());
		for (int i = 0 ; i < size / 2 ; i++){
			sum2 += x.top();
			lower.push(x.pop());
		}
		while (!lower.isEmpty()) x.push(lower.pop());
		while (!upper.isEmpty()) x.push(upper.pop());
		
		return sum1 == sum2 ; 
	}
	
	public static void main (String [] args){
		ArrayStack st = new ArrayStack(5);
		st.push(9);
		st.push(3);
		st.push(8);
		st.push(8);
		st.push(5);
		
		System.out.println(check(st));
	}
	
	public static void reverse3 (ArrayStack x){
		ArrayStack s1 = new ArrayStack(x.size());
		ArrayStack s2 = new ArrayStack(x.size());
		
		while (!x.isEmpty()) s1.push(x.pop());
		while (!s1.isEmpty()) s2.push(s1.pop());
		while (!s2.isEmpty()) x.push(s2.pop());

	}

}