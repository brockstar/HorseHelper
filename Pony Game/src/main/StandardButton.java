package main;

import java.awt.Dimension;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class StandardButton extends JButton{
	
	final static Dimension BUTTONSIZE = new Dimension(100,50);
	
	public StandardButton(String input){
		super(input);
		setMaximumSize(BUTTONSIZE);
		setMinimumSize(BUTTONSIZE);
		setPreferredSize(BUTTONSIZE);
	}
}
