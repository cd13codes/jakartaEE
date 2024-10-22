package finalpractice;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class student{
	String name,usn,category;
	int age;
	double sgpa1,sgpa2,sgpa3,sgpa4;
	
	public student(String name,String usn,String category,int age,double sgpa1,double sgpa2,double sgpa3,double sgpa4) {
		this.name=name;
		this.usn=usn;
		this.category=category;
		this.age=age;
		this.sgpa1=sgpa1;
		this.sgpa2=sgpa2;
		this.sgpa3=sgpa3;
		this.sgpa4=sgpa4;
		
	}
	@Override
	public String toString() {
		 return "[Name: " + name + ", USN: " + usn + ", Age: " + age + ", category: " + category + 
	               ", SGPA1: " + sgpa1 + ", SGPA2: " + sgpa2 + ", SGPA3: " + sgpa3 + ", SGPA4: " + sgpa4 + "]\n";}
	
}

public class cgpa extends JFrame implements ActionListener{
	JTextField name,age,usn,sgpa1,sgpa2,sgpa3,sgpa4,category;
	JButton display,done,compute;
	JTextArea displayarea;
	
	 List<student> studs = new ArrayList<>();

   public cgpa() {
	  
	   
	   add(new JLabel("name:"));
	   name = new JTextField();
	   add(name);
	   
	   add(new JLabel("usn:"));
	   usn = new JTextField();
	   add(usn);
	   
	   add(new JLabel("age:"));
	   age = new JTextField();
	   add(age);
	   
	   add(new JLabel("category:"));
	   category = new JTextField();
	   add(category);
	  
	   add(new JLabel("sgpa1:"));
	   sgpa1 = new JTextField();
	   add(sgpa1);
	  
	   add(new JLabel("sgpa2:"));
	   sgpa2 = new JTextField();
	   add(sgpa2);
	   
	   add(new JLabel("sgpa3"));
	   sgpa3 = new JTextField();
	   add(sgpa3);
	   
	   add(new JLabel("sgpa4"));
	   sgpa4 = new JTextField();
	   add(sgpa4);
	   
	   
	   display = new JButton("display:");
	   compute = new JButton("compute:");
	   done = new JButton("done:");
	   
	   add(display);
	   add(compute);
	   add(done);
	   
	   displayarea=new JTextArea();
	   add(displayarea);
	   
	   display.addActionListener(this);
	   compute.addActionListener(this);
	   done.addActionListener(this);
	   
	   setSize(1000, 1000);
	   setTitle("Student Information");
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setVisible(true);
	   setLayout(new GridLayout(12,2));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==display) {
			display();
		}
		else if(e.getSource()==compute) {
			compute();
		}
		else if (e.getSource()==done) {
			done();
		}
	}
   private void done() {
		String name1 = name.getText();
		String usn1 = usn.getText();
		String category1 =category.getText();
		int age1 = Integer.parseInt(age.getText());
		double sgp1 = Double.parseDouble(sgpa1.getText());
		double sgp2 = Double.parseDouble(sgpa2.getText());
	    double sgp3 = Double.parseDouble(sgpa3.getText());
		double sgp4 = Double.parseDouble(sgpa4.getText());
		
		try {
			studs.add(new student(name1,usn1,category1,age1,sgp1,sgp2,sgp3,sgp4));
			JOptionPane.showMessageDialog(this,"done with insertion, thankyou!!!!");
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this,"enter valid details in sgpa fields");
		}
		
			
		
			
	}

private void compute() {
		
	    try {
	    double sgp1 = Double.parseDouble(sgpa1.getText());
		double sgp2 = Double.parseDouble(sgpa2.getText());
		double sgp3 = Double.parseDouble(sgpa3.getText());
		double sgp4 = Double.parseDouble(sgpa4.getText());
		
		
		double cgpa=(sgp1+sgp2+sgp3+sgp4)/4;
		JOptionPane.showMessageDialog(this,"cgpa"+cgpa);}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this,"enter valid details in sgpa fields");
		}
	}

private void display() {
	displayarea.setText(studs.toString());
		
	}

public static void main(String[] args) {
		new cgpa();
	}
}
