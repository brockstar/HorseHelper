package main;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DisplayPanel extends JPanel{

	JEditorPane ep  = new JEditorPane();
	JScrollPane sp = new JScrollPane(ep);
	
	public DisplayPanel(){
		setLayout(new GridLayout(0,1));
		sp.setPreferredSize(new Dimension(100,100));
		add(sp);
		
	}
	
}
