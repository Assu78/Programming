import java.io.*;  
import java.net.*;  
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class IPFinder extends Frame {  
	JButton b;
	JLabel l;
	JTextField tf;

	public UTLConnectionExample(){
		b = new JButton("Find IP");
		b.setBounds(50,250,95,30);

		tf = new JTextField();
		tf.setBounds(50,100,150,20);

		l = new JLabel();
		l.setBounds(50,150,250,20);

		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				/*Scanner lukija  = new Scanner(System.in);
				String word = lukija.netLine(); 
				String ww =tf.setText(word);*/
				try{
					String host = tf.getText();
					InetAddress ip = InetAddress.getByName(host);
					l.setText("IP of " + host + " is "  + ip.getHostAddress());
				}catch(Exception ex){
					System.out.println(ex.getMessage());

				}
			}
		});
		add(b);
		add(tf);
		add(l);
		setSize(400, 400);
		setLayout(null);
		setVisible(true);


	}	

	public static void main(String[] args){  

		UTLConnectionExample ut = new UTLConnectionExample();		
	}
}