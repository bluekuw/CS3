package Group3;

public class Student {
	
	String name ; 
	double gpa ; 
	
	public Student (String name, double gpa){
		this.name = name ; 
		this.gpa = gpa ;
	}
	
	public static void main (String [] args){
		System.out.println(finalQuestion("aaabbbb"));
		
	}
	public static double avgGpa(StackObj st){
		
		double sum = 0 ; 
		int size = st.size() ; 
		while (!st.isEmpty()){
			
			Student s = (Student) st.pop();
			sum += s.gpa ; 
		}
		
		return sum / size ; 
	}
	
	public static int calculatePostfix (String s){
		ArrayStack st = new ArrayStack(s.length());
		
		for (int i = 0 ; i < s.length() ; i++){
			if (s.charAt(i) == '*'){
				int op2 = st.pop(); 
				int op1 = st.pop();
				int result = op1 * op2; 
				st.push(result);
			}else if (s.charAt(i) == '+'){
				int op2 = st.pop(); 
				int op1 = st.pop();
				int result = op1 + op2; 
				st.push(result);
			}else {
				st.push(Integer.parseInt(s.charAt(i) + "")); 
				// s.charAt(i) - '0' also works 
			}
		}
		return st.pop();
	}
	
	public static String infixToPostfix(String s){
		StackObj st = new StackObj(s.length());
		String result = "" ; 
		for (int i = 0 ; i < s.length() ; i++){
			char c = s.charAt(i);
			if (s.charAt(i) == '*' || s.charAt(i) == '+'){
				while (!st.isEmpty() && 
				getPriority((char)st.top()) >= getPriority(c)){
					result += st.pop();
				}
				st.push(c);
			}else {
				result += s.charAt(i);
			}
		}
		while (!st.isEmpty()) result += st.pop(); 
		return result ; 
	}
	
	public static int getPriority(char c){
		if (c == '*') return 2 ; 
		else if (c == '+') return 1 ; 
		else return 0 ; 
	}
	
	public static void Quiz (ArrayStack st){
		ArrayStack temp = new ArrayStack(st.size());
		while (!st.isEmpty()){
			int num = st.pop();
			if (!st.isEmpty() && 
			 (num == st.top() || Math.abs(num - st.top()) == 1) 
		     || !temp.isEmpty() && 
		        (num == temp.top() || (Math.abs(num - temp.top()) == 1))){
				 temp.push(num);
			 }
		}
		while (!temp.isEmpty()) st.push(temp.pop());
	}
	
	public static boolean brackets(String s){
		
		StackObj st = new StackObj(s.length());
		
		for (int i = 0 ; i < s.length() ; i++){
			if (s.charAt(i) == '(' || s.charAt(i) == '['){
				st.push(s.charAt(i));
			}else {
				if (s.charAt(i) == ')' && 
				(char) st.top() == '(') st.pop();
				
				else if (s.charAt(i) == ']' 
				&& (char) st.top() == '[') st.pop();
				else return false ; 
			}
		}
		return st.isEmpty() ; 
		
	}
	
	public static boolean finalQuestion(String s){
	// Given a string of abc, return true if count a == count b 
		
		StackObj st = new StackObj(s.length());
		
		for (int i = 0 ; i < s.length() ; i++){
			char c = s.charAt(i);
			if (c == 'c') continue ; 
			
			if (st.isEmpty()) st.push(c);
			else {
				if (c == 'a' && (char) st.top() == 'b') st.pop(); // a [] 
				else if (c == 'b' && (char) st.top() == 'a') st.pop();
				else if (c == 'a' && (char) st.top() == 'a') st.push(c);
				else if (c == 'b' && (char) st.top() == 'b') st.push(c);
			}	
		}
		return st.isEmpty() ; 
	}


}
