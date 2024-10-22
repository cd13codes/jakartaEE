package finalpractice;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class representative extends JFrame implements ActionListener {
	
	private static final String URL = "jdbc:mysql://localhost:3306/customerdb";
	private static final String USER="root";
	private static final String PASSWORD="chiru@26";
	
	JTextField repno,repname,repstate,comm,rate;
	JButton insert,display;


	public static void main(String[] args) {
		new representative();
	}

	/**
	 * Create the frame.
	 */
	public representative() {
		
repno = new JTextField();
	 repname = new JTextField();
		repstate = new JTextField();
		 comm = new JTextField();
		 rate = new JTextField();
		
		add(new JLabel("repno:"));
		add(repno);
		add(new JLabel("repname:"));
		add(repname);
		add(new JLabel("repstate:"));
		add(repstate);
		add(new JLabel("comm:"));
		add(comm);
		add(new JLabel("rate:"));
		add(rate);
		
		
		 insert = new JButton("insert");
		 display= new JButton("display");
		
		
		add(insert);
		add(display);
		
		
		
		insert.addActionListener(this);
		display.addActionListener(this);
		
		
		
		setVisible(true);
		setLayout(new GridLayout(6,2));
		setSize(1000,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
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
				String query = "select * from representative;";
				Statement st = con.createStatement();
				ResultSet rs= st.executeQuery(query);
				StringBuilder sb = new StringBuilder ();
				while(rs.next()) {
					sb.append(rs.getString("RepNo")).append("\n").append(rs.getString("RepName")).append("\n").append(rs.getString("State")).append("\n").append(rs.getString("Commission")).append("\n").append(rs.getString("Rate")).append("\n").append("___________________________________________________\n");                                      
				}
				JOptionPane.showMessageDialog(this,sb.toString());
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(this,"error");
			
			
		}
		
	}

	private void insert() {
		try {
		String repno1 = repno.getText();
		String repname1 = repname.getText();
		String repstate1 = repstate.getText();
		String comm1 = comm.getText();
		String rate1 =rate.getText();
			
			
			Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
			String query = String.format("insert into representative values ('%s','%s','%s','%s','%s');",repno1,repname1,repstate1,comm1,rate1);
			Statement st = con.createStatement();
			st.execute(query);
			JOptionPane.showMessageDialog(this,"inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,"error");
		
		
	}
}}
