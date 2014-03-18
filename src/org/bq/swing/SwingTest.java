package org.bq.swing;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingTest {
		public static void main(String[] args) {
			JFrame jf=new JFrame();
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setLocation(100, 78);
			jf.setSize(800,600);
			jf.setTitle("Swing--Hello");
			jf.setLayout(new FlowLayout());
			Button btn=new Button("Start");
			final JLabel jl=new JLabel();
			final JTextField jtf=new JTextField(10);
			jf.add(btn);
			jf.add(jl);
			jf.add(jtf);
			btn.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					jl.setText(jtf.getText());
				}
			});
			jf.setVisible(true);
		}
}
