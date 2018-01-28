import java.io.*;  
import java.net.*;  
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class UTLConnectionExample  /*implements ActionListener*/{
	//JCheckBox cb1,cb2, cb3;
	
	
	//public UTLConnectionExample(){

JMenu menu, submenu;  
          JMenuItem i1, i2, i3, i4, i5;  
public UTLConnectionExample(){ 
          JFrame f= new JFrame("Menu and MenuItem Example");  
          JMenuBar mb=new JMenuBar();  
          menu=new JMenu("Menu");  
          submenu=new JMenu("Sub Menu");  
          i1=new JMenuItem("Item 1");  
          i2=new JMenuItem("Item 2");  
          i3=new JMenuItem("Item 3");  
          i4=new JMenuItem("Item 4");  
          i5=new JMenuItem("Item 5");  
          menu.add(i1); menu.add(i2); menu.add(i3);  
          submenu.add(i4); submenu.add(i5);  
          menu.add(submenu);  
          mb.add(menu);  
          f.setJMenuBar(mb);  
          f.setSize(400,400);  
          f.setLayout(null);  
          f.setVisible(true);  
          }
            
	
	public static void main(String[] args){  
	
		 UTLConnectionExample uc = new UTLConnectionExample();		
		
		
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); */ 
	}

}