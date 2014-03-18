/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author °×Ç¿
 * @version 1.0
 */
public class Calculator {
			public static void main(String[] args) {
				new CalFrame().show();
			}
}
class CalFrame implements ActionListener{
	private JFrame mainFrame;
	private JTextField text;
	private JButton[] buttons;
	private char modifier='\0';
	private double result;
	private boolean flag=false;
	
	public void show() {
		mainFrame.pack();
		mainFrame.setLocation(150, 100);
		mainFrame.setSize(800,400);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(3);
	}
	public CalFrame(){
		mainFrame=new JFrame("¼ÆËãÆ÷------------°×Ç¿");
		text=new JTextField();
		buttons=new JButton[16];
		init();
		setFontClolor();
		addEventHandle();
	}
	
	private void init() {
		JPanel north=new JPanel();
		JPanel center=new JPanel();
		north.setLayout(new FlowLayout());
		center.setLayout(new GridLayout(4, 4, 2, 2));
		text=new JTextField(25);
		north.add(text);
		String str="123+456-789*0.=/";
		for(int i=0;i<16;i++){
			JButton jb=new JButton(String.valueOf(str.charAt(i)));
			buttons[i]=jb;
			center.add(jb);
		}
		mainFrame.add(north,BorderLayout.NORTH);
		mainFrame.add(center,BorderLayout.CENTER);
	}
	private void setFontClolor() {
		Font f=new Font("Î¢ÈíÑÅºÚ",Font.BOLD,20);
		text.setFont(f);
		for(int i=0;i<buttons.length;i++){
			buttons[i].setFont(f);
			buttons[i].setForeground(Color.BLUE);
		}
	}
	private void addEventHandle() {
		for(int i=0;i<buttons.length;i++){
			buttons[i].addActionListener(this);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String str=e.getActionCommand();
		if("0123456789.".indexOf(str)!=-1){
			if(flag){
				text.setText("");
				flag=false;
			}
			text.setText(text.getText()+str);
		}
		else if("+-*/".indexOf(str)!=-1){
			modifier=str.charAt(0);
			double num=Double.valueOf(text.getText());
			result=num;
			flag=true;
		}
		else if(str.charAt(0)=='='){
			if(modifier=='+'){
				double num=Double.valueOf(text.getText());
				result+=num;
			}
			if(modifier=='-'){
				double num=Double.valueOf(text.getText());
				result-=num;
			}
			if(modifier=='*'){
				double num=Double.valueOf(text.getText());
				result*=num;
			}
			if(modifier=='/'){
				double num=Double.valueOf(text.getText());
				result/=num;
			}
			text.setText(result+"");
			modifier='\0';
			result=0;
		}
	}
	
	
}
