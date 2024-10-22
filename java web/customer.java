package finalpractice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class customer extends JFrame implements ActionListener{

	private static final String URL= "jdbc:mysql://localhost:3306/customer";
	private static final String USER= "root";
	private static final String PASSWORD= "chiru@26";

    JTextField custname,state,cred;
    JButton insert,display;
    
	
	
	public customer() {
		custname=new JTextField();
		state=new JTextField();
		cred=new JTextField();
	
		insert=new JButton("insert");
		display=new JButton("display");
		
		
		add(new JLabel("name:"));
		add(custname);
		add(new JLabel("state:"));
		add(state);
		add(new JLabel("cred:"));
		add(cred);
		add(insert);
		add(display);
		
		insert.addActionListener(this);
		display.addActionListener(this);
		
		setVisible(true);
		setSize(1000,1000);
		setLayout(new GridLayout(4,2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		
		
		
		
		

		
	}
 public static void main(String[] args) {
	 new customer();
		
	}
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==insert) {
		insert();
	}
	else if(e.getSource()==display) {
		display();
	}
}
private void display() {
	
	try {
		Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
		String query = String.format("select * from customer;");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		StringBuilder sb = new StringBuilder();
		while(rs.next()) {
			sb.append(rs.getString("name")).append(" ").append("state").append(" ").append("credlimit").append("\n________________");
			JOptionPane.showMessageDialog(this, sb.toString());
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
		JOptionPane.showMessageDialog(this,"error");
	}
	
}
private void insert() {
	String n = custname.getText();
	String s = state.getText();
	String c = cred.getText();
	
	try {
		Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
		String query = String.format("INSERT INTO CUSTOMER(NAME,STATE,CREDLIMIT)VALUES('%s','%s','%s');",n,s,c);
		Statement st = con.createStatement();
        st.execute(query);
        JOptionPane.showMessageDialog(this,"inserted");
        
	} catch (SQLException e) {
		
		e.printStackTrace();
		JOptionPane.showMessageDialog(this,"error");
	}
	
}

}
