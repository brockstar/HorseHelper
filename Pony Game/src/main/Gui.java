package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mechanics.Dialogue;

public class Gui {

	public static void main(String[] args) {
		Runnable runner = new Runnable() {
			public void run() {

				// initialize model objects
				Gamestate gs = new Gamestate();

				// create frame
				JFrame frame = new JFrame("Pony Game");

				frame.setSize(new Dimension(700, 700));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				// create content panel
				JPanel mainPanel = new JPanel(new BorderLayout());
				frame.add(mainPanel);

				PCPanel pcPanel = new PCPanel(gs.pc);

				mainPanel.add(pcPanel, BorderLayout.WEST);

				DialoguePanel dialoguePanel = new DialoguePanel();
				mainPanel.add(dialoguePanel, BorderLayout.CENTER);
				dialoguePanel.update(null, Gui.createTestDialogue());

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

	public static Dialogue createTestDialogue() {

		Dialogue aj1 = new Dialogue("Start", "AppleJack",
				"Hey there, Sugarcube. Ready to help me buck them apples?");
		Dialogue pc1yes = new Dialogue("Sure!", "Player Character",
				"Sure thing, AJ. You are the best pone, afterall.");
		Dialogue pc1no = new Dialogue("Nah", "Player Character",
				"I don't think so. I'm not all that into farm stuff.");
		Dialogue aj2a = new Dialogue(
				"Next",
				"Applejack",
				"Well that's swell, 'cause we got a whole heap of 'em \nready for ya, when you feel like startin'.");
		Dialogue aj2b = new Dialogue(
				"Next",
				"Applejack",
				"You sure? Cause there's plenty of work ta be done 'round here. I'd hate ta hafta take care of this all by m'lonesome.");
		Dialogue pc2aReady = new Dialogue("Ready!", "Player Character",
				"I'm ready when you are, Applejack!");
		Dialogue pc2aNot = new Dialogue("How?", "Player Character",
				"What is is that you want me to do?");
		Dialogue pc2bYes = new Dialogue("Fine", "Player Character",
				"Alright, fine. Let's get this over with.");
		Dialogue pc2bNo = new Dialogue(
				"Nope",
				"Player Character",
				"I said I don't feel like it. I've got better things to be doing right now, anyway.");
		Dialogue aj3a = new Dialogue("Next", "Applejack",
				"Great! Let's get 'er done!");
		Dialogue aj3b = new Dialogue(
				"Next",
				"Applejack",
				"You come by with the basket while I give these trees a kickin'. We'll work up a good sweat!");
		Dialogue aj3c = new Dialogue(
				"Next",
				"Applejack",
				"Well don't let me keep you then. A little hard work never killed anypony, you know.");

		aj1.addOption(pc1yes);
		aj1.addOption(pc1no);
		pc1yes.addOption(aj2a);
		pc1no.addOption(aj2b);
		aj2a.addOption(pc2aReady);
		aj2a.addOption(pc2aNot);
		aj2b.addOption(pc2bYes);
		aj2b.addOption(pc2bNo);
		pc2aReady.addOption(aj3a);
		pc2aNot.addOption(aj3b);
		pc2bYes.addOption(aj2a);
		pc2bNo.addOption(aj3c);
		aj3b.addOption(pc2aReady);

		return aj1;
	}
}
