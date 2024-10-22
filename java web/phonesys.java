package finalpractice;

import java.time.LocalDateTime;
import java.util.*;
class call{
	String callnum;
	String callname;
	LocalDateTime time;
	
	public call(String callname,String callnum,LocalDateTime time) {
		this.callname=callname==null ? "privatecaller":callname;
		this.callnum=callnum;
		this.time=time;
	}
	
	public String getcallnum() {
		return callnum;
	}
	
	@Override
	public String toString() {
		return "callname:"+callname+",callnum:"+callnum+",time:"+time+"/n";}
}

public class phonesys {
         LinkedList<call>missedcalls=new LinkedList<>();
         void addcall(String callname,String callnum,LocalDateTime time) {
        	 missedcalls.add(new call(callname==null? null:callname,callnum,time));
         }
         void delcall(String phonenum) {
        	 boolean del = missedcalls.removeIf(call->call.getcallnum().equals(phonenum));
        	 if(del=true) {
        		 System.out.println("missedcall deleted");
        	 }
        	 else {
        		 System.out.println("missedcall not present");
        	 }
         }
         void display() {
        	 for (int i=0 ;i<missedcalls.size();i++) {
        		 System.out.println((i+1)+". missedcall:"+missedcalls.get(i));
        	 }
        	 
         }
         
        public static void main (String [] args) {
        	phonesys ps = new phonesys();
        	ps.addcall(null, "123", LocalDateTime.now());
        	ps.addcall("null", "124", LocalDateTime.now());
        	ps.display();
        	ps.delcall("123");
        	ps.display();
        	
        }
         
}

