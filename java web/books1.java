package finalpractice;

import java.util.*;
import java.util.stream.Collectors;



class book{
	int id;
	String title,author,publisher;
	int price;
	public book(int id,String title,String author ,String publisher,int price) {
		this.id=id;
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.price=price;
		
	}
	
	public String getauthor() {
		return author;
	}
	public String getpublisher() {
		return publisher;
	}
	public int getprice() {
		return price;
	}
	public int getid() {
		return id;
	}
	
	 @Override
	    public String toString() {
	    	return "book:{id:"+id+",author:"+author+",publisher:"+publisher+",title:"+title+",price:"+price+"}";
	    }
}
public class books1 {
	ArrayList <book> books=new ArrayList<>();
	List<book> sortedbooks=new ArrayList<>();
	public void sortbyprice() {
	sortedbooks=books.stream().sorted(Comparator.comparing(book::getprice)).collect(Collectors.toList());
	System.out.println(sortedbooks);
	}
	public void authoredbooks(String auth) {
        
		System.out.println(books.stream().filter(book->book.getauthor().equalsIgnoreCase(auth)).collect(Collectors.toList()));
	
	}
	public void addbook(int id,String title,String author,String publisher,int price) {
		books.add(new book(id,title,author,publisher,price));
	}
    public void pricedbooks(int p) {
        
		System.out.println(books.stream().filter(book->book.getprice()>p).collect(Collectors.toList()));
	
	}
    public void publishedbooks(String pub) {
        
		System.out.println(books.stream().filter(book->book.getpublisher().equalsIgnoreCase(pub)).collect(Collectors.toList()));
	
	}
    public void display() {
    	
    	System.out.println(books.stream().sorted(Comparator.comparing(book::getid)).collect(Collectors.toList()));
    	}
    
	
	public static void main(String [] args) {
		
		books1 p = new books1();
		p.addbook(1, "hithere", "chiru","ceng", 5000);
		p.addbook(2, "hithere", "chiru","ceng1", 5001);
		p.addbook(3, "hithere", "chiru1","ceng1", 5002);
		p.addbook(4, "hithere", "chiru2","ceng", 5007);
		p.addbook(5, "hithere", "chiru","ceng", 5004);
		
		p.display();
		p.publishedbooks("ceng");
		p.authoredbooks("chiru");
		p.sortbyprice();
		p.pricedbooks(5002);
		
		
	}

}
