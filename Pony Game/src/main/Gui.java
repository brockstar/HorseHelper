package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mechanics.GameDate;
import characters.PlayerCharacter;

public class Gui {

	public static void main(String[] args) {
		Runnable runner = new Runnable() {
			public void run() {

				// initialize model objects
				Gamestate gs = new Gamestate();
				
				// create frame
				JFrame frame = new JFrame("Pony Game");

				frame.setSize(new Dimension(500, 300));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				// create content panel
				JPanel mainPanel = new JPanel(new BorderLayout());
				frame.add(mainPanel);

				PCPanel pcPanel = new PCPanel(gs.pc);

				mainPanel.add(pcPanel, BorderLayout.WEST);

				JPanel centerpanel = new JPanel();

				CalenderPanel cp = new CalenderPanel(gs.cal);
				mainPanel.add(cp, BorderLayout.NORTH);

				ButtonPanel bp = new ButtonPanel(gs.pc);
				mainPanel.add(bp, BorderLayout.EAST);

				DisplayPanel dp = new DisplayPanel(gs);

				mainPanel.add(dp, BorderLayout.SOUTH);

				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		};
		EventQueue.invokeLater(runner);
	}
}
