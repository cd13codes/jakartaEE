package finalpractice;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class shoppy extends JFrame implements ActionListener {

	JTextField item,quantity;
	JButton display,calculate;
	JLabel itemname,cost;
	
	private HashMap<String,String>itemnames=new HashMap<>();
	private HashMap<String,Double>itemprices=new HashMap<>();
	
	public shoppy() {
		itemnames.put("1", "apple");
		itemnames.put("2", "banana");
		itemnames.put("3", "orange");
		itemprices.put("1",20.0 );
		itemprices.put("2", 30.0);
		itemprices.put("3",40.0 );
		
		
		itemname = new JLabel();
		cost = new JLabel();
		
	add(new JLabel("item id:"))	;
	item=new JTextField();
	add(item);
	add(new JLabel("quantity:"));
	quantity=new JTextField();
	add(quantity);
	add(itemname);
	add(cost);
	display=new JButton("display");
	calculate=new JButton("calculate");
	add(display);
	add(calculate);
	
	display.addActionListener(this);
	calculate.addActionListener(this);
	setVisible(true);
	setLayout(new GridLayout(4,2));
	setSize(1000,1000);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==display) {
			display();
		}
		else if(e.getSource()==calculate) {
			calculate();
		}
	}
	private void calculate() {
	   String itid = item.getText();
	   int quan = Integer.parseInt(quantity.getText());
	   if(itemnames.containsKey(itid)&&itemprices.containsKey(itid)) {
		   String itname = itemnames.get(itid);
		   double pr = itemprices.get(itid);
		   double cos = pr*quan;
		
		   itemname.setText(itname);
		   cost.setText("rs"+cos);
	   }
	   else {
		   JOptionPane.showMessageDialog(this,"enter correct id");
	   }
	}

	private void display() {
		String [] discounts = {"null", "10%","20%","30%"};
		String selecteddiscount = (String) JOptionPane.showInputDialog(this,"select","discounts",JOptionPane.PLAIN_MESSAGE,null,discounts,discounts[0]);
		double hi = switch(selecteddiscount) {
		case "10%"->0.10;
		case "20%"->0.20;
		case "30%"->0.30;
		default->0.0;
		};
		double prefinal = Double.parseDouble(cost.getText().replace("rs",""));
		double finalcost = prefinal*(1-hi);
		
		JOptionPane.showMessageDialog(this,"final cost after discount is:"+finalcost);
		
		
		
	}

	public static void main(String[] args) {
	new shoppy();
	}

}
