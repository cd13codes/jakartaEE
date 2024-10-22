package finalpractice;
import java.util.*;
public class generics {
	
	static class stack1<t>{
		ArrayList<t> stack = new ArrayList<>();
		int maxsize;
		public stack1(int maxsize) {
			this.maxsize=maxsize;
		}
		
		void add(t ele) {
			if(stack.size()>maxsize) {
				System.out.println("stack full");
			}
			else
				stack.add(ele);
		}
		
		void pop() {
			if(stack.isEmpty()) {
				System.out.println("stack empty");
			}
			else {
				stack.remove(stack.size()-1);
			}
		}
		
		void isempty() {
			if(stack.isEmpty()) {
				System.out.println("stack empty");
				
			}
			else {
				System.out.println("stack not empty");
			}
		}
		void clear() {
			stack.clear();
		}
		void display() {
			System.out.println(stack);
		}
		
		
		
		
		
		
	}

	public static void main(String[] args) {
             stack1 <Integer> sint = new stack1<>(5);
             sint.add(1);
             sint.add(1);
             sint.add(1);
             sint.add(1);
             sint.add(1);
             sint.add(1);
             sint.add(1);
             sint.pop();
             sint.isempty();
             sint.display();
             sint.clear();
             sint.display();

	}

}
