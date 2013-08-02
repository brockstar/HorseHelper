package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import characters.PlayerCharacter;

public class Gui {

	public static void main(String[] args) {
		Runnable runner = new Runnable() {
			public void run() {

				//initialize model objects
				PlayerCharacter pc = new PlayerCharacter();

				//create frame
				JFrame frame = new JFrame("Pony Game");

				frame.setSize(new Dimension(500, 300));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				//create content panel
				JPanel mainPanel = new JPanel(new BorderLayout());
				frame.add(mainPanel);

				PCPanel pcPanel = new PCPanel(pc);

				mainPanel.add(pcPanel, BorderLayout.NORTH);

				JPanel rightSamplePanel = new JPanel();
				rightSamplePanel.setBorder(BorderFactory
						.createTitledBorder("Sample right Panel"));
				rightSamplePanel.add(new JButton("Sample Button 1"));
				rightSamplePanel.add(new JButton("Sample Button 2"));

				JScrollPane rightScrollPane = new JScrollPane(rightSamplePanel);

				JPanel leftSamplePanel = new JPanel();
				leftSamplePanel.setBorder(BorderFactory
						.createTitledBorder("Sample Left Panel"));
				leftSamplePanel.add(new JButton("Sample Button 1"));
				leftSamplePanel.add(new JButton("Sample Button 2"));
				JScrollPane leftScrollPane = new JScrollPane(leftSamplePanel);

				JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
						leftScrollPane, rightScrollPane);

				mainPanel.add(splitPane, BorderLayout.CENTER);

				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		};
		EventQueue.invokeLater(runner);
	}
}
