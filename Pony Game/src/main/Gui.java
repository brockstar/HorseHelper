package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mechanics.Ability.AbilityType;
import mechanics.Dice;
import mechanics.Dice.Result;
import characters.PlayerCharacter;

public class Gui {

	public static void main(String[] args) {
		Runnable runner = new Runnable() {
			public void run() {

				// initialize model objects
				PlayerCharacter pc = new PlayerCharacter();

				// create frame
				JFrame frame = new JFrame("Pony Game");

				frame.setSize(new Dimension(500, 300));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				// create content panel
				JPanel mainPanel = new JPanel(new BorderLayout());
				frame.add(mainPanel);

				PCPanel pcPanel = new PCPanel(pc);

				mainPanel.add(pcPanel, BorderLayout.WEST);

				JPanel centerpanel = new JPanel();

				
				ButtonPanel bp = new ButtonPanel(pc);
				mainPanel.add(bp, BorderLayout.EAST);

				DisplayPanel dp = new DisplayPanel();
				

				mainPanel.add(dp, BorderLayout.SOUTH);

				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		};
		EventQueue.invokeLater(runner);
	}
}
