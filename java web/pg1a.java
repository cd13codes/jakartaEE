package finalpractice;
import java.util.*;

public class pg1a {
	
	private static int frequency(String src,String sub) {
		int count = 0;
		if(src.isEmpty()||sub.isEmpty()||src==null||sub==null) {
			return 0;
		  }
		for (int pos = 0 ; (pos=src.indexOf(sub,pos))!=-1;count++) 
			
			pos+=sub.length();
		   
		
		     return count;
		
		
		
		
		
	}
	
	
	
	

	public static void main(String[] args) {
	    int f=frequency("dededededede","de");
		System.out.println(f);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the first string");
		String str1=sc.nextLine();
		System.out.println("eneter the second string");
		String str2=sc.nextLine();
		char[] ch1 = str1.toLowerCase().toCharArray();
		char[] ch2 = str2.toLowerCase().toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		if(Arrays.equals(ch1, ch2)) {
			System.out.println("yes they are anagrams");
		}
		else {
			System.out.println("no they arent anagrams");
		}
	   
	}

}
