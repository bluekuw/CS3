package Group1;

public class Student {
	String name; 
	int age ; 
	double gpa ; 
	
	public Student (String name, int age, double gpa){
		this.name = name ; 
		this.age = age ; 
		this.gpa = gpa ; 
	}
	
	public static double AvgGpa (StackObj st){
		
		double avg = 0 ; 
		double size = st.size();
		while (!st.isEmpty()){
			Student s = (Student) st.pop();
			avg += s.gpa ;
		}
		return avg / size ; 
	}
	public static void main (String [] args){
		StackObj st = new StackObj(10);
		st.push(new Student("Maya", 20, 1));
		st.push(new Student("Maya", 20, 2));

		;
		System.out.println(AvgGpa(st));
	}
	
	public static double calculatePostfix (String s){
		
		StackObj st = new StackObj(s.length());
		
		for (int i = 0 ; i < s.length(); i++){
			if (s.charAt(i) == '*'){
				double y = (Double) st.pop();
				double x = (Double) st.pop();
				double result = x * y ;
				st.push(result);
			}else if (s.charAt(i) == '-'){
				double y = (Double) st.pop();
				double x = (Double) st.pop();
				double result = x - y ;
				st.push(result);
			}else {
				st.push(s.charAt(i) - '0');
			}
		}
		return (Double) st.pop();
		
	}
	
	public static String infixToPostfix(String s){
		StackObj st = new StackObj(s.length());
		String result = "" ; 
		
		for (int i = 0 ; i < s.length() ; i++){
			if (s.charAt(i) == '*' || s.charAt(i) == '+'){
				while (!st.isEmpty() 
				&& getPriority((char) st.top()) >= getPriority(s.charAt(i))){
					result += st.pop();
				}
				st.push(s.charAt(i));
			}else {
				result += s.charAt(i);
			}
		}
		return result ; 
	}
	
	public static int getPriority(char c){
		if (c == '*' || c == '/') return 2 ; 
		else if (c == '+' || c == '-') return 1 ; 
		else return 0 ; 
	}

}
